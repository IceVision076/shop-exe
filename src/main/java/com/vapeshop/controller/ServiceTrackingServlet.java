package com.vapeshop.controller;

import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.ServiceTrackingRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ServiceTrackingServlet", value = "/service-tracking-sender")
public class ServiceTrackingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String userDescription = request.getParameter("userDescription");
        String id = "ST00000121";
        String userId = "AC00000015";
        LocalDate createDate = LocalDate.now();
        char status = '1';
        ServiceTracking serviceTracking= new ServiceTracking( id, userId, userDescription, createDate, status, title);
        ServiceTrackingRepository.serviceTrackingSender(serviceTracking);
        response.sendRedirect("index.jsp");
    }
}
