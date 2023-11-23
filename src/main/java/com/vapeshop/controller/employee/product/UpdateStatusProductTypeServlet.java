package com.vapeshop.controller.employee.product;

import com.vapeshop.respository.employee.ProductRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateStatusProductTypeServlet", value = "/update-status-product-type")
public class UpdateStatusProductTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = request.getParameter("choice");
        String productTypeId = request.getParameter("productTypeId");
        String productId=request.getParameter("productId");
        String page=request.getParameter("page");
        if (choice.equals("stop")) {
            //stop
            ProductRespository.updateStopSellProductType(productTypeId);
        } else if (choice.equals("continue")) {
            //continue
            ProductRespository.updateContinueSellProductType(productTypeId);
        }
        response.sendRedirect("product-editor?productID="+productId+"&page="+page);
    }
}
