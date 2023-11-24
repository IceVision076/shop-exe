package com.vapeshop.controller.employee.order;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "DownloadServlet", value = "/download-order")
public class DownloadOrderServlet extends HttpServlet {
    private final int ARBITARY_SIZE = 1048;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath=request.getParameter("filepath");
        String orderId=request.getParameter("orderId");
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename="+orderId+".pdf");
                //"D:\\Project_final_intership\\Invoice\\history\\uwYSpKPDdl.pdf";
        try(InputStream in = new FileInputStream(filePath);
            OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[ARBITARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
