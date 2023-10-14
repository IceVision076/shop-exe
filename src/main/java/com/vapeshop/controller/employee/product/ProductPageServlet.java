package com.vapeshop.controller.employee.product;

import com.vapeshop.entity.Product;
import com.vapeshop.respository.employee.ProductRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductPageServlet", value = "/product-management")
public class ProductPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber=-1;
        int maxPageAmount=ProductRespository.getProductAmount()/10+1;
            if(request.getParameter("page")==null) {
                pageNumber=1;
            }

            else
                pageNumber= Integer.parseInt(  request.getParameter("page"))  ;

            if( pageNumber>maxPageAmount||pageNumber<=0) pageNumber=1;
        ArrayList<Product> list=ProductRespository.getProductPage(pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("listProduct",list);
        request.getRequestDispatcher("dashboard/product-management.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
