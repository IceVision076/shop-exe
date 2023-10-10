package com.vapeshop.controller;


import com.vapeshop.entity.User;
import com.vapeshop.respository.khanhRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "UpdateProfileServlet", value = "/update-profile")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = "AC00000001";
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        User user=new User();
        user.setFullName(fullname);
        user.setPhone(phone);
        user.setAddress(address);
        user.setId(id);
        khanhRespository.upadteProfile(user);
        response.sendRedirect("index.jsp");
    }
}

