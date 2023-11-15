package com.vapeshop.controller.employee.order;

import com.vapeshop.entity.Order;
import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.employee.OrderRespository;
import com.vapeshop.respository.employee.ServiceResposiory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderCanceledServlet", value = "/order-canceled")
public class OrderCanceledServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = -1;

        int orderCancelAmount = OrderRespository.orderCanceledAmount();
        int maxPageAmount = (orderCancelAmount % 10 == 0) ? orderCancelAmount / 10 : orderCancelAmount / 10 + 1;
        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;


        ArrayList<Order> orderCancel = OrderRespository.orderCanceled(pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("orderCancel",orderCancel);
        request.getRequestDispatcher("dashboard/order-canceled.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
