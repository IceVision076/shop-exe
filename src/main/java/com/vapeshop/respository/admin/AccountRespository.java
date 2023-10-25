package com.vapeshop.respository.admin;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.ImageProduct;
import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;
import com.vapeshop.entity.User;
import org.eclipse.tags.shaded.org.apache.bcel.generic.PUSH;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountRespository {
    public static ArrayList<User> getEmployeeList(int page) {
        ArrayList<User> list = null;
        try {
            String query = "SELECT id,username,full_name,email,phone,address,avata_img,status\n" +
                    "FROM UserInfo\n" +
                    "where  role=1\n" +
                    "order by id\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet rs = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                User user=new User();
                user.setId(rs.getString("id"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setAvatarImg(rs.getString("avata_img"));
                user.setStatus(rs.getString("status"));
                list.add(user);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int getEmployeeAmount() {
        int amount = 0;
        try {
            String query = "\n" +
                    "select count(1)\n" +
                    "from UserInfo\n" +
                    "where role=1";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) amount = rs.getInt(1);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }
    public static ArrayList<User> getCustomerList(int page) {
        ArrayList<User> list = null;
        try {
            String query = "SELECT id,username,full_name,email,phone,address,avata_img,status\n" +
                    "FROM UserInfo\n" +
                    "where  role=0\n" +
                    "order by id\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet rs = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                User user=new User();
                user.setId(rs.getString("id"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setAvatarImg(rs.getString("avata_img"));
                user.setStatus(rs.getString("status"));
                list.add(user);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int getCustomerAmount() {
        int amount = 0;
        try {
            String query = "\n" +
                    "select count(1)\n" +
                    "from UserInfo\n" +
                    "where role=0";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) amount = rs.getInt(1);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }
    public static void openAccount(String id){
        try {
            String query = "UPDATE UserInfo\n" +
                    "SET status=1\n" +
                    "WHERE id=?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void lockAccount(String id){
        try {
            String query = "UPDATE UserInfo\n" +
                    "SET status=0\n" +
                    "WHERE id=?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        getCustomerList(1).stream().forEach(System.out::println);
        System.out.println(getCustomerAmount());
    }


}
