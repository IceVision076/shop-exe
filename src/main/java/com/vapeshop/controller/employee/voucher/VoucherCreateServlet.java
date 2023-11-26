package com.vapeshop.controller.employee.voucher;

import com.vapeshop.entity.Voucher;
import com.vapeshop.respository.employee.VoucherRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

@WebServlet(name = "VoucherCreateServlet", value = "/voucher-create")
public class VoucherCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = request.getParameter("error");
        String success=request.getParameter("success");
       // System.out.println(error);
        if (error == null) {
            request.setAttribute("success",success);
            request.getRequestDispatcher("dashboard/voucher-create.jsp").forward(request, response);
        } else {
            request.setAttribute("error", error);
            request.getRequestDispatcher("dashboard/voucher-create.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        String id = "";
        for (int i = 0; i < 10; i++) {
            // Lấy một ký tự ngẫu nhiên từ chuỗi ký tự
            id += characters.charAt(random.nextInt(characters.length()));
        }



        String voucherName = request.getParameter("voucherName");
        double voucherPercent = Double.parseDouble(request.getParameter("voucherPercent")) / 100;
        LocalDateTime createDate = LocalDateTime.now();
        LocalDateTime closeDate = LocalDateTime.parse(request.getParameter("closeDate"));
        LocalDateTime openDate = LocalDateTime.parse(request.getParameter("openDate"));
        int amount=0;
        char status = '1';
        if (closeDate.isBefore(openDate)) {
            response.sendRedirect("voucher-create?error=1");
        } else {

          if (!request.getParameter("voucherAmount").isEmpty()) amount= Integer.parseInt(request.getParameter("voucherAmount"));
            Voucher voucher = new Voucher(id, voucherName, voucherPercent, createDate, closeDate, status, openDate);
            voucher.setAmount(amount);
            VoucherRespository.addVoucher(voucher);
            response.sendRedirect("voucher-create?success=1");
        }

    }


}
