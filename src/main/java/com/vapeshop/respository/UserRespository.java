package com.vapeshop.respository;


import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRespository {

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    private void CloseResources() {
        try {

            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User login(String userName, String passWord) throws SQLException {
        String query_account = "  select *FROM [VapeShopDB].[dbo].[UserInfo] where [username]= ? and [password] =?";
        try {
            conn =  DBConnect.getConnection();
            ps = conn.prepareStatement(query_account);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));

            }

        } catch (Exception e) {
        }
        return null;
    }

    public User CheckAccoutExist(String UserName) {

        String query_check = "SELECT [id]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[full_name]\n"
                + "      ,[email]\n"
                + "      ,[role]\n"
                + "      ,[phone]\n"
                + "      ,[status]\n"
                + "      ,[avata_img]\n"
                + "      ,[address]\n"
                + "  FROM [dbo].[UserInfo]\n"
                + "  Where [username] = ?";

        try {
            conn =  DBConnect.getConnection();
            ps = conn.prepareStatement(query_check);
            ps.setString(1, UserName);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));

            }

        } catch (Exception e) {
        }
        return null;
    }

    public User CheckEmailtExist(String email) {

        String query_check = "SELECT [id]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[full_name]\n"
                + "      ,[email]\n"
                + "      ,[role]\n"
                + "      ,[phone]\n"
                + "      ,[status]\n"
                + "      ,[avata_img]\n"
                + "      ,[address]\n"
                + "  FROM [dbo].[UserInfo]\n"
                + "  Where [email] = ?";

        try {
            conn =  DBConnect.getConnection();
            ps = conn.prepareStatement(query_check);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));

            }

        } catch (Exception e) {
        }
        return null;
    }

    public void Register(
            String id,
            String userName,
            String passWord,
            String fullName,
            String email,
            String role,
            String phone,
            String status,
            String avatarImg,
            String address) {

        String get_last_Id = "SELECT TOP 1 id FROM [dbo].[UserInfo] ORDER BY id DESC";

        try {
            conn =  DBConnect.getConnection();
            ps = conn.prepareStatement(get_last_Id);
            rs = ps.executeQuery();
            String lastId = "AC00000000";

            if (rs.next()) {
                lastId = rs.getString("id");

            }

            String newID = setIDDatabase(lastId);
            role = "0";
            status = "1";

            String query_Register = "INSERT INTO [dbo].[UserInfo] ([id], [username],[password],[full_name],[email],[role],[phone],[status],[avata_img],[address])\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?);";

            ps = conn.prepareStatement(query_Register);
            ps.setString(1, newID);
            ps.setString(2, userName);
            ps.setString(3, passWord);
            ps.setString(4, fullName);
            ps.setString(5, email);
            ps.setString(6, role);
            ps.setString(7, phone);
            ps.setString(8, status);
            ps.setString(9, avatarImg);
            ps.setString(10, address);
            ps.executeUpdate();

        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            CloseResources();
        }
    }

    public void resetPassWord(String email, String passWord) {
        String resetPass = "UPDATE [dbo].[UserInfo] SET [password] = ? WHERE [email] = ?";
        try {
            conn =  DBConnect.getConnection();
            ps = conn.prepareStatement(resetPass);
            ps.setString(1, passWord);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            CloseResources();
        }
    }

    public static String setIDDatabase(String s) {
        // Phần này giữ nguyên mã đã cung cấp trong câu hỏi ban đầu
        int idGet = Integer.parseInt(s.substring(2)) + 1;
        String result = "AC";
        for (int i = 1; i <= 8 - (idGet + "").length(); i++) {
            result = result + "0";
        }
        result = result + idGet;
        return result;
    }


}
