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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@WebServlet(name = "GetOrderHistory", value = "/getorderhistory")
public class GetOrderHistory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String userId = user.getId();
        ArrayList<String> listOrderId = OrderRepository.getOrderIdList(userId); //danh sach id cua cac order
        ArrayList<Order> listOrdered = new ArrayList<>(); //list cac don hang da dat(Order)
        for (String orderId : listOrderId) {
            Order orderedCart = new Order();
            orderedCart.setCart(OrderRepository.getOrder(orderId));
            orderedCart.setOrderId(orderId);
            orderedCart.setStatus(OrderRepository.getOrderStatus(orderId).charAt(0));
            orderedCart.setCreateDate(OrderRepository.getOrderDate(orderId));
            orderedCart.setDiscountCode(OrderRepository.getDiscountCodeByOrderID(orderId));
            orderedCart.setDiscountPercent(OrderRepository.getDiscountPercent(orderedCart.getDiscountCode()));
            listOrdered.add(orderedCart);
        }
//        Collections.sort(listOrdered, new Comparator<Order>() {
//
//            @Override
//            public int compare(Order o1, Order o2) {
//                LocalDateTime dateString1 = o1.getCreateDate();
//                LocalDateTime dateString2 = o2.getCreateDate();
//
//                return Integer.parseInt(String.valueOf(dateString1.isBefore(dateString2)));
//            }
//
//        });



        request.setAttribute("listOrdered", listOrdered);
        request.getRequestDispatcher("orderhistory.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
