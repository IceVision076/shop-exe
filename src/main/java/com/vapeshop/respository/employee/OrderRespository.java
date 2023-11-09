package com.vapeshop.respository.employee;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.Items;
import com.vapeshop.entity.Order;
import com.vapeshop.entity.ServiceTracking;

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
    public static void main(String[] args) {
        System.out.println(orderAcceptedAmount());
//       orderWaitingPage(1).stream().forEach(System.out::println);
    }
}
