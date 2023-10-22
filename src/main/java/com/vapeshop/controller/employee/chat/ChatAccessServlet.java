package com.vapeshop.controller.employee.chat;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ChatAccessServlet", value = "/chat-access")
public class ChatAccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     long sessionId = Long.parseLong(request.getParameter("sessionId"));
     request.setAttribute("sessionId",sessionId);
     request.getRequestDispatcher("dashboard/chat-session.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
