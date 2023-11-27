package com.vapeshop.controller.employee.service;

import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.employee.ServiceResposiory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SeviceSuccessServlet", value = "/service-success")
public class SeviceSuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        int pageNumber = -1;
        int amountServiceAccept =0;
        if(search==null){
            amountServiceAccept= ServiceResposiory.serviceSuccessAmount();
        }
        else
            amountServiceAccept=ServiceResposiory.getAmountSuccessSearch(search);
//        ServiceResposiory.serviceSuccessAmount();
        int maxPageAmount = (amountServiceAccept % 10 == 0) ? amountServiceAccept / 10 : amountServiceAccept / 10 + 1;
        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;


        ArrayList<ServiceTracking> serviceSuccessList ;
        if(search==null){
            serviceSuccessList=ServiceResposiory.serviceSuccessPage(pageNumber);
        }
        else{
            serviceSuccessList=ServiceResposiory.serviceSuccessSearch(search,pageNumber);
        }
//        = ServiceResposiory.serviceSuccessPage(pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("serviceSuccessList",serviceSuccessList);
        request.getRequestDispatcher("dashboard/service-success.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
