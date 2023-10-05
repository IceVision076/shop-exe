package com.vapeshop.controller.ProductController;

import com.vapeshop.entity.ImageProduct;
import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/ShowProductDetails", name = "ShowProductDetails" )
public class ShowProductDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProduct = req.getParameter("idProduct");
        Product product = ProductRepository.getProductByID(idProduct);
        ArrayList<ProductType> productTypes = ProductRepository.getTypeByID(idProduct);
        ArrayList<Product> imageProducts = ProductRepository.getImageByID(idProduct);
        ArrayList<Product> productList = ProductRepository.getAllProduct();

        req.setAttribute("product",product);
        req.setAttribute("productTypes",productTypes);
        req.setAttribute("imageProducts",imageProducts);
        req.setAttribute("productList",productList);
        req.getRequestDispatcher("ProductDetails.jsp").forward(req,resp);
    }

}
