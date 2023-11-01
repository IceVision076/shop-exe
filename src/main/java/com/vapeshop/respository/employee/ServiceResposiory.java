package com.vapeshop.respository.employee;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.ServiceTracking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ServiceResposiory {


    public static ArrayList<ServiceTracking> serviceTrackingPage(int page) {
        ArrayList<ServiceTracking> list = null;
        try {
            String query = "select id,user_id, user_description,create_date,status,title\n" +
                    "from ServiceTracking\n" +
                    "where status = '1'\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String userId = resultSet.getString(2);
                String userDescription = resultSet.getString(3);
                LocalDateTime createDate = resultSet.getObject(4, LocalDateTime.class);
                char status = resultSet.getString(5).charAt(0);
                String title = resultSet.getString(6);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                list.add(serviceTracking);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static ArrayList<ServiceTracking> serviceAccepetedPage(int page) {
        ArrayList<ServiceTracking> list = null;
        try {
            String query = "select id,user_id, user_description,create_date,status,title\n" +
                    "from ServiceTracking\n" +
                    "where status = '2'\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String userId = resultSet.getString(2);
                String userDescription = resultSet.getString(3);
                LocalDateTime createDate = resultSet.getObject(4, LocalDateTime.class);
                char status = resultSet.getString(5).charAt(0);
                String title = resultSet.getString(6);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                list.add(serviceTracking);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static ArrayList<ServiceTracking> serviceCanceledPage(int page) {
        ArrayList<ServiceTracking> list = null;
        try {
            String query = "select id,user_id, user_description,create_date,status,title\n" +
                    "from ServiceTracking\n" +
                    "where status = '0'\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String userId = resultSet.getString(2);
                String userDescription = resultSet.getString(3);
                LocalDateTime createDate = resultSet.getObject(4, LocalDateTime.class);
                char status = resultSet.getString(5).charAt(0);
                String title = resultSet.getString(6);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                list.add(serviceTracking);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static ArrayList<ServiceTracking> serviceSuccessPage(int page) {
        ArrayList<ServiceTracking> list = null;
        try {
            String query = "select id,user_id, user_description,create_date,status,title\n" +
                    "from ServiceTracking\n" +
                    "where status = '4'\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String userId = resultSet.getString(2);
                String userDescription = resultSet.getString(3);
                LocalDateTime createDate = resultSet.getObject(4, LocalDateTime.class);
                char status = resultSet.getString(5).charAt(0);
                String title = resultSet.getString(6);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                list.add(serviceTracking);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static ArrayList<ServiceTracking> serviceFailPage(int page) {
        ArrayList<ServiceTracking> list = null;
        try {
            String query = "select id,user_id, user_description,create_date,status,title\n" +
                    "from ServiceTracking\n" +
                    "where status = '3'\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String userId = resultSet.getString(2);
                String userDescription = resultSet.getString(3);
                LocalDateTime createDate = resultSet.getObject(4, LocalDateTime.class);
                char status = resultSet.getString(5).charAt(0);
                String title = resultSet.getString(6);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                list.add(serviceTracking);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int serviceAcceptAmount() {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ServiceTracking\n" +
                    "where status = '1'";

            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) amount = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }
    public static int serviceCanceledAmount() {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ServiceTracking\n" +
                    "where status = '0'";

            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) amount = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }
    public static int serviceAcceptedAmount() {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ServiceTracking\n" +
                    "where status = '2'";

            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) amount = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int serviceFailAmount() {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ServiceTracking\n" +
                    "where status = '3'";

            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) amount = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }
    public static int serviceSuccessAmount() {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ServiceTracking\n" +
                    "where status = '4'";

            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) amount = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static void serviceReceive(String id, String employeeId, String employeeDescription,char status) {
        try {
            String query = "UPDATE ServiceTracking\n" +
                    "SET employee_id=?,\n" +
                    "    employee_description=?,\n" +
                    "    status=?\n" +
                    "where id = ?";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, employeeDescription);
            preparedStatement.setString(3, status+"");
            preparedStatement.setString(4,id);
            preparedStatement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void updateSuccess(ServiceTracking serviceTracking) {
        try {
            String query = "select * from ServiceTracking\n" +
                    "update ServiceTracking\n" +
                    "set employee_description=?,\n" +
                    "    delivery_date=?,\n" +
                    "    price=price+?,\n" +
                    "    status=?\n" +
                    "where id=?";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,serviceTracking.getEmployeeDescription());
            preparedStatement.setObject(2,serviceTracking.getDeliveryDate());
            preparedStatement.setDouble(3,serviceTracking.getPrice());
            preparedStatement.setString(4,serviceTracking.getStatus()+"");
            preparedStatement.setString(5,serviceTracking.getId());
            preparedStatement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void updateFail(ServiceTracking serviceTracking) {
        try {
            String query = "select * from ServiceTracking\n" +
                    "update ServiceTracking\n" +
                    "set employee_description=?,\n" +
                    "    delivery_date=?,\n" +
                    "    status=?\n" +
                    "where id=?";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,serviceTracking.getEmployeeDescription());
            preparedStatement.setObject(2,serviceTracking.getDeliveryDate());
            preparedStatement.setString(3,serviceTracking.getStatus()+"");
            preparedStatement.setString(4,serviceTracking.getId());
            preparedStatement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
      serviceFailPage(1).stream().forEach(System.out::println);
    }
}
