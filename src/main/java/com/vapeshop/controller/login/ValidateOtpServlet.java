/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.vapeshop.controller.login;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 *
 * @author HUNTER
 */
@WebServlet(name = "ValidateOtp", urlPatterns = {"/ValidateOtp"})
public class ValidateOtpServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int value = Integer.parseInt(request.getParameter("otp"));
        HttpSession session = request.getSession();
        int otp = (int) session.getAttribute("otp");

        RequestDispatcher dispatcher = null;

        if (value == otp) {

            request.setAttribute("email", request.getParameter("email"));
            dispatcher = request.getRequestDispatcher("newPassword.jsp");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("message", "Sai mã OTP");

            dispatcher = request.getRequestDispatcher("EnterOtp.jsp");
            dispatcher.forward(request, response);

        }

    }

}
