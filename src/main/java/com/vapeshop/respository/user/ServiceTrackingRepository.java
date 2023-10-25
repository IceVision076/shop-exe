package com.vapeshop.respository.user;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.ServiceTracking;

import java.sql.*;

public class ServiceTrackingRepository {
    public static void serviceTrackingSender(ServiceTracking serviceTracking) {
        try {
            String query = "insert into ServiceTracking(id, user_id, user_description, create_date, status, title) " +
                    "values(?,?,?,?,?,?)";
            Connection conn = DBConnect.getConnection();
            serviceTracking.setId(newServiceTrackingId());
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, serviceTracking.getId());
            preparedStatement.setString(2, serviceTracking.getUserId());
            preparedStatement.setString(3, serviceTracking.getUserDescription());
            preparedStatement.setObject(4, serviceTracking.getCreateDate());
            preparedStatement.setString(5, serviceTracking.getStatus() + "");
            preparedStatement.setString(6, serviceTracking.getTitle());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String newServiceTrackingId() {

        String id = "ST";

        //ST00000121
        try {
            String query = "select top 1 id from ServiceTracking\n" +
                    "order by id desc";
            Connection conn = DBConnect.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int maxId = Integer.parseInt(resultSet.getString(1).substring(2));

                for (int i=1;i<=8-(maxId+1+"").length();i++)
                id=id+"0";
                id=id+(maxId+1);
            } else {
                id = "ST00000001";
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static void main(String[] args) {
        System.out.println(newServiceTrackingId());
//        ST00000001
//        ST
        //ST000000010
    }
}
