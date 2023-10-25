package com.vapeshop.controller;


import com.vapeshop.entity.User;
import com.vapeshop.respository.user.UserRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "UpdateProfileServlet", value = "/update-profile")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("update-profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User userOld = (User) session.getAttribute("user");
        String id = userOld.getId();
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        userOld.setFullName(fullname);
        userOld.setPhone(phone);
        userOld.setAddress(address);
        userOld.setId(id);
        UserRespository.upadateProfile(userOld);
        response.sendRedirect("index.jsp");
    }
}

