package com.vapeshop.controller.employee.poster;

import com.vapeshop.entity.Poster;
import com.vapeshop.respository.employee.PosterRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PosterManagementServlet", value = "/poster-management")
public class PosterManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber=-1;
        int posterAmount=PosterRespository.getPosterAmount();
        int maxPageAmount=(posterAmount%10==0)?posterAmount/10 : posterAmount /10+1;

        if(request.getParameter("page")==null) {
            pageNumber=1;
        }

        else
            pageNumber= Integer.parseInt(  request.getParameter("page"))  ;

        if( pageNumber>maxPageAmount||pageNumber<=0) pageNumber=1;
        ArrayList<Poster> listPoster=PosterRespository.getPosterPage(pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("listPoster",listPoster);
        request.getRequestDispatcher("dashboard/poster-management.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
