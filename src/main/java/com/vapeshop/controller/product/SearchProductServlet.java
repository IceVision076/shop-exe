package com.vapeshop.controller.product;

import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.user.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchProductServlet", value = "/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("Search")){
            String indexPage = req.getParameter("index");
            if(indexPage == null){
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);

            int count  = ProductRepository.getTotalProduct();
            int endPage = count/9;
            if(count % 9 != 0){
                endPage++;
            }
//            SearchProductServlet?productName=Aspire&action=Search
            String productName = req.getParameter("productName");
            String urlSearch = "SearchProductServlet?productName=" + productName + "&action=" +action + "&";
            ArrayList<ProductType> productSearchList = ProductRepository.getProductSearch(productName,index);
            req.setAttribute("productSearchList",productSearchList);
            req.setAttribute("endPage",endPage);
            req.setAttribute("tag",index);
            req.setAttribute("urlSearch",urlSearch);
            req.getRequestDispatcher("ProductSearch.jsp").forward(req,resp);
        }
    }
}
