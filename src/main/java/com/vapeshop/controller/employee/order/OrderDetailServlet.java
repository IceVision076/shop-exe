package com.vapeshop.controller.employee.order;

import com.vapeshop.entity.Order;
import com.vapeshop.respository.employee.OrderRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OrderDetailServlet", value = "/order-detail")
public class OrderDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        Order order= OrderRespository.getOrderById(orderId);
        request.setAttribute("order", order);
        request.getRequestDispatcher("dashboard/order-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}