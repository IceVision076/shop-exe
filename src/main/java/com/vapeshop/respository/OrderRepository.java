package com.vapeshop.respository;

import com.vapeshop.config.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderRepository {
    public static double getPriceOrdered(String orderId, String productId) {
        System.out.println("cho nay ne" + orderId);
        System.out.println("cho nay ne" + productId);
        double price = 0;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select price_at_purchase from OrderDetail where product_type_id=? and order_id =?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, productId);
            stmt.setString(2, orderId);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                price = results.getDouble(1);
                System.out.println("=>>>>>>>>>>>>>>>>>>.." + price);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getPriceOrdered()<=============");
        }
        return price;
    }
}
