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

        String search=request.getParameter("search");
        int pageNumber = -1;
        int orderAcceptedAmount =0;
        if(search==null){
            orderAcceptedAmount=  OrderRespository.orderAcceptedAmount();
        }
        else
        {
            orderAcceptedAmount=OrderRespository.searchAcceptedOrderAmount(search);
        }

                OrderRespository.orderAcceptedAmount();
        int maxPageAmount = (orderAcceptedAmount % 10 == 0) ? orderAcceptedAmount / 10 : orderAcceptedAmount / 10 + 1;
        String error = request.getParameter("error");
        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;


        if (error != null) request.setAttribute("error", error);


        ArrayList<Order> orderAccept;
        if(search==null){
            orderAccept = OrderRespository.orderAccepted(pageNumber);
        }
        else{
            orderAccept = OrderRespository.searchAcceptedOrder(search,pageNumber);
            request.setAttribute("search",search);
        }


        request.setAttribute("maxPage", maxPageAmount);
        request.setAttribute("page", pageNumber);
        request.setAttribute("orderAccept", orderAccept);
        request.getRequestDispatcher("dashboard/order-accepted.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("id");
        String choice = request.getParameter("choice");
        char currentStatus = OrderRespository.checkStatusOrder(orderId);
        int page = Integer.parseInt(request.getParameter("page"));

        if (currentStatus == '2') {
            if (choice.equals("success")) OrderRespository.updateAcceptedSuccess(orderId);
            else if (choice.equals("fail")) {
                OrderRespository.updateAcceptedFail(orderId);
            }
            response.sendRedirect("order-accepted?page=" + page);
        } else {
            response.sendRedirect("order-accepted?error=1&page=" + page);
            //Lỗi status khác trạng thái chờ duyệt
        }
    }
}
