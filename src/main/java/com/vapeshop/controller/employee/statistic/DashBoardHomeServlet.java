package com.vapeshop.controller.employee.statistic;

import com.vapeshop.entity.ProductType;
import com.vapeshop.entity.statistic.MoneyWithMonth;
import com.vapeshop.entity.statistic.MoneyWithWeek;
import com.vapeshop.entity.statistic.Top10MostPurchased;
import com.vapeshop.respository.employee.StatisticalRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DashBoardHomeServlet", value = "/dashboard-home")
public class DashBoardHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int totalUser = StatisticalRespository.totalUser();
        int[] productAmountChart = StatisticalRespository.productAmountChart();
        double totalMoneyBeforeMonth = StatisticalRespository.totalMoneyBeforeMonth();
        double totalMoneyOnMonth = StatisticalRespository.totalMoneyOnMonth();
        double totalMoneyToday = StatisticalRespository.totalMoneyToday();
        MoneyWithMonth moneyWithMonth = StatisticalRespository.totalMoneyOnEachMonth();
        MoneyWithMonth moneyWithMonthLastYear = StatisticalRespository.totalMoneyOnEachMonthLastYear();
        int totalEmployeeWorking = StatisticalRespository.totalEmployeeWorking();
        ArrayList<ProductType> top5ProductTypeBestSellOnMonth = StatisticalRespository.top5ProductTypeBestSellOnMonth();
        double totalMoneyJuiceInYear = StatisticalRespository.totalMoneyJuiceInYear();
        double totalMoneyAccessoryInYear = StatisticalRespository.totalMoneyAccessoryInYear();
        double totalMoneyInYear = StatisticalRespository.totalMoneyInYear();
        double totalMoneyBeforeYear = StatisticalRespository.totalMoneyBeforeYear();
        double totalMoneyVapeInYear = StatisticalRespository.totalMoneyVapeInYear();
        int totalCustomerIsLocked = StatisticalRespository.totalCustomerIsLocked();
        MoneyWithWeek moneyWithWeek = StatisticalRespository.totalMoneyOnEachWeek();
        Top10MostPurchased top10MostPurchased = StatisticalRespository.top10MostPurchased();

        double moneyServiceOnMonth = StatisticalRespository.moneyServiceOnMonth();

        double moneyServiceInYear = StatisticalRespository.moneyServiceInYear();

        double moneyServiceToday= StatisticalRespository.moneyServiceOnDay();


        request.setAttribute("moneyServiceOnMonth", moneyServiceOnMonth);

        request.setAttribute("moneyServiceInYear", moneyServiceInYear);

        request.setAttribute("moneyServiceToday", moneyServiceToday);

        request.setAttribute("top10MostPurchased", top10MostPurchased);
        //
        request.setAttribute("moneyWithMonthLastYear", moneyWithMonthLastYear);
        //
        request.setAttribute("moneyWithWeek", moneyWithWeek);
        //
        request.setAttribute("productAmountChart", productAmountChart);
        //
        request.setAttribute("totalUser", totalUser);
        //
        request.setAttribute("totalMoneyBeforeMonth", totalMoneyBeforeMonth);
        //
        request.setAttribute("totalMoneyOnMonth", totalMoneyOnMonth);
        //
        request.setAttribute("totalMoneyToday", totalMoneyToday);
        //
        request.setAttribute("moneyWithMonth", moneyWithMonth);
        //
        request.setAttribute("totalEmployeeWorking", totalEmployeeWorking);
        //
        request.setAttribute("top5ProductTypeBestSellOnMonth", top5ProductTypeBestSellOnMonth);
        //
        request.setAttribute("totalMoneyJuiceInYear", totalMoneyJuiceInYear);
        //
        request.setAttribute("totalMoneyAccessoryInYear", totalMoneyAccessoryInYear);
        //
        request.setAttribute("totalMoneyInYear", totalMoneyInYear);
        //
        request.setAttribute("totalMoneyBeforeYear", totalMoneyBeforeYear);
        //
        request.setAttribute("totalMoneyVapeInYear", totalMoneyVapeInYear);
        //
        request.setAttribute("totalCustomerIsLocked", totalCustomerIsLocked);
        request.getRequestDispatcher("dashboard/dashboard-home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
