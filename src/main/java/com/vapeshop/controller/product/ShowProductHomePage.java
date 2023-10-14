package com.vapeshop.controller.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/ProductHomeServlet", name = "ProductHomeServlet" )

public class ShowProductHomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Product> productHomeList = ProductRepository.getAllProduct();

//        req.setAttribute("productHomeList",productHomeList);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
