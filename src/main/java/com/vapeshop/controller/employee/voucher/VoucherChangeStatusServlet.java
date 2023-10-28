package com.vapeshop.controller.employee.voucher;

import com.vapeshop.respository.employee.VoucherRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "VoucherChangeStatusServlet", value = "/voucher-change-status")
public class VoucherChangeStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String page=request.getParameter("page");
    String id=request.getParameter("voucherId");
    String action=request.getParameter("action");
    if(action.equals("open")){
        VoucherRespository.openVoucher(id);
    } else if (action.equals("close")) {
        VoucherRespository.closeVoucher(id);
    }
    response.sendRedirect("voucher-page?page="+page);
    }
}
