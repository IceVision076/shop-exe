package com.vapeshop.controller.employee.service;

import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.employee.ServiceResposiory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServiceCanceledServlet", value = "/service-canceled")
public class ServiceCanceledServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = -1;
        int amountServiceAccept = ServiceResposiory.serviceCanceledAmount();
        int maxPageAmount = (amountServiceAccept % 10 == 0) ? amountServiceAccept / 10 : amountServiceAccept / 10 + 1;
        System.out.println("max page"+maxPageAmount);
        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;


        ArrayList<ServiceTracking> serviceCanceledList = ServiceResposiory.serviceCanceledPage(pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("serviceCanceledList",serviceCanceledList);
        request.getRequestDispatcher("dashboard/service-canceled.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
