package com.vapeshop.respository;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.ServiceTracking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ServiceTrackingRepository {
    public static void serviceTrackingSender(ServiceTracking serviceTracking){
        try {
            String query = "insert into ServiceTracking(id, user_id, user_description, create_date, status, title) " +
                    "values(?,?,?,?,?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, serviceTracking.getId());
            preparedStatement.setString(2,serviceTracking.getUserId());
            preparedStatement.setString(3,serviceTracking.getUserDescription());
            preparedStatement.setDate(4, Date.valueOf(serviceTracking.getCreateDate()));
            preparedStatement.setString(5,serviceTracking.getStatus() + "");
            preparedStatement.setString(6,serviceTracking.getTitle());
            preparedStatement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
