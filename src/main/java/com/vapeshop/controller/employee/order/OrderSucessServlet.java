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

@WebServlet(name = "OrderSucessServlet", value = "/order-success")
public class OrderSucessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search=request.getParameter("search");
        int pageNumber = -1;
        int orderSuccessAmount=0;
        if(search==null){
            orderSuccessAmount=  OrderRespository.orderSuccessAmount();
        }
        else
        {
            orderSuccessAmount=OrderRespository.searchSuccessOrderAmount(search);
        }



        int maxPageAmount = (orderSuccessAmount % 10 == 0) ? orderSuccessAmount / 10 : orderSuccessAmount / 10 + 1;
        if (request.getParameter("page") == null) {
            pageNumber = 1;
        } else
            pageNumber = Integer.parseInt(request.getParameter("page"));

        if (pageNumber > maxPageAmount || pageNumber <= 0) pageNumber = 1;

        ArrayList<Order> orderSuccess ;
        if(search==null){
            orderSuccess = OrderRespository.orderSuccess(pageNumber);
        }
        else{
            orderSuccess = OrderRespository.searchSuccessOrder(search,pageNumber);
            request.setAttribute("search",search);
        }


        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("orderSuccess",orderSuccess);
        request.getRequestDispatcher("dashboard/order-success.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
