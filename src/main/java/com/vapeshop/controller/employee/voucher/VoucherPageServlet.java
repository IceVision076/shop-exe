package com.vapeshop.controller.employee.voucher;

import com.vapeshop.entity.Product;
import com.vapeshop.entity.Voucher;
import com.vapeshop.respository.employee.ProductRespository;
import com.vapeshop.respository.employee.VoucherRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DiscountPageServlet", value = "/voucher-page")
public class VoucherPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber=-1;
        int voucherAmount=VoucherRespository.getVoucherAmount();

        int maxPageAmount=(voucherAmount%10==0)?voucherAmount/10:voucherAmount/10+1;
        if(request.getParameter("page")==null) {
            pageNumber=1;
        }

        else
            pageNumber= Integer.parseInt(  request.getParameter("page"))  ;

        if( pageNumber>maxPageAmount||pageNumber<=0) pageNumber=1;
        ArrayList<Voucher> listVoucher= VoucherRespository.getProductPage(pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("listVoucher",listVoucher);
        request.getRequestDispatcher("dashboard/voucher-management.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
