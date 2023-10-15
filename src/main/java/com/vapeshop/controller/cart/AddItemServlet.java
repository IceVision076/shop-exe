package com.vapeshop.controller.cart;

import com.vapeshop.entity.Items;
import com.vapeshop.entity.Order;
import com.vapeshop.entity.ProductType;
import com.vapeshop.respository.ProductRepository;
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
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null) {
            request.setAttribute("thongbao", "Vui lòng đăng nhập để sử dụng dịch vụ");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        try {
            String id = request.getParameter("id");
            String ammout = request.getParameter("ammount");
            ProductType p = null;
                p = ProductRepository.getProductType(id);
            Order cart = (Order) session.getAttribute("cart");
            Items item = new Items(p, Integer.parseInt(ammout));
                System.out.println(cart.addItems(item));
                System.out.println(cart);
                request.setAttribute("product", p);
                request.setAttribute("message", "Thêm sản phẩm thành công");
                response.setCharacterEncoding("UTF-8");
                session.setAttribute("cart", cart);
                request.getRequestDispatcher("product-detail.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("=============>Loi AddItemServlet <===============");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
