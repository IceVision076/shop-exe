package com.vapeshop.controller.ProductController;

import com.vapeshop.entity.Product;
import com.vapeshop.respository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/ProductHomeServlet", name = "ProductHomeServlet" )

public class ShowProductHomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Product> productHomeList = ProductRepository.getAllProduct();

//        req.setAttribute("productHomeList",productHomeList);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
