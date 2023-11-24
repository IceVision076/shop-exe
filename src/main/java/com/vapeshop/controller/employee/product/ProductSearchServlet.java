package com.vapeshop.controller.employee.product;

import com.vapeshop.respository.employee.ProductRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductSearchServlet", value = "/product-search")
public class ProductSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("search nè");
        String search = request.getParameter("search");
        if (search == null) response.sendRedirect("product-not-found");
        else {
            switch (search.length()) {
                case 9:
                    if (ProductRespository.checkExistProduct(search))
                        request.getRequestDispatcher("product-editor?productID=" + search).forward(request, response);
                    else response.sendRedirect("product-not-found");
                    break;
                case 10:
                    if(ProductRespository.checkExistProductType(search)){
                        System.out.println(search.substring(0,9));
                        request.getRequestDispatcher("product-editor?productID=" + search.substring(0,9)).forward(request, response);
                    }

                    else response.sendRedirect("product-not-found");
                    break;

                 default:
                    response.sendRedirect("product-not-found");
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
