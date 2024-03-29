package com.vapeshop.controller.order;

import com.vapeshop.entity.*;
import com.vapeshop.respository.OrderRepository;
import com.vapeshop.respository.user.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;

import java.io.IOException;
@WebServlet(name = "makeOrderServlet", value = "/makeoder")
public class MakeOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Order cart = (Order) session.getAttribute("cart");
        if(cart.getCart().size()==0) response.sendRedirect("cart.jsp");
        else{
            String orderId = OrderRepository.createOrder(cart,user);
            cart.setDiscountCode(null);
            cart.removeAll();
            request.getRequestDispatcher("getordereddetail?orderId="+orderId).forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
