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
    public static void addNewEmployee(User user){
        try {
            user.setId(getNewUserId());
            String query = "insert into UserInfo(id, username, password, full_name, email, role, phone, status, avata_img, address)\n" +
                    "values (?,?,?,?,?,?,?,?,?,?)";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getId());
            preparedStatement.setString(2,user.getUserName());
            preparedStatement.setString(3,user.getPassWord());
            preparedStatement.setString(4,user.getFullName());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6,user.getRole());
            preparedStatement.setString(7,user.getPhone());
            preparedStatement.setString(8,user.getStatus());
            preparedStatement.setString(9,user.getAvatarImg());
            preparedStatement.setString(10,user.getAddress());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String getNewUserId() {
        String newID = "";
        try {
            String topID = "";
            String query = "SELECT TOP 1 ID FROM UserInfo\n" +
                    "                ORDER BY ID DESC\n";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                topID = resultSet.getString(1);
                topID = topID.substring(2);
                int maxID = Integer.parseInt(topID) + 1;
                topID = "";
                for (int i = 1; i <= 8 - (maxID + "").length(); i++) {
                    topID = topID + 0;
                }
                topID = topID + maxID;
                newID="AC"+topID;
            }
            else {
                newID="PT00000001";
            }


            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newID;
    }

    public static boolean checkEmailExist(String email){
        boolean check=false;
        try {
            String query="select email from UserInfo\n" +
                    "where email=?";
            Connection connection=DBConnect.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) check=true;
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }
    public static boolean checkPhoneExist(String phone){
        boolean check=false;
        try {
            String query="select phone from UserInfo\n" +
                    "where phone=?";
            Connection connection=DBConnect.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,phone);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) check=true;
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }
    public static boolean checkUsernameExist(String phone){
        boolean check=false;
        try {
            String query="select username from UserInfo\n" +
                    "where username=?";
            Connection connection=DBConnect.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,phone);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) check=true;
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }

    public static void main(String[] args) {
//        getCustomerList(1).stream().forEach(System.out::println);
//        System.out.println(getCustomerAmount());
//        System.out.println(getNewUserId());
        System.out.println(checkEmailExist("Leo1@gmail.com"));
    }


}
