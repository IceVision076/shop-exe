package com.vapeshop.respository.employee;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.Poster;
import com.vapeshop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PosterListRespository {
    public static ArrayList<Poster> getAllPoster() {
        ArrayList<Poster> list = null;
        try {
            String query = "SELECT\n" +
                    "  *\n" +
                    "FROM\n" +
                    "   Poster\n" +
                    "WHERE status = 1\n"+
                    "ORDER BY date_create DESC \n";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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

    public static ArrayList<Poster> getTop3BannerImg() {
        ArrayList<Poster> listTop = null;
        try {
            String query = "SELECT TOP 3\n" +
                    "  *\n" +
                    "FROM\n" +
                    "   Poster\n" +
                    "WHERE status = 1\n"+
                    "ORDER BY id\n";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            listTop = new ArrayList<>();
            while (rs.next()) {
                String id=rs.getString("id");
                String imgUrl=rs.getString("url_image");
                String userId=rs.getString("user_id");
                LocalDateTime dateCreate=rs.getObject("date_create",LocalDateTime.class);
                char status=rs.getString("status").charAt(0);
                User user=new User();
                user.setId(userId);
                Poster poster=new Poster( id,  imgUrl,  user,  dateCreate,status);
                listTop.add(poster);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTop;
    }
    public static void main(String[] args) {
        ArrayList<Poster> pt = PosterListRespository.getTop3BannerImg();

        for (Poster p: pt
        ) {
            System.out.println(p);
        }
    }
}
