package com.vapeshop.respository;


import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRespository {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

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

    public User login(String usernameOrEmail, String passWord) throws SQLException {
        String query_account = " SELECT * FROM [dbo].[UserInfo] WHERE (username = ? OR email = ?) AND password = ?";
        try {

            conn =  DBConnect.getConnection();

            ps = conn.prepareStatement(query_account);
            ps.setString(1, usernameOrEmail);
            ps.setString(2, usernameOrEmail);
            ps.setString(3, passWord);
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

    public User CheckEmailExist(String email) {

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

        } catch (Exception e) {
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
        for (int i = 1; i <= 8 - ((idGet+1) + "").length(); i++) {
            result = result + "0";
        }
        result = result + idGet;
        return result;
    }
    public static void upadateProfile(User user) {
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
                user.setUserName(resultSet.getString("username"));

                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(String.valueOf(resultSet.getString("role").charAt(0)));
                user.setPhone(resultSet.getString("phone"));
                user.setStatus(String.valueOf(resultSet.getString("status").charAt(0)));
                user.setAvatarImg(resultSet.getString("avata_img"));
                user.setAddress(resultSet.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public static void main(String[] args) {
        // Gọi phương thức setIDDatabase và cung cấp chuỗi đầu vào "AC00000999"
//        String inputString = "AC00000010";
//        String newID = setIDDatabase(inputString);
//
//        // In kết quả
//        System.out.println("New ID: " + newID);

//          Tạo một đối tượng UserRegistration (điều này giả sử bạn đã tạo một lớp có phương thức Register)
        // Gọi phương thức Register để đăng ký người dùng
        // Thông tin người dùng mới
//        String id = ""; // Bạn có thể để trống hoặc tự tạo id mới
//        String userName = "john_doe";
//        String passWord = "password123";
//        String fullName = "John Doe";
//        String email = "john.doe@example.com";
//        String role = "";
//        String phone = "1234567890";
//        String status = "";
//        String avatarImg = "a";
//        String address = "123 Main St";

//        // Tạo đối tượng để thực hiện đăng ký
//        UserRespository ur = new UserRespository();
//        ur.Register(id, userName, passWord, fullName, email, role, phone, status, avatarImg, address);
//
//        // In thông báo khi đăng ký thành công hoặc xử lý lỗi ở đây
//        System.out.println("Đăng ký thành công!");
//



        String email = "nguyenngocnhan442002@gmail.com";
        String pass = "123456789";
        UserRespository dao = new UserRespository();
        dao.resetPassWord(email, pass);

    }

}