package com.vapeshop.controller.employee.order;

import com.vapeshop.respository.employee.OrderRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OrderChoiceServlet", value = "/order-choice")
public class OrderChoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderWaitingAmount = OrderRespository.orderWaitingAmount();
        int orderSuccessAmount = OrderRespository.orderSuccessAmount();
        int orderFailAmount = OrderRespository.orderFailAmount();
        int orderCanceledAmount = OrderRespository.orderCanceledAmount();
        int orderAcceptedAmount=OrderRespository.orderAcceptedAmount();

        request.setAttribute("orderWaitingAmount",orderWaitingAmount);
        request.setAttribute("orderSuccessAmount",orderSuccessAmount);
        request.setAttribute("orderFailAmount",orderFailAmount);
        request.setAttribute("orderCanceledAmount",orderCanceledAmount);
        request.setAttribute("orderAcceptedAmount",orderAcceptedAmount);

        request.getRequestDispatcher("dashboard/order-choice.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
