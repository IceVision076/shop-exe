//package com.vapeshop.lab;
//
//import jakarta.websocket.*;
//
//@ClientEndpoint
//public class ChatClient {
//    private Session session;
//
//    public ChatClient() {
//    }
//
//    @OnOpen
//    public void onOpen(Session session) {
//        this.session = session;
//        System.out.println("Connected to server");
//    }
//
//    @OnMessage
//    public void onMessage(String message) {
//        System.out.println("Received message: " + message);
//    }
//
//    @OnClose
//    public void onClose(CloseReason closeReason) {
//        System.out.println("Disconnected from server");
//    }
//
//    public void sendMessage(String message) {
//        session.getBasicRemote().sendText(message);
//    }
//
//    public static void main(String[] args) throws Exception {
//        ChatClient client = new ChatClient();
//        URI uri = new URI("ws://localhost:8080/chatAll");
//        client.session = Clien;
//
//        // Gửi tin nhắn đến máy chủ
//        client.sendMessage("Hello, world!");
//
//        // Đợi cho đến khi kết nối bị đóng
//        while (client.session.isOpen()) {
//            Thread.sleep(1000);
//        }
//    }
//}
