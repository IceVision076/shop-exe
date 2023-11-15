package com.vapeshop.controller.order;

import com.vapeshop.entity.Items;
import com.vapeshop.entity.Order;
import com.vapeshop.entity.User;
import com.vapeshop.respository.OrderRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetOrderedDetail", value = "/getordereddetail")
public class GetOrderDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        Order orderedCart = new Order();
        ArrayList<Items> ordered = OrderRepository.getOrder(orderId);
        String orderStatus = OrderRepository.getOrderStatus(orderId);
        orderedCart.setCart(ordered);
        orderedCart.setOrderId(orderId);
        orderedCart.setDiscountCode(OrderRepository.getDiscountCodeByOrderID(orderId));
        //sua not cac method o duoi la xong

        orderedCart.setDiscountPercent(OrderRepository.getDiscountPercent(orderedCart.getDiscountCode()));

        request.setAttribute("orderId", orderId);
        request.setAttribute("orderStatus", orderStatus);
        request.setAttribute("orderedCart", orderedCart);
        request.getRequestDispatcher("ordered.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
