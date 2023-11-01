package com.vapeshop.controller.employee.service;

import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.employee.ServiceResposiory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "ServiceDoneServlet", value = "/service-done")
public class ServiceDoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        double price = 0;
        String employeeDescription=request.getParameter("employeeDescription");
        char status=request.getParameter("status").charAt(0);
        String priceString=request.getParameter("price");

        System.out.println(priceString.isEmpty());
        if(!request.getParameter("price").isEmpty())
            price= Double.parseDouble(request.getParameter("price"));
        ServiceTracking serviceTracking=new ServiceTracking();
        serviceTracking.setPrice(price);
        serviceTracking.setId(id);
        serviceTracking.setEmployeeDescription(employeeDescription);
        serviceTracking.setDeliveryDate(LocalDateTime.now());
        serviceTracking.setStatus(status);
        if(status=='4')
            ServiceResposiory.updateSuccess(serviceTracking);
        else if (status=='3')
            ServiceResposiory.updateFail(serviceTracking);

        String page=request.getParameter("page");

      response.sendRedirect("service-accepted?page="+page);
    }
}
