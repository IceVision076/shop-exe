package com.vapeshop.controller.employee.poster;

import com.vapeshop.entity.Poster;
import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.employee.PosterListRespository;
import com.vapeshop.respository.user.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/Home", name = "Home" )

public class PosterListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Poster> posterList = PosterListRespository.getAllPoster();
        ArrayList<Poster> posterListTop = PosterListRespository.getTop3BannerImg();
        ArrayList<ProductType> ProductTopList = ProductRepository.getTop3Product();

        req.setAttribute("posterList",posterList);
        req.setAttribute("posterListTop",posterListTop);
        req.setAttribute("ProductTopList",ProductTopList);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
