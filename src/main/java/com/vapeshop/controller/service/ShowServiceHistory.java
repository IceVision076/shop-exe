package com.vapeshop.controller.service;

import com.vapeshop.entity.ServiceTracking;
import com.vapeshop.respository.user.ProductRepository;
import com.vapeshop.respository.user.ServiceTrackingRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/ServiceTrackingHistory", name = "ServiceTrackingHistory")


public class ShowServiceHistory extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String indexPage = req.getParameter("index");
        int index = -1;
        if (indexPage != null) {
            index = Integer.parseInt(indexPage);
        }

        int count = ServiceTrackingRepository.getTotalServiceTracking();
        int endPage = count / 10;
        if (count % 10 != 0) {
            endPage++;
        }

        if (index < 1 || index > endPage) {
            index = 1;
        }
        ArrayList<ServiceTracking> serviceTrackingArrayList = ServiceTrackingRepository.getServiceTrackingHistory(index);

        req.setAttribute("serviceTrackingArrayList",serviceTrackingArrayList);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.getRequestDispatcher("ServiceTrackingHistory.jsp").forward(req, resp);
    }
}
