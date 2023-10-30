package com.vapeshop.respository.employee;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.Poster;
import com.vapeshop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PosterRespository {
    public static ArrayList<Poster> getPosterPage(int page) {
        ArrayList<Poster> list = null;
        try {
            String query = "SELECT\n" +
                    "  *\n" +
                    "FROM\n" +
                    "   Poster\n" +
                    "order by date_create desc \n" +
                    "OFFSET (?-1)*10 ROWS\n" +
                    "    FETCH FIRST 10 ROWS ONLY;\n";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet rs = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                 String id=rs.getString("id");
                 String imgUrl=rs.getString("url_image");
                 String userId=rs.getString("user_id");
                 LocalDateTime dateCreate=rs.getObject("date_create",LocalDateTime.class);
                 char status=rs.getString("status").charAt(0);
                User user=new User();
                user.setId(userId);
                 Poster poster=new Poster( id,  imgUrl,  user,  dateCreate,status);
                 list.add(poster);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int getPosterAmount() {
        int amount = 0;
        try {
            String query = "select  count(1) from Poster";
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

    public static void releasePoster(String id){
        try {
            String query = "UPDATE Poster\n" +
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
    public static void disablePoster(String id){
        try {
            String query = "UPDATE Poster\n" +
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
    public static void addNewPoster(Poster poster){
        try {
            poster.setId(getNewPosterId());
            String query = "insert into Poster(id, url_image, user_id, status, date_create) \n" +
                    "values (?,?,?,?,?)\n";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,poster.getId());
            preparedStatement.setString(2,poster.getImgUrl());
            preparedStatement.setString(3,poster.getUser().getId());
            preparedStatement.setString(4,poster.getStatus()+"");
            preparedStatement.setObject(5,poster.getDateCreate());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String getNewPosterId() {
        String newID = "";
        try {
            String topID = "";
            String query = "SELECT TOP 1 ID FROM Poster\n" +
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
                newID="PT"+topID;
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
    public static void deletePoster(String id){
        try {
            String query = "delete Poster where id=?";
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
       getPosterPage(1).stream().forEach(System.out::println);
    }

}
