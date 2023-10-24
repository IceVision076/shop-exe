package com.vapeshop.controller.employee.profile;

import com.vapeshop.entity.User;
import com.vapeshop.respository.UserRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/profile-ad")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("dashboard/profile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User userOld= (User) session.getAttribute("user");
        String id = userOld.getId();
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        userOld.setFullName(fullname);
        userOld.setPhone(phone);
        userOld.setAddress(address);
        userOld.setId(id);
        UserRespository.upadateProfile(userOld);
        response.sendRedirect("profile-ad");
    }
}
