package com.vapeshop.controller.ProductController;

import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

    @WebServlet(value = "/ProductServlet", name = "ProductServlet" )
public class ShowProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexPage = req.getParameter("index");
        if(indexPage == null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        ProductRepository productRepository = new ProductRepository();
        int count  = productRepository.getTotalProduct();
        int endPage = count/6;
        if(count % 6 != 0){
            endPage++;
        }
        List<ProductType> productList = productRepository.pagingProduct(index);

        req.setAttribute("productList",productList);
        req.setAttribute("endPage",endPage);
        req.setAttribute("tag",index);
        req.getRequestDispatcher("Product.jsp").forward(req,resp);
    }

}
