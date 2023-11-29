package com.vapeshop.controller.admin.account;

import com.vapeshop.entity.Poster;
import com.vapeshop.entity.User;
import com.vapeshop.respository.employee.PosterRespository;
import com.vapeshop.respository.user.UserRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

@WebServlet(name = "ChangeAvatarServlet", value = "/change-avatar")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ChangeAvatarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
         String userId=user.getId();
        String imgName="";
        Random random = new Random();

        // Tạo một chuỗi trống


        // Lặp lại 10 lần để tạo 10 kí tự ngẫu nhiên
        for (int i = 0; i < 10; i++) {
            // Tạo một kí tự ngẫu nhiên từ bảng chữ cái và số
            char randomCharacter = (char) (random.nextInt(25) +97);

            // Thêm kí tự ngẫu nhiên vào chuỗi
            imgName += randomCharacter;
        }

        


        //Lưu file
        String appPath = request.getServletContext().getRealPath("");
//        D:\Project_final_intership\VapeShope\target\VapeShope-1.0-SNAPSHOT\assets\img\product
        appPath.replace('\\', '/');
        String savePath = "src/main/webapp/assets/img/user";
//        D:\Project_final_intership\VapeShope\src\main\webapp\assets\img\product
        String fileName = "";

        for (Part part : request.getParts()) {
            // System.out.println(part.getHeader("content-disposition"));
            if (!part.getHeader("content-disposition").contains("filename")) {
                continue;
            }

            fileName = imgName + ".jpg";

            if (fileName != null && fileName.length() > 0) {
                String filePath = appPath.substring(0, appPath.indexOf("VapeShop") + 9) + savePath + File.separator + fileName;
                part.write(filePath);
            }

        }

        String imgUrl=savePath.substring(savePath.indexOf("assets"))+"/"+fileName;
        UserRespository.updateAvatar(userId,imgUrl);
        user.setAvatarImg(imgUrl);
        response.sendRedirect("update-profile");
    }
}
