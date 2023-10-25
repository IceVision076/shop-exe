package com.vapeshop.controller.product;

import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.user.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/ShowProductDetails", name = "ShowProductDetails" )
public class ShowProductDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String idProduct = req.getParameter("idProduct");
        Product product = ProductRepository.getProductByID(idProduct);
        ArrayList<ProductType> productTypeArrayList = ProductRepository.getProductByBrand(brand,idProduct);

        req.setAttribute("product",product);
        req.setAttribute("productTypeArrayList",productTypeArrayList);
        req.getRequestDispatcher("ProductDetails.jsp").forward(req,resp);
    }

}
