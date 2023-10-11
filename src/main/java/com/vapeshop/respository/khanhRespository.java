package com.vapeshop.respository;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class khanhRespository {
    public static void upadteProfile(User user) {
        try {
            Connection con = DBConnect.getConnection();
            String query = "UPDATE [dbo].[UserInfo]\n"
                    + "   SET "
                    + "      [full_name] = ?\n"
                    + "      ,[phone] = ? \n"
                    + "      ,[address] = ?\n"
                    + " WHERE id=?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getId());
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public User getUserById(String id) {

        User user = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select * from UserInfo where id =?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getString("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role").charAt(0));
                user.setPhone(resultSet.getString("phone"));
                user.setStatus(resultSet.getString("status").charAt(0));
                user.setAvataImg(resultSet.getString("avata_img"));
                user.setAddress(resultSet.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public static void main(String[] args) {
        // Tạo một đối tượng UserDAO (hoặc lớp chứa phương thức getUserById)
       khanhRespository dao=new khanhRespository();

        // ID của người dùng bạn muốn lấy thông tin
        String userIdToRetrieve = "AC00000001"; // Thay đổi thành ID thực tế

        // Gọi phương thức getUserById để lấy thông tin người dùng
        User user = dao.getUserById(userIdToRetrieve);

        // Kiểm tra xem thông tin người dùng có được lấy thành công hay không
        if (user != null) {
            System.out.println("Thông tin người dùng:");
            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Full Name: " + user.getFullName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Role: " + user.getRole());
            System.out.println("Phone: " + user.getPhone());
            System.out.println("Status: " + user.getStatus());
            System.out.println("Avatar Image: " + user.getAvataImg());
            System.out.println("Address: " + user.getAddress());
        } else {
            System.out.println("Không tìm thấy người dùng có ID: " + userIdToRetrieve);
        }
    }

}