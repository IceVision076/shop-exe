package com.vapeshop.controller.employee.order;

import com.vapeshop.entity.Order;
import com.vapeshop.respository.employee.OrderRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderAcceptedServlet", value = "/order-accepted")
public class OrderAcceptedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = -1;
        int orderAcceptedAmount = OrderRespository.orderAcceptedAmount();
        int maxPageAmount = (orderAcceptedAmount % 10 == 0) ? orderAcceptedAmount / 10 : orderAcceptedAmount / 10 + 1;
        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;


        ArrayList<Order> orderAccept = OrderRespository.orderAccepted(pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("orderAccept",orderAccept);
        request.getRequestDispatcher("dashboard/order-accepted.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
