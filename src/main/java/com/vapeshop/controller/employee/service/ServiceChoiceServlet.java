package com.vapeshop.controller.employee.service;

import com.vapeshop.respository.employee.ServiceResposiory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServiceChoiceServlet", value = "/service-choice")
public class ServiceChoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int failAmount = ServiceResposiory.getAmountFail();
        int acceptedAmount = ServiceResposiory.getAmountAccept();
        int canceledAmount = ServiceResposiory.getAmountCancel();
        int successAmount = ServiceResposiory.getAmountSuccess();
        int waitAmount = ServiceResposiory.getAmountWaiting();
        request.setAttribute("failAmount", failAmount);
        request.setAttribute("acceptedAmount",acceptedAmount );
        request.setAttribute("canceledAmount", canceledAmount);
        request.setAttribute("successAmount",successAmount );
        request.setAttribute("waitAmount",waitAmount );

        request.getRequestDispatcher("dashboard/service-choice.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
