package com.vapeshop.controller.employee.statistic;

import com.vapeshop.respository.employee.StatisticalRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DashBoardHomeServlet", value = "/dashboard-home")
public class DashBoardHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalUser = StatisticalRespository.totalUser();
        int[] productAmountChart = StatisticalRespository.productAmountChart();
        //lấy số lượng vape

        request.setAttribute("productAmountChart", productAmountChart);
        request.setAttribute("totalUser", totalUser);
        request.getRequestDispatcher("dashboard/dashboard-home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}