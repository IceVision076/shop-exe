package com.vapeshop.respository.employee;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRespository {
    public static ArrayList<Order> orderWaitingPage(int page) {
        ArrayList<Order> list = null;
        try {
            String query = "select *\n" +
                    "from [Order]\n" +
                    "where status = '0'\n" +
                    "or status='1'\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String orderId = resultSet.getString("order_id");
                String userId = resultSet.getString("user_id");
                LocalDateTime createDate = resultSet.getObject("create_date", LocalDateTime.class);
                char status = resultSet.getString("status").charAt(0);
                String voucherId = resultSet.getString("voucher_id");
                String address = resultSet.getString("address");
                Order order = new Order();
                order.setOrderId(orderId);
                order.setUserId(userId);
                order.setCreateDate(createDate);
                order.setStatus(status);
                order.setVoucherId(voucherId);
                order.setAddress(address);
                list.add(order);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int orderWaitingAmount() {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from [Order]\n" +
                    "where status = '1' or status='0'";

            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) amount = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static ArrayList<Order> orderAccepted(int page) {
        ArrayList<Order> list = null;
        try {
            String query = "select *\n" +
                    "from [Order]\n" +
                    "where status = '2'\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String orderId = resultSet.getString("order_id");
                String userId = resultSet.getString("user_id");
                LocalDateTime createDate = resultSet.getObject("create_date", LocalDateTime.class);
                char status = resultSet.getString("status").charAt(0);
                String voucherId = resultSet.getString("voucher_id");
                String address = resultSet.getString("address");
                Order order = new Order();
                order.setOrderId(orderId);
                order.setUserId(userId);
                order.setCreateDate(createDate);
                order.setStatus(status);
                order.setVoucherId(voucherId);
                order.setAddress(address);
                list.add(order);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int orderAcceptedAmount() {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from [Order]\n" +
                    "where status = '2' ";

            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) amount = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static ArrayList<Order> orderCanceled(int page) {
        ArrayList<Order> list = null;
        try {
            String query = "select *\n" +
                    "from [Order]\n" +
                    "where status = '3'\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String orderId = resultSet.getString("order_id");
                String userId = resultSet.getString("user_id");
                LocalDateTime createDate = resultSet.getObject("create_date", LocalDateTime.class);
                char status = resultSet.getString("status").charAt(0);
                String voucherId = resultSet.getString("voucher_id");
                String address = resultSet.getString("address");
                Order order = new Order();
                order.setOrderId(orderId);
                order.setUserId(userId);
                order.setCreateDate(createDate);
                order.setStatus(status);
                order.setVoucherId(voucherId);
                order.setAddress(address);
                list.add(order);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int orderCanceledAmount() {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from [Order]\n" +
                    "where status = '3' ";

            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) amount = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static ArrayList<Order> orderSuccess(int page) {
        ArrayList<Order> list = null;
        try {
            String query = "select *\n" +
                    "from [Order]\n" +
                    "where status = '4'\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String orderId = resultSet.getString("order_id");
                String userId = resultSet.getString("user_id");
                LocalDateTime createDate = resultSet.getObject("create_date", LocalDateTime.class);
                char status = resultSet.getString("status").charAt(0);
                String voucherId = resultSet.getString("voucher_id");
                String address = resultSet.getString("address");
                Order order = new Order();
                order.setOrderId(orderId);
                order.setUserId(userId);
                order.setCreateDate(createDate);
                order.setStatus(status);
                order.setVoucherId(voucherId);
                order.setAddress(address);
                list.add(order);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int orderSuccessAmount() {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from [Order]\n" +
                    "where status = '4' ";

            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) amount = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static ArrayList<Order> orderFail(int page) {
        ArrayList<Order> list = null;
        try {
            String query = "select *\n" +
                    "from [Order]\n" +
                    "where status = '5'\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String orderId = resultSet.getString("order_id");
                String userId = resultSet.getString("user_id");
                LocalDateTime createDate = resultSet.getObject("create_date", LocalDateTime.class);
                char status = resultSet.getString("status").charAt(0);
                String voucherId = resultSet.getString("voucher_id");
                String address = resultSet.getString("address");
                Order order = new Order();
                order.setOrderId(orderId);
                order.setUserId(userId);
                order.setCreateDate(createDate);
                order.setStatus(status);
                order.setVoucherId(voucherId);
                order.setAddress(address);
                list.add(order);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int orderFailAmount() {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from [Order]\n" +
                    "where status = '5' ";

            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) amount = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static char checkStatusOrder(String orderId) {
        char status = 0;
        try {
            String query = "select status from [Order] where order_id=?;";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) status = resultSet.getString(1).charAt(0);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static void updateWaitingAccepted(String orderId) {

        try {
            String query = "update [Order] set status = '2' where order_id = ?";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updateWaitingCanceled(String orderId) {

        try {
            String query = "update [Order] set status = '3' where order_id = ?";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updateAcceptedSuccess(String orderId) {

        try {
            String query = "update [Order] set status = '4' where order_id = ?";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updateAcceptedFail(String orderId) {

        try {
            String query = "update [Order] set status = '5' where order_id = ?";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Order getOrderById(String orderId) {
        Order order = new Order();
        try {
            String query = "select [Order].*,UI.full_name,vourcher_percent,voucher_id  from [Order]\n" +
                    "       join UserInfo UI on [Order].user_id = UI.id\n" +
                    "    left join Voucher on [Order].voucher_id = Voucher.id\n" +
                    "where [Order].order_id=?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {


                String userId = resultSet.getString("user_id");
                LocalDateTime createDate = resultSet.getObject("create_date", LocalDateTime.class);
                String orderAddress = resultSet.getString("address");
                char status = resultSet.getString("status").charAt(0);
                String voucherId = resultSet.getString("voucher_id");
                double vourcherPercent = resultSet.getDouble("vourcher_percent"); //phan tram giam gia

                String fullNameUser = resultSet.getString("full_name");

                //user
                User user = new User();
                user.setFullName(fullNameUser);
                user.setId(userId);

                //voucher
                Voucher voucher = new Voucher();
                voucher.setId(voucherId);
                voucher.setVoucherPercent(vourcherPercent);


                //OrderDetail
                ArrayList<OrderDetail> orderDetails = OrderRespository.getOrderdetailByOrderId(orderId);


                //order
                order.setOrderId(orderId);
                order.setCreateDate(createDate);
                order.setStatus(status);
                order.setOrderAddress(orderAddress);

                order.setUser(user);
                order.setOrderDetails(orderDetails);
                order.setVoucher(voucher);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }


    public static ArrayList<OrderDetail> getOrderdetailByOrderId(String orderId) {
        ArrayList<OrderDetail> list = null;
        try {
            String query = "select * from OrderDetail where order_id = ?";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                OrderDetail orderDetail = new OrderDetail();

                String productTypeId = resultSet.getString("product_type_id");
                int amount = resultSet.getInt("amount");
                double priceAtPurchase = resultSet.getDouble("price_at_purchase");

                ProductType productType=ProductRespository.getProductTypeById(productTypeId);

                orderDetail.setProductType(productType);
                orderDetail.setOrderId(orderId);
                orderDetail.setProductTypeId(productTypeId);
                orderDetail.setAmount(amount);
                orderDetail.setPriceAtPurchase(priceAtPurchase);
                list.add(orderDetail);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void main(String[] args) {
        Order order = OrderRespository.getOrderById("0lbSoK6BNR");
        System.out.println(order.getOrderId());

    }
}
