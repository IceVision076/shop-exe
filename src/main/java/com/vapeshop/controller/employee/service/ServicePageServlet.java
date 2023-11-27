package com.vapeshop.controller.employee.service;

import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.employee.ProductRespository;
import com.vapeshop.respository.employee.ServiceResposiory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServicePageServlet", value = "/service-management")
public class ServicePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        int pageNumber = -1;
        int amountServiceAccept = 0;
        if(search==null){
            amountServiceAccept= ServiceResposiory.serviceAcceptAmount();
        }
        else
            amountServiceAccept=ServiceResposiory.getAmountWaitingSearch(search);
//        ServiceResposiory.serviceAcceptAmount();
        int maxPageAmount = (amountServiceAccept % 10 == 0) ? amountServiceAccept / 10 : amountServiceAccept / 10 + 1;
        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;


        ArrayList<ServiceTracking> serviceAcceptList;
        if (search == null) {
            serviceAcceptList = ServiceResposiory.serviceTrackingPage(pageNumber);
        } else {
            serviceAcceptList = ServiceResposiory.serviceTrackingSearch(search, pageNumber);
            request.setAttribute("search",search);

        }
//        = ServiceResposiory.serviceTrackingPage(pageNumber);

        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("serviceAcceptList",serviceAcceptList);
        request.getRequestDispatcher("dashboard/service-management.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
