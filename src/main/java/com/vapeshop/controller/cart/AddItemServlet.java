package com.vapeshop.controller.cart;

import com.vapeshop.entity.Items;
import com.vapeshop.entity.Order;
import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.user.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AddItemServlet", value = "/additem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        response.setContentType("text/html;charset=UTF-8");
        String message = "";
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null) {
            request.setAttribute("message", "Vui lòng đăng nhập để sử dụng dịch vụ");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
        else if (request.getParameter("typeidcart").equals("") ||request.getParameter("typeidcart").isEmpty() ) {

            String brand = request.getParameter("brand");
            String idProduct = request.getParameter("idProduct");
            message = "1";
//            request.removeAttribute("quantity");
//            request.re
//            request.setAttribute("mes", "bruhdua");
//            request.setAttribute("brand",brand+"alo");
//            request.setAttribute("idProduct",idProduct);

            System.out.println("Nhay zo ne");
//            message = "Vui lòng chọn phân loại sản phẩm";


//            request.getRequestDispatcher("ShowProductDetails").forward(request, response);
            response.sendRedirect("ShowProductDetails?idProduct="+idProduct+"&brand="+brand+"&message="+message);



        } else {
            try {
                String id = request.getParameter("typeidcart");
                String quantity = request.getParameter("quantity");

                ProductType p = null;
                p = ProductRepository.getProductType(id); // lay cai type

                Order cart = (Order) session.getAttribute("cart");

                Product product = ProductRepository.getProductByID(p.getProductId()); //Add product vao productType
                p.setProduct(product);

                Items item = new Items(p, Integer.parseInt(quantity));
                System.out.println(cart.addItems(item));
                System.out.println(cart);
                request.setAttribute("product", p);
                message = "Thêm sản phẩm thành công";
                request.setAttribute("message",message);

                String brand = request.getParameter("brand");
                String idProduct = request.getParameter("idProduct");
                request.setAttribute("brand",brand);
                request.setAttribute("idProduct",idProduct);

                response.setCharacterEncoding("UTF-8");
                session.setAttribute("cart", cart);
                request.getRequestDispatcher("ShowProductDetails").forward(request, response);
            } catch (Exception e) {
                System.out.println("=============>Loi AddItemServlet <===============");
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
