package com.vapeshop.controller.address;

import com.google.gson.Gson;
import com.vapeshop.chat.ChatEndpoint;
import com.vapeshop.entity.address.Province;
import com.vapeshop.respository.user.AddressRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProvinceServlet", value = "/province")
public class ProvinceServlet extends HttpServlet {
    private Gson gson =new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Province> provinceList= AddressRespository.getAllProvinces();
        String voucherJsonString = this.gson.toJson(provinceList);
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
