package com.vapeshop.controller.employee.product;

import com.vapeshop.entity.Product;
import com.vapeshop.respository.employee.ProductRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductUpdateServlet", value = "/product-update")
public class ProductUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String productName = request.getParameter("productName");
        String brand = request.getParameter("brand");
        String detail = request.getParameter("detail");
        String origin = request.getParameter("origin");
        char status = request.getParameter("status").charAt(0);
        Product product = new Product(id, productName, brand, detail, origin, status);
        System.out.println("sta "+product.getStatus());

        ProductRespository.updateProduct(product);
        System.out.println(product);


        response.sendRedirect("product-editor?productID="+id+"&mess="+1);

    }
}
