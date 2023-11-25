package com.vapeshop.filter;

import com.vapeshop.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "ServiceEmployeeFilter",urlPatterns = {
        "/service-choice",
        "/service-management",
        "/service-accepted",
        "/service-canceled",
        "/service-success",
        "/service-fail"
})
public class ServiceEmployeeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRole().equals("0")) {
            System.out.println("Không có quyền truy cập vì người dùng không phải nhân viên khi truy cập vào trang quản lý dịch vụ");

            httpServletResponse.sendRedirect("Home");
        } else if (user.getRole().equals("2")) {
            System.out.println("Không có quyền truy cập vì người dùng không phải nhân viên khi truy cập vào trang quản lý dịch vụ");

            httpServletResponse.sendRedirect("dashboard-home");
        }else{
            chain.doFilter(request, response);
        }

    }
}
