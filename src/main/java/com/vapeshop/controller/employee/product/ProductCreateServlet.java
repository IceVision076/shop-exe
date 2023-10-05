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

@WebServlet(name = "ProductCreateServlet", value = "/product-create")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProductCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        System.out.println(request.getServletContext().getRealPath("").substring(0,request.getServletContext().getRealPath("").lastIndexOf("target")));
        String realPath = request.getServletContext().getRealPath("");
        System.out.println(realPath.substring(0,realPath.lastIndexOf("VapeShop")+9));
        realPath.replace('\\', '/');
//        String savePath = realPath + "assets/img/product";
//        File f = new File(savePath);
//        if (f.exists()) System.out.println("===================ok có==================");
//        else
//            System.out.println("===================không có==================");
        request.getRequestDispatcher("dashboard/product-create.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //lấy loại sản phẩm từ form
        String choiceProducType = request.getParameter("typechoice");
        String productId = ProductRespository.getNewProductId(Integer.parseInt(choiceProducType));
        String productName = request.getParameter("productName");
        String brand = request.getParameter("brand");
        String detail = request.getParameter("detail");
        String origin = request.getParameter("origin");
        String productTypeName = request.getParameter("productTypeName");
        double price = 0;

        try {
            price = Double.parseDouble(request.getParameter("price"));
        } catch (Exception e) {

            e.printStackTrace();
        }

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

            fileName = productId + "A_1" + ".jpg";

            if (fileName != null && fileName.length() > 0) {
                String filePath = appPath.substring(0,appPath.lastIndexOf("VapeShop")+9) + savePath + File.separator + fileName;
                part.write(filePath);
            }

        }
        Product product = new Product(productId, productName, brand, detail, origin, '1');
        ProductType productType = new ProductType(productId + 'A', productId, productTypeName, price);
        ImageProduct imageProduct = new ImageProduct(productId + 'A', "test", savePath.substring(savePath.lastIndexOf("assets"))+"/"+fileName);
        ProductRespository.addNewProduct(product, productType, imageProduct);

    }
}
