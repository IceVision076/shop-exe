/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.vapeshop.controller.login;


import com.vapeshop.entity.User;
import com.vapeshop.respository.user.UserRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author HUNTER
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("password");

        String fullName = request.getParameter("FullName");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String phone = request.getParameter("telephone");
        String status = request.getParameter("status");
        String avatarImg = request.getParameter("avatarImg");
        String address = request.getParameter("address");

        String rePass = request.getParameter("rePass");
        UserRespository dao = new UserRespository();
        User checkAccount  = dao.CheckAccoutExist(userName);
        User checkEmail = dao.CheckEmailExist(email);
        if (checkAccount  != null) {
            // Tên người dùng đã tồn tại, load lại trang register

            request.getSession().setAttribute("accoutExits", "Tài khoản đã tồn tại");

            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (checkEmail != null) {
            // eamil đã tồn tại, load lại trang
            request.getSession().setAttribute("mess", "Email đã tồn tại");

            request.getRequestDispatcher("register.jsp").forward(request, response);

        } else if (!passWord.equals(rePass)) {

            // Mật khẩu không khớp, load lại trang register
//            request.setAttribute("mess2", "Re-entered password is incorrect");
            request.getSession().setAttribute("rePass", "Mật khẩu nhập lại sai");

            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {

            dao.Register(id, userName, passWord, fullName, email, role, phone, status, avatarImg, address);
            response.sendRedirect("login.jsp");
        }

//        if (!passWord.equals(rePass)) {
//            response.sendRedirect("login.jsp");
//
//        } else {
//            UserRespository dao = new UserRespository();
//            User account = dao.CheckAccoutExist(userName);
//            if (account == null) {
//                dao.Register(id, userName, passWord, fullName, email, role, phone, status, avatarImg, address);
//                response.sendRedirect("home.jsp");
//                request.setAttribute("mess1", "The account already exists");
//
//                //response.sendRedirect("sign-up.jsp");
//                request.getRequestDispatcher("register.jsp").forward(request, response);
//            }
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
