package com.vapeshop.controller.employee.poster;

import com.vapeshop.entity.Poster;
import com.vapeshop.entity.User;
import com.vapeshop.respository.employee.PosterRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "PosterAddServlet", value = "/poster-add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class PosterAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String page=request.getParameter("page");

        String posterId = PosterRespository.getNewPosterId();
        char status = '1';
        LocalDateTime dateCreate = LocalDateTime.now();


        //Lưu file
        String appPath = request.getServletContext().getRealPath("");
//        D:\Project_final_intership\VapeShope\target\VapeShope-1.0-SNAPSHOT\assets\img\product
        appPath.replace('\\', '/');
        String savePath = "src/main/webapp/assets/img/poster";
//        D:\Project_final_intership\VapeShope\src\main\webapp\assets\img\product
        String fileName = "";

        for (Part part : request.getParts()) {
            // System.out.println(part.getHeader("content-disposition"));
            if (!part.getHeader("content-disposition").contains("filename")) {
                continue;
            }

            fileName = posterId + ".jpg";

            if (fileName != null && fileName.length() > 0) {
                String filePath = appPath.substring(0, appPath.indexOf("VapeShop") + 9) + savePath + File.separator + fileName;
                part.write(filePath);
            }

        }

        String imgUrl=savePath.substring(savePath.indexOf("assets"))+"/"+fileName;
        Poster poster = new Poster(posterId, imgUrl, user, dateCreate, status);
        PosterRespository.addNewPoster(poster);
      response.sendRedirect("poster-management?page="+page);



    }
}
