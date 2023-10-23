package com.vapeshop.lab;


import com.vapeshop.chat.ChatMessage;
import com.vapeshop.chat.ChatMessageCodec;
import com.vapeshop.chat.ChatSession;
import com.vapeshop.entity.User;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.websocket.*;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.server.ServerEndpointConfig;

import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.*;

@ServerEndpoint(value = "/chatAll/{sessionId}",
        encoders = ChatMessageCodec.class,
        decoders = ChatMessageCodec.class,
configurator = ChatEndpoint.EndpointConfigurator.class
)
@WebListener
public class ChatEndpoint implements HttpSessionListener {
    private static  final String HTTP_SESSION_PROPERTY="com.vapeshop.ws.HTTP_SESSION";

    private static  final String WS_SESSION_PROPERTY="com.vapeshop.http.WS_SESSION";

    private static final Object sessionIdSequenceLock = new Object();
    public static  final List<ChatSession> pendingSession=new ArrayList<>();


    private static final Map<Long, ChatSession> chatSessions=new Hashtable<>();

    private static final Map<Session,ChatSession> httpSessions=new Hashtable<>();
    private static final Map<Session,ChatSession> sessions=new Hashtable<>();
    private static Long countUser=1L;

    @OnOpen
    public void onOpen(Session session, @PathParam("sessionId") long sessionId ) {
        HttpSession httpSession=(HttpSession) session.getUserProperties().get(ChatEndpoint.HTTP_SESSION_PROPERTY);

        try {
            if (httpSession == null|| httpSession.getAttribute("user")==null) {
                session.close(new CloseReason(
                        CloseReason.CloseCodes.VIOLATED_POLICY,
                        "You are not logged in!"
                ));
                return;
            }
            User user = (User) httpSession.getAttribute("user");
            System.out.println("User " + user.getUserName() + " truy cập vào tính năng chat ");
            //tạo ra đoạn chat
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setTimestamp(OffsetDateTime.now());
            chatMessage.setUser(user.getUserName());
            ChatSession chatSession;
            //chia session

            if (sessionId < 1){
                chatMessage.setType(ChatMessage.Type.STARTED);
            chatMessage.setContent(user.getFullName() + " (@" + user.getUserName() + ") starter the chat session");
            chatSession = new ChatSession();

            synchronized (ChatEndpoint.sessionIdSequenceLock) {
                chatSession.setSessionId(countUser++);
            }

                System.out.println("ông đầu tiên " +chatSession.getSessionId());
            chatSession.setCustomer(session);
            chatSession.setCustomerUsername(user.getUserName());
            chatSession.setCreationMessage(chatMessage);
            ChatEndpoint.pendingSession.add(chatSession);
            ChatEndpoint.chatSessions.put(chatSession.getSessionId(), chatSession);
        }
            else{
                System.out.println("ông nhân viên");
               chatMessage.setType(ChatMessage.Type.JOINED);
                chatMessage.setContent(user.getFullName() + " (@" + user.getUserName() + ") join the chat session");
                chatSession=ChatEndpoint.chatSessions.get(sessionId);
                chatSession.setRepresentative(session);
                chatSession.setRepresentativeUsername(user.getUserName());
                ChatEndpoint.pendingSession.remove(chatSession);
                session.getBasicRemote().sendObject(chatSession.getCreationMessage());
                session.getBasicRemote().sendObject(chatMessage);


            }
            ChatEndpoint.sessions.put(session,chatSession);
            ChatEndpoint.httpSessions.put(session,chatSession);
            this.getSessionsFor(httpSession).add(session);
            chatSession.log(chatMessage);
            chatSession.getCustomer().getBasicRemote().sendObject(chatMessage);

        }catch (Exception e){
            e.printStackTrace();

        }
        System.out.println("Kết nối thành công");
    }
    @OnMessage
    public void onMessage(Session session,ChatMessage message){
        System.out.println("truy cập on message "+message);
        try {
          ChatSession chatSession=ChatEndpoint.sessions.get(session);
          Session otherSession= this.getOtherSession(chatSession,session);
          if(chatSession !=null && otherSession !=null){
              chatSession.log(message);

              try{
                  session.getBasicRemote().sendObject(message);
                  otherSession.getBasicRemote().sendObject(message);
              }
              catch (Exception e){
                  e.printStackTrace();
              }
          }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
        @OnClose
    public void onClose(Session session, CloseReason reason)
    {
        if(reason.getCloseCode() == CloseReason.CloseCodes.NORMAL_CLOSURE)
        {
            ChatMessage message = new ChatMessage();
            HttpSession httpSession=(HttpSession) session.getUserProperties().get(ChatEndpoint.HTTP_SESSION_PROPERTY);
            User user= (User) httpSession.getAttribute("user");

            message.setUser(user.getUserName());
            message.setType(ChatMessage.Type.LEFT);
            message.setTimestamp(OffsetDateTime.now());
            message.setContent(message.getUser() + " left the chat.");
            try
            {
                Session other = this.close(session, message);
                if(other != null)
                    other.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private Session close(Session s, ChatMessage message)
    {
        ChatSession c = ChatEndpoint.sessions.get(s);
        Session other = this.getOtherSession(c, s);
        ChatEndpoint.sessions.remove(s);
        HttpSession h = (HttpSession) ChatEndpoint.httpSessions.get(s);
        if(h != null)
            this.getSessionsFor(h).remove(s);
        if(c != null)
        {
            c.log(message);
           ChatEndpoint.pendingSession.remove(c);
            ChatEndpoint.chatSessions.remove(c.getSessionId());
            try
            {
                c.writeChatLog(new File("chat." + c.getSessionId() + ".log"));
            }
            catch(Exception e)
            {
                System.err.println("Could not write chat log.");
                e.printStackTrace();
            }
        }
        if(other != null)
        {
           ChatEndpoint.sessions.remove(other);
            h = (HttpSession) ChatEndpoint.httpSessions.get(other);
            if(h != null)
                this.getSessionsFor(h).remove(s);
            try
            {
                other.getBasicRemote().sendObject(message);
            }
            catch(IOException | EncodeException e)
            {
                e.printStackTrace();
            }
        }
        return other;
    }
    private Session getOtherSession(ChatSession c, Session s)
    {
        return c == null ? null :
                (s == c.getCustomer() ? c.getRepresentative() : c.getCustomer());
    }
    public static class EndpointConfigurator
            extends ServerEndpointConfig.Configurator
    {
        @Override
        public void modifyHandshake(ServerEndpointConfig config,
                                    HandshakeRequest request,
                                    HandshakeResponse response)
        {
            super.modifyHandshake(config, request, response);

            config.getUserProperties().put(
                    ChatEndpoint.HTTP_SESSION_PROPERTY, request.getHttpSession()
            );
        }
    }
    @Override
    public void sessionCreated(HttpSessionEvent event) { /* do nothing */ }

    @SuppressWarnings("unchecked")
    private synchronized ArrayList<Session> getSessionsFor(HttpSession session)
    {
        try
        {
            if(session.getAttribute(WS_SESSION_PROPERTY) == null)
                session.setAttribute(WS_SESSION_PROPERTY, new ArrayList<>());

            return (ArrayList<Session>)session.getAttribute(WS_SESSION_PROPERTY);
        }
        catch(IllegalStateException e)
        {
            return new ArrayList<>();
        }
    }
}
