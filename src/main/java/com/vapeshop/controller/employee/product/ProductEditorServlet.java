package com.vapeshop.controller.employee.product;

import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.employee.ProductRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductEditorServlet", value = "/product-editor")
public class ProductEditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber=-1;
        String mess=null;
        try{
            mess=request.getParameter("mess").charAt(0)==1?"Cập nhật thành công":"";

        }
            catch(Exception e){
            e.printStackTrace();
        }
        String productID=request.getParameter("productID");
        Product product=ProductRespository.getProductById(productID);
        int maxPageAmount= ProductRespository.getProductTypeAmount(productID)/10+1;
        if(request.getParameter("page")==null) {
            pageNumber=1;
        }

        else
            pageNumber= Integer.parseInt(  request.getParameter("page"))  ;

        if( pageNumber>maxPageAmount||pageNumber<=0) pageNumber=1;
        ArrayList<ProductType> listProductType=ProductRespository.getProductTypePage(productID,pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("listProductType",listProductType);
        request.setAttribute("product",product);
        request.setAttribute("mess",mess);
        request.getRequestDispatcher("dashboard/product-editor.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
