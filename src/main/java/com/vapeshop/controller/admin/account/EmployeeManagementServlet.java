package com.vapeshop.controller.admin.account;

import com.vapeshop.entity.Product;
import com.vapeshop.entity.User;
import com.vapeshop.respository.admin.AccountRespository;
import com.vapeshop.respository.employee.ProductRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmployeeManagementServlet", value = "/employee-account-management")
public class EmployeeManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber=-1;
        int maxPageAmount= AccountRespository.getEmployeeAmount()/10+1;
        if(request.getParameter("page")==null) {
            pageNumber=1;
        }

        else
            pageNumber= Integer.parseInt(  request.getParameter("page"))  ;

        if( pageNumber>maxPageAmount||pageNumber<=0) pageNumber=1;
        ArrayList<User> listEmployee=AccountRespository.getEmployeeList(pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("listEmployee",listEmployee);
        request.getRequestDispatcher("dashboard/employee-account-management.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        String id=request.getParameter("id");
        String page=request.getParameter("page");

        if(action.equals("lock"))
        {
            AccountRespository.lockAccount(id);
        }
        else if(action.equals("open")){
            AccountRespository.openAccount(id);
        }
        response.sendRedirect("employee-account-management?page="+page);
    }
}
