/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.vapeshop.controller.login;



import com.vapeshop.respository.SendMail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/forgotPassword")
public class ForgotPassword extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        SendMail.forgotPass(email,"123");
        response.sendRedirect("index.jsp");
//        } else {
//            // Email parameter is not provied or is empty
//            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
//            request.setAttribute("emailEmpty", "Please provide a vaild email !!!");
        }

    }

