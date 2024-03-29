package com.vapeshop.controller.employee.service;

import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.employee.ServiceResposiory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServiceAcceptedServlet", value = "/service-accepted")
public class ServiceAcceptedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search=request.getParameter("search");
        int pageNumber = -1;
        int amountServiceAccept =0;
        if(search==null){
            amountServiceAccept= ServiceResposiory.serviceAcceptedAmount();

        }
        else
            amountServiceAccept=ServiceResposiory.getAmountAcceptedSearch(search);

        int maxPageAmount = (amountServiceAccept % 10 == 0) ? amountServiceAccept / 10 : amountServiceAccept / 10 + 1;
        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;


        ArrayList<ServiceTracking> serviceAcceptedList;
        if(search==null){
            serviceAcceptedList=ServiceResposiory.serviceAccepetedPage(pageNumber);
        }
        else{
            serviceAcceptedList=ServiceResposiory.serviceAccepetedSearch(search,pageNumber);
            request.setAttribute("search",search);
        }
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("serviceAcceptedList",serviceAcceptedList);
        request.getRequestDispatcher("dashboard/service-accepted.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
