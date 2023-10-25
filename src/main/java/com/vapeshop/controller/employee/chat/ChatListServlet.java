package com.vapeshop.controller.employee.chat;

import com.vapeshop.chat.ChatSession;
import com.vapeshop.chat.ChatEndpoint;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChatListServlet", value = "/chat-list")
public class ChatListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChatSession> chatList= ChatEndpoint.pendingSession;
        request.setAttribute("chatList",chatList);
        request.getRequestDispatcher("dashboard/chat-list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
