package com.vapeshop.controller.cart;

import com.vapeshop.entity.Items;
import com.vapeshop.entity.Order;
import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "changeAmmountServlet", value = "/changeammount")
public class ChangeAmmountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order cart = (Order) session.getAttribute("cart");

        String increase = request.getParameter("increase");
        String decrease = request.getParameter("decrease");
        String delete = request.getParameter("delete");
        if (increase != null) {
            System.out.println(cart.increaseAmmount(increase));
        } else if (decrease != null) {
            System.out.println(cart.decreaseAmmount(decrease));
        } else if (delete != null) {
            System.out.println(cart.removeItem(delete));
        }
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
