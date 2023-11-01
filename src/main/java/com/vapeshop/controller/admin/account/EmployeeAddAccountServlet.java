package com.vapeshop.controller.admin.account;

import com.vapeshop.entity.User;
import com.vapeshop.respository.admin.AccountRespository;
import com.vapeshop.respository.user.UserRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EmployeeAddAccountServlet", value = "/employee-add-account")
public class EmployeeAddAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String done= request.getParameter("done");
     String error=request.getParameter("error");

     if(done!=null){
             request.setAttribute("done",done);
     }
     if(error!=null){
         request.setAttribute("error",error);
     }



        request.getRequestDispatcher("dashboard/employee-register-account.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String fullName = request.getParameter("fullName");
        String rePassWord=request.getParameter("rePassWord");
        String email = request.getParameter("email");
        String role = 1 + "";
        String phone = request.getParameter("phone");
        String status = 1 + "";
        String avatarImg = "assets/img/user/avata-default.webp";
        String address= request.getParameter("address");
        if (!passWord.equals(rePassWord))
        {
            response.sendRedirect("employee-add-account?error=1");
        }
        else if (AccountRespository.checkEmailExist(email)){
            response.sendRedirect("employee-add-account?error=2");
        }
        else if (AccountRespository.checkPhoneExist(phone)){
            response.sendRedirect("employee-add-account?error=3");
        }
        else if (AccountRespository.checkUsernameExist(userName)){
            response.sendRedirect("employee-add-account?error=4");
        }
        else {
            User user = new User(id, userName, passWord, fullName, email, role, phone, status, avatarImg, address);
            AccountRespository.addNewEmployee(user);
            response.sendRedirect("employee-add-account?done=1");
        }

    }
}
