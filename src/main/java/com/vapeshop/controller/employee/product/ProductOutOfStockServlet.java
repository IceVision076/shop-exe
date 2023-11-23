package com.vapeshop.controller.employee.product;

import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.employee.ProductRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductOutOfStockServlet", value = "/product-out-of-stock")
public class ProductOutOfStockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber=-1;


        int maxPageAmount= ProductRespository.getProductTypeOutOfStockAmount()/10+1;
        if(request.getParameter("page")==null) {
            pageNumber=1;
        }

        else
            pageNumber= Integer.parseInt(  request.getParameter("page"))  ;

        if( pageNumber>maxPageAmount||pageNumber<=0) pageNumber=1;
        ArrayList<ProductType> listProductType=ProductRespository.getProductTypeOutOfStockPage(pageNumber);

        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("listProductType",listProductType);
        request.getRequestDispatcher("dashboard/product-out-of-stock.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
