package com.vapeshop.controller.employee.service;

import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.employee.ServiceResposiory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServiceFailServlet", value = "/service-fail")
public class ServiceFailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        int pageNumber = -1;
        int amountServiceFail = 0;
        if (search == null) {
            amountServiceFail = ServiceResposiory.serviceFailAmount();
        } else {
            amountServiceFail = ServiceResposiory.getAmountFailSearch(search);
        }
//                = ServiceResposiory.serviceFailAmount();
        int maxPageAmount = (amountServiceFail % 10 == 0) ? amountServiceFail / 10 : amountServiceFail / 10 + 1;
        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;


        ArrayList<ServiceTracking> serviceFailList;
        if (search == null) {
            serviceFailList = ServiceResposiory.serviceFailPage(pageNumber);
        } else {
            serviceFailList = ServiceResposiory.serviceFailSearch(search, pageNumber);
            request.setAttribute("search",search);

        }

        request.setAttribute("maxPage", maxPageAmount);
        request.setAttribute("page", pageNumber);
        request.setAttribute("serviceFailList", serviceFailList);
        request.getRequestDispatcher("dashboard/service-fail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
