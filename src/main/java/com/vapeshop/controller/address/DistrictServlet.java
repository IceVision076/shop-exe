package com.vapeshop.controller.address;

import com.google.gson.Gson;
import com.vapeshop.entity.address.District;
import com.vapeshop.entity.address.Province;
import com.vapeshop.respository.user.AddressRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DistrictServlet", value = "/district")
public class DistrictServlet extends HttpServlet {
    private Gson gson=new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String provinceId = request.getParameter("provinceId");
        List<District> list= AddressRespository.getDistrictByProvinceId(provinceId);
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
