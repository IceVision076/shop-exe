package com.vapeshop.controller.employee.poster;

import com.vapeshop.entity.Poster;
import com.vapeshop.respository.employee.PosterRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


import java.io.File;
import java.io.IOException;

@WebServlet(name = "PosterDeleteServlet", value = "/poster-delete")
public class PosterDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("postId");
        String page= request.getParameter("page");
        Poster poster= PosterRespository.getPosterById(postId);
        try {
            File f=new File(".");
            System.out.println("=>>>>>>>>>>"+f.getPath());
            File file=new File(poster.getImgUrl());

            if(file.exists()){
                file.delete();//
                System.out.println("==========Xoa file "+poster.getImgUrl()+"==========");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        PosterRespository.deletePoster(postId);
        System.out.println("==================="+postId+"================");
        response.sendRedirect("poster-management?page="+page);
    }
}
