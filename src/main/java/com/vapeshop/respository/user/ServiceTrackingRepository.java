package com.vapeshop.respository.user;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.ServiceTracking;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ServiceTrackingRepository {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");

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
    public static ArrayList<ServiceTracking> getServiceTrackingHistory(int index) {
        ArrayList<ServiceTracking> serviceTrackingArrayList = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [id]\n"
                    + "      ,[employee_id]\n"
                    + "      ,[user_id]\n"
                    + "      ,[user_description]\n"
                    + "      ,[employee_description]\n"
                    + "      ,[create_date]\n"
                    + "      ,[estimated_delivery_date]\n"
                    + "      ,[delivery_date]\n"
                    + "      ,[status]\n"
                    + "      ,[price]\n"
                    + "      ,[title]\n"
                    + "  FROM [dbo].[ServiceTracking]\n"
                    + "  ORDER BY [create_date] DESC\n"
                    + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY\n"
            );
            stmt.setInt(1,(index - 1) * 10);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String employeeId = rs.getString(2);
                String userId = rs.getString(3);
                String userDescription = rs.getString(4);
                String employeeDescription = rs.getString(5);
                LocalDateTime createDate = rs.getObject(6,LocalDateTime.class);
                LocalDateTime estimatedDeliveryDate = rs.getObject(7,LocalDateTime.class);
                LocalDateTime deliveryDate = rs.getObject(8,LocalDateTime.class);
                char status = rs.getString(9).charAt(0);
                double price = rs.getDouble(10);
                String title = rs.getString(11);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, employeeId, userDescription,
                       employeeDescription, createDate, estimatedDeliveryDate, deliveryDate, status, price, title);
                serviceTrackingArrayList.add(serviceTracking);
            }
            con.close();
            return serviceTrackingArrayList;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ServiceTracking getServiceTrackingById(String serviceTrackingId) {
        ServiceTracking serviceTrackingDetail = new ServiceTracking();
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT [id]\n"
                    + "      ,[employee_id]\n"
                    + "      ,[user_id]\n"
                    + "      ,[user_description]\n"
                    + "      ,[employee_description]\n"
                    + "      ,[create_date]\n"
                    + "      ,[estimated_delivery_date]\n"
                    + "      ,[delivery_date]\n"
                    + "      ,[status]\n"
                    + "      ,[price]\n"
                    + "      ,[title]\n"
                    + "  FROM [dbo].[ServiceTracking]\n"
                    + "  WHERE [id] = ?\n"
            );
            stmt.setString(1,serviceTrackingId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String employeeId = rs.getString(2);
                String userId = rs.getString(3);
                String userDescription = rs.getString(4);
                String employeeDescription = rs.getString(5);
                LocalDateTime createDate = rs.getObject(6,LocalDateTime.class);
                LocalDateTime estimatedDeliveryDate = rs.getObject(7,LocalDateTime.class);
                LocalDateTime deliveryDate = rs.getObject(8,LocalDateTime.class);
                char status = rs.getString(9).charAt(0);
                double price = rs.getDouble(10);
                String title = rs.getString(11);

                serviceTrackingDetail.setId(id);
                serviceTrackingDetail.setEmployeeId(employeeId);
                serviceTrackingDetail.setUserId(userId);
                serviceTrackingDetail.setUserDescription(userDescription);
                serviceTrackingDetail.setEmployeeDescription(employeeDescription);
                serviceTrackingDetail.setCreateDate(createDate);
                serviceTrackingDetail.setEstimatedDeliveryDate(estimatedDeliveryDate);
                serviceTrackingDetail.setDeliveryDate(deliveryDate);
                serviceTrackingDetail.setStatus(status);
                serviceTrackingDetail.setPrice(price);
                serviceTrackingDetail.setTitle(title);
            }
            con.close();
            return serviceTrackingDetail;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static int getTotalServiceTracking() {
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) from [dbo].[ServiceTracking]"
            );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
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
        System.out.println(ServiceTrackingRepository.getServiceTrackingById("ST00000001"));
    }
}
