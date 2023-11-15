package com.vapeshop.controller.employee.product;

import com.vapeshop.entity.ImportProduct;
import com.vapeshop.respository.employee.ProductRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@WebServlet(name = "ProductImportServlet", value = "/product-import")
public class ProductImportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productTypeId = request.getParameter("productTypeId");
        int pageNumber=-1;

        int maxPageAmount=ProductRespository.getImportProductTypeAmount(productTypeId)/10+1;
        if(request.getParameter("page")==null) {
            pageNumber=1;
        }

        else
            pageNumber= Integer.parseInt(  request.getParameter("page"))  ;

        if( pageNumber>maxPageAmount||pageNumber<=0) pageNumber=1;


        ArrayList<ImportProduct> importProductList=ProductRespository.getImportList(productTypeId,pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("importProductList",importProductList);

        request.setAttribute("productTypeId", productTypeId);
        request.getRequestDispatcher("dashboard/product-import.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lotName = request.getParameter("lotName");
        String productTypeId = request.getParameter("productTypeId");
        int lotAmount = Integer.parseInt(request.getParameter("lotAmount"));
        String lotId="";
        String page =request.getParameter("page");
        while (true){
            Random random = new Random();
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String randomString = "";
            for (int i = 0; i < 10; i++) {
                // Lấy một ký tự ngẫu nhiên từ chuỗi alphabet
                int index = random.nextInt(alphabet.length());
                char c = alphabet.charAt(index);
                randomString += c;
            }
            if(!ProductRespository.checkExitsLotId(randomString)){
                lotId=randomString;
                break;
            }
        }
        System.out.println();

        ImportProduct importProduct=new ImportProduct(lotId,lotName,productTypeId,lotAmount, LocalDateTime.now());
        System.out.println(importProduct);
          ProductRespository.addNewLot(importProduct);

          response.sendRedirect("product-import?productTypeId="+productTypeId+"&page="+page);
    }
}
