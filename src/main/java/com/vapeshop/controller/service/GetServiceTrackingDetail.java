package com.vapeshop.controller.service;

import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.user.ServiceTrackingRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "GetServiceTrackingDetail", value = "/GetServiceTrackingDetail")

public class GetServiceTrackingDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceTrackingId = request.getParameter("serviceTrackingId");

        ServiceTracking serviceTrackingDetail = ServiceTrackingRepository.getServiceTrackingById(serviceTrackingId);

        request.setAttribute("serviceTrackingDetail",serviceTrackingDetail);
        request.getRequestDispatcher("ServiceTrackingHistoryDetail.jsp").forward(request, response);
    }
}
