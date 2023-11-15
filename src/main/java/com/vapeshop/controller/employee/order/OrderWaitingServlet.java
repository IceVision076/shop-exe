package com.vapeshop.controller.employee.order;

import com.vapeshop.entity.Order;
import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.employee.OrderRespository;
import com.vapeshop.respository.employee.ServiceResposiory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderWaitingServlet", value = "/order-waiting")
public class OrderWaitingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = -1;
        int orderWaitingAmount = OrderRespository.orderWaitingAmount();
        int maxPageAmount = (orderWaitingAmount % 10 == 0) ? orderWaitingAmount / 10 : orderWaitingAmount / 10 + 1;
        String error = request.getParameter("error");

        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;


        ArrayList<Order> orderWaiting = OrderRespository.orderWaitingPage(pageNumber);
        if (error != null) request.setAttribute("error", error);
        request.setAttribute("maxPage", maxPageAmount);
        request.setAttribute("page", pageNumber);
        request.setAttribute("orderWaiting", orderWaiting);
        request.getRequestDispatcher("dashboard/order-waiting.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("id");
        String choice = request.getParameter("choice");
        char currentStatus = OrderRespository.checkStatusOrder(orderId);
        int page = Integer.parseInt(request.getParameter("page"));

        if (currentStatus == '1' || currentStatus == '0') {
            if (choice.equals("accept")) OrderRespository.updateWaitingAccepted(orderId);
            else if (choice.equals("cancel")) {
                OrderRespository.updateWaitingCanceled(orderId);
            }
            response.sendRedirect("order-waiting?page=" + page);
        } else {
            response.sendRedirect("order-waiting?error=1&page=" + page);
            //Lỗi status khác trạng thái chờ duyệt
        }


    }
}
