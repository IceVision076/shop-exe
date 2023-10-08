package com.vapeshop.controller.employee.product;

import com.vapeshop.entity.ImageProduct;
import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.employee.ProductRespository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "ProductTypeCreateServlet", value = "/product-type-create")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProductTypeCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId=request.getParameter("productId");
        request.setAttribute("productId",productId);
      request.getRequestDispatcher("dashboard/product-type-create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String productId=request.getParameter("productId");
            String productTypeId=ProductRespository.getNewProductTypeId(productId);
            String typeName=request.getParameter("typeName");
            double typePrice= Double.parseDouble(request.getParameter("price"));

            //Lưu file
            String appPath = request.getServletContext().getRealPath("");
//        D:\Project_final_intership\VapeShope\target\VapeShope-1.0-SNAPSHOT\assets\img\product
            appPath.replace('\\', '/');
            String savePath = "src/main/webapp/assets/img/product";
//        D:\Project_final_intership\VapeShope\src\main\webapp\assets\img\product
            String fileName = "";

            for (Part part : request.getParts()) {
                // System.out.println(part.getHeader("content-disposition"));
                if (!part.getHeader("content-disposition").contains("filename")) {
                    continue;
                }

                fileName = productTypeId + "_1" + ".jpg";

                if (fileName != null && fileName.length() > 0) {
                    String filePath = appPath.substring(0,appPath.indexOf("VapeShop")+9) + savePath + File.separator + fileName;
                    part.write(filePath);
                }

            }
            ProductType productType= new ProductType(productTypeId,productId,typeName,typePrice);
            ImageProduct imageProduct=new ImageProduct();
            String imgeUrl=savePath.substring(savePath.lastIndexOf("assets"))+"/"+fileName;
            imageProduct.setImageUrl(imgeUrl);
            productType.getImageProducts().add(imageProduct);
            ProductRespository.addNewProductType(productType);
        }catch (Exception e){
         e.printStackTrace();
        }

    }
}
