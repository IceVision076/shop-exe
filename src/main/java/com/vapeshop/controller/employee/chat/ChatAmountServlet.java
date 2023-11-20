package com.vapeshop.controller.employee.chat;

import com.google.gson.Gson;
import com.vapeshop.chat.ChatEndpoint;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "ChatAmountServlet", value = "/chatamount")
public class ChatAmountServlet extends HttpServlet {
    private Gson gson =new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int x = ChatEndpoint.pendingSession.size();




        String voucherJsonString = this.gson.toJson(x);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(voucherJsonString);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
