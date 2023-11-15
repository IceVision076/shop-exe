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
import java.util.List;

@WebServlet(value = "/ProductServlet", name = "ProductServlet")
public class ShowProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexPage = req.getParameter("index");
        String filterProduct = req.getParameter("filterProduct");
        String priceFrom = req.getParameter("priceFrom");
        String priceTo = req.getParameter("priceTo");
        double from = 0.0;
        double to = 0.0;
        int index = -1;
        if (indexPage != null) {
            index = Integer.parseInt(indexPage);
        }

        int count = 0;
        if (filterProduct != null) {
            switch (filterProduct) {
                case "rangePrice":
                    from = Double.parseDouble(priceFrom);
                    to = Double.parseDouble(priceTo);
                    count = ProductRepository.getTotalInRangeProduct(from, to);
                    break;
                case "sortAlphabet":
                case "priceIncrease":
                case "priceDecrease":
                    count = ProductRepository.getTotalProduct();
                    break;
                default:
                    count = ProductRepository.getTotalBrandProduct(filterProduct);
                    break;
            }
        } else {
            count = ProductRepository.getTotalProduct();
        }
        int endPage = count / 9;
        if (count % 9 != 0) {
            endPage++;
        }

        if (index < 1 || index > endPage) {
            index = 1;
        }
        ArrayList<ProductType> listBrand = ProductRepository.getAllBrand();
        ArrayList<ProductType> productList = new ArrayList<>();
        String url = "ProductServlet";


        if (filterProduct != null) {

            if (filterProduct.equals("sortAlphabet")) {
                productList = ProductRepository.getAllProductSortByName(index);
                url += "?filterProduct=" + filterProduct + "&";
            } else if (filterProduct.equals("priceIncrease")) {
                url += "?filterProduct=" + filterProduct + "&";
                productList = ProductRepository.getAllProductIncrease(index);
            } else if (filterProduct.equals("priceDecrease")) {
                url += "?filterProduct=" + filterProduct + "&";
                productList = ProductRepository.getAllProductDecrease(index);
            } else if (filterProduct.equals("rangePrice")) {
                url += "?filterProduct=" + filterProduct + "&priceFrom=" + priceFrom + "&priceTo=" + priceTo + "&";
                productList = ProductRepository.getAllProductInRange(from, to, index);
            } else if (filterProduct.equals(filterProduct)) {
                url += "?filterProduct=" + filterProduct + "&";
                productList = ProductRepository.getAllProductByBrand(filterProduct, index);
            }
        } else {
            url += "?";
            productList = ProductRepository.pagingProduct(index);
        }


        req.setAttribute("productList", productList);
        req.setAttribute("listBrand", listBrand);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("url", url);
        req.getRequestDispatcher("Product.jsp").forward(req, resp);
    }

}
