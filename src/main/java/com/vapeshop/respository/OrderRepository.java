package com.vapeshop.respository;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.*;
import com.vapeshop.respository.employee.ProductRespository;
import com.vapeshop.respository.generator.Isvalid;
import com.vapeshop.respository.generator.RandomGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderRepository {

    public static String getOrderId() {
        try {
            String OrderId = RandomGenerator.generateRandomString();
            System.out.println("==>Order id random 1 : " +OrderId );
            String query = "select order_id from [Order]";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            ArrayList<String> listOrderID = new ArrayList<>();
            while (results.next()) {
                String OrderIdDB = results.getString(1);
                listOrderID.add(OrderIdDB);
            }
            for (String oDB : listOrderID) {
                if (oDB.equals(OrderId)) {
                    OrderId = RandomGenerator.generateRandomString();
                }
            }
            return OrderId;
        } catch (Exception e) {
            System.out.println("Loi method getOrderId()trong OrderRepository.java ");
        }
        return null;
    }
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

    public static String createOrder(Order cart, User user) {
        try {
            Connection con = DBConnect.getConnection();
            String query = "INSERT INTO [Order] (order_id,user_id,create_date,delivery_date,status,voucher_id,address ) values\n" +
                    "(?,?,?,?,?,?,?)";
            String orderID = getOrderId();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, orderID) ;
            stmt.setString(2, user.getId());
            stmt.setObject(3, LocalDateTime.now());
            stmt.setString(4, null);
            if (cart.getPaymentType() == 0) {
                stmt.setObject(5, "0");

            } else {
                stmt.setObject(5, "1");
            }
            stmt.setString(6, cart.getDiscountCode());
            stmt.setString(7, user.getAddress());
            /**
             * 0 la dang xu ly - cod
             * 1 la dang xu ly - ck
             * 2 da xu ly
             * 3 huy
             * 4 da giao hang thanh cong :D
             */
            stmt.executeUpdate();
            con.close();
            createOrderDetail(cart, orderID);
            return orderID;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi method createOrder(Cart cart, User user) trong OrderRepository.java ");
        }
        return null;
    }
//get ammount cua item la so luong trong gio hang :D
    public static boolean createOrderDetail(Order cart, String orderId) {
        System.out.println("=>>>>....>>>>>>>>>>>>>>>>>>>>>>>" + orderId);
        System.out.println(cart.getCart());

        for (Items i : cart.getCart()) {
            try {
                Connection con = DBConnect.getConnection();
                String query = "insert into OrderDetail values (?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, orderId); //id cua cai bill
                stmt.setString(2, i.getProductType().getProductTypeId()); //id cua san pham
                stmt.setInt(3, i.getAmmout()); //so luong
                stmt.setDouble(4, i.getPrice()); //gia luc mua
                stmt.executeUpdate();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Loi method createOrderDetail(Cart cart,String orderId) trong OrderRepository.java ");

            }
        }
        return true;
    }

    public static ArrayList<Items> getOrder(String OrderId) {
        try {
            ArrayList<Items> orderedList = new ArrayList<>();
            Connection con = DBConnect.getConnection();
            String query = "select * from OrderDetail where order_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, OrderId);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                Items item = new Items();
                item.setAmmout(results.getInt(3));
                item.setProductType(getProductTypeById(results.getString(2)));
                //lay id product
                item.getProductType().setProduct(ProductRespository.getProductById(item.getProductType().getProductId()));
                orderedList.add(item);
            }
            con.close();
            return orderedList;
        } catch (Exception e) {
            System.out.println("=============>ERROR :  ArrayList<Items> getOrder(String OrderId) <==============");
        }
        return null;
    }

    //method nay chua sua :(
    public static ProductType getProductTypeById(String orderdetailId) {
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT * FROM ProductType t join ImageProduct i  ON t.Id = i.product_type_id WHERE t.Id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, orderdetailId);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                    String id = results.getString(1); //id la productTypeId
                    String productId = results.getString(2);
                    String name = results.getString(3);
                    double price = results.getDouble(4);

                    String productTypeId = results.getString(6);
                    String idImg = results.getString(7);
                    String imgUrl = results.getString(8);
                    con.close();
                    ImageProduct imageProduct = new ImageProduct(productTypeId,idImg,imgUrl);
                ArrayList<ImageProduct> urls = new ArrayList<>();
                    urls.add(imageProduct);
                    return new ProductType(id,productId,name,price,urls);

            }
            con.close();
            return null;

        } catch (Exception e) {
            System.out.println("=========>ERROR :getProductTypeById(String orderdetailId) <===========");
        }
        return null;
    }

    public static String getOrderStatus(String orderId) {
        String id = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "SELECT [status] FROM [Order] WHERE order_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, orderId);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                id = results.getString(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getOrderStatus()<=============");
        }
        return id;
    }
    public static String getDiscountCodeByOrderID(String orderid) {
        String discountCode = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select voucher_id from Order where order_id =?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, orderid);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                discountCode = results.getString(1);
                System.out.println("=>>>>>>>>>>>>>>>>>>.." + discountCode);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getDiscountCodeByOrderID()<=============");
        }
        return discountCode;
    }

    public static double getDiscountPercent(String discountID) {
        double quantity = 0f;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select vourcher_percent from Voucher where id =?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, discountID);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                quantity = results.getDouble(1);
                System.out.println("=>>>>>>>>>>>>>>>>>>.." + quantity);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getDiscountPercent()<=============");
        }
        return quantity;
    }

}
