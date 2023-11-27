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
        String search=request.getParameter("search");
        int pageNumber = -1;
        int amountServiceAccept=0;
        if(search==null){
            amountServiceAccept= ServiceResposiory.serviceCanceledAmount();

        }
        else
            amountServiceAccept=ServiceResposiory.getAmountCancelSearch(search);
//                 ServiceResposiory.serviceCanceledAmount();
        int maxPageAmount = (amountServiceAccept % 10 == 0) ? amountServiceAccept / 10 : amountServiceAccept / 10 + 1;
        System.out.println("max page"+maxPageAmount);
        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;


        ArrayList<ServiceTracking> serviceCanceledList;
        if (search == null) {
            serviceCanceledList = ServiceResposiory.serviceCanceledPage(pageNumber);
        } else {
            serviceCanceledList = ServiceResposiory.serviceCanceledSearch(search, pageNumber);
            request.setAttribute("search",search);

        }
//                 ServiceResposiory.serviceCanceledPage(pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("serviceCanceledList",serviceCanceledList);
        request.getRequestDispatcher("dashboard/service-canceled.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
