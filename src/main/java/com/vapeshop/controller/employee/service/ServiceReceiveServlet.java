package com.vapeshop.controller.employee.service;

import com.vapeshop.entity.User;
import com.vapeshop.respository.employee.ServiceResposiory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet(name = "ServiceReceiveServlet", value = "/service-receive")
public class ServiceReceiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String id = request.getParameter("id");
        String employeeId = user.getId();
        String employeeDescription = request.getParameter("employeeDescription");
        char status =request.getParameter("status").charAt(0);
        ServiceResposiory.serviceReceive(id, employeeId, employeeDescription,status);
        response.sendRedirect("service-management");
    }
}
