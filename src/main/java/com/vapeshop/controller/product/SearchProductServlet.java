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
        ArrayList<ProductType> listBrand = ProductRepository.getAllBrand();
        System.out.println("-------------"+listBrand.size());
        req.setAttribute("listBrand", listBrand);

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
        }else {
            String filterProduct = req.getParameter("filterProduct");
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
            ArrayList<ProductType> productList = new ArrayList<>();
            String url = "ProductServlet";


            if (filterProduct != null) {

                if (filterProduct.equals("sortAlphabet")) {
                    productList = ProductRepository.getAllProductSortByName(index);
                    url += "?filterProduct=" +filterProduct + "&";
                } else if (filterProduct.equals("priceIncrease")) {
                    url += "?filterProduct=" +filterProduct + "&";
                    productList = ProductRepository.getAllProductIncrease(index);
                } else if (filterProduct.equals("priceDecrease")) {
                    url += "?filterProduct=" +filterProduct + "&";
                    productList = ProductRepository.getAllProductDecrease(index);
                } else if (filterProduct.equals("rangePrice")) {
                    String priceFrom = req.getParameter("priceFrom");
                    String priceTo = req.getParameter("priceTo");
                    double from = Double.parseDouble(priceFrom);
                    double to = Double.parseDouble(priceTo);
                    url += "?filterProduct=" +filterProduct + "&priceFrom=" + priceFrom + "&priceTo=" + priceTo + "&";
                    productList = ProductRepository.getAllProductInRange(from, to, index);
                } else if (filterProduct.equals(filterProduct)) {
                    url += "?filterProduct=" +filterProduct + "&";
                    productList = ProductRepository.getAllProductByBrand(filterProduct, index);
                }
            } else {
                url += "?";
                productList = ProductRepository.pagingProduct(index);
            }


            req.setAttribute("productList", productList);
            req.setAttribute("url", url);
            req.setAttribute("endPage", endPage);
            req.getRequestDispatcher("ProductSearch.jsp").forward(req,resp);
        }
    }
}
