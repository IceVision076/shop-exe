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

@WebServlet(name = "CustomerManagementServlet", value = "/customer-management")
public class CustomerManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber=-1;
        int maxPageAmount= AccountRespository.getCustomerAmount()/10+1;
        if(request.getParameter("page")==null) {
            pageNumber=1;
        }

        else
            pageNumber= Integer.parseInt(  request.getParameter("page"))  ;

        if( pageNumber>maxPageAmount||pageNumber<=0) pageNumber=1;
        ArrayList<User> listCustomer=AccountRespository.getCustomerList(pageNumber);
        request.setAttribute("maxPage",maxPageAmount);
        request.setAttribute("page",pageNumber);
        request.setAttribute("listCustomer",listCustomer);
        request.getRequestDispatcher("dashboard/customer-management.jsp").forward(request,response);

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
        response.sendRedirect("customer-management?page="+page);
    }
}
