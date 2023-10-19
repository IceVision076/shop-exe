package com.vapeshop.controller.employee.product;

import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.employee.ProductRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ProductTypeUpdateServlet", value = "/product-type-update")
public class ProductTypeUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String productId=request.getParameter("productId");
        double price = Double.parseDouble(request.getParameter("price"));
        ProductType productType = new ProductType();
        productType.setProductTypeId(id);
        productType.setTypeName(name);
        productType.setTypePrice(price);
        ProductRespository.updateProductType(productType);
     response.sendRedirect("product-editor?productID="+productId);
    }
}
