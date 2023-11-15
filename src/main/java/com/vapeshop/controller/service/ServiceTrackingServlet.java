package com.vapeshop.controller.service;

import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.entity.User;
import com.vapeshop.respository.user.ServiceTrackingRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "ServiceTrackingServlet", value = "/service-tracking-sender")
public class ServiceTrackingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     request.getRequestDispatcher("serviceSender.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        String title = request.getParameter("title");
        String userDescription = request.getParameter("userDescription");
        String userId = user.getId();
        LocalDateTime createDate = LocalDateTime.now();
        char status = '1';
        ServiceTracking serviceTracking= new ServiceTracking( "", userId, userDescription, createDate, status, title);
        ServiceTrackingRepository.serviceTrackingSender(serviceTracking);
        response.sendRedirect("Home");
    }
}
