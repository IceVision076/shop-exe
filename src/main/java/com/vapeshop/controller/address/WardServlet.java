package com.vapeshop.controller.address;

import com.google.gson.Gson;
import com.vapeshop.entity.address.District;
import com.vapeshop.entity.address.Ward;
import com.vapeshop.respository.user.AddressRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "WardServlet", value = "/ward")
public class WardServlet extends HttpServlet {
    private Gson gson=new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String districtId = request.getParameter("districtId");
     List<Ward> list= AddressRespository.getWardByDistrictId(districtId);
        String voucherJsonString = this.gson.toJson(list);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(voucherJsonString);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
