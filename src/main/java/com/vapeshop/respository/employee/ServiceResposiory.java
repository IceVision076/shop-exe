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
            String query = "      select id,user_id, user_description,create_date,status,title,employee_description,price,estimated_delivery_date\n" +
                    "                    from ServiceTracking\n" +
                    "                    where status = '2'\n" +
                    "                    order by create_date asc\n" +
                    "                    OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

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
                String employeeDescription = resultSet.getString(7);
                double price = resultSet.getDouble(8);
                LocalDateTime estimatedDeliveryDate = resultSet.getObject("estimated_delivery_date", LocalDateTime.class);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                serviceTracking.setPrice(price);
                serviceTracking.setEstimatedDeliveryDate(estimatedDeliveryDate);
                serviceTracking.setEmployeeDescription(employeeDescription);
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
            String query = "select id,user_id, user_description,create_date,status,title,employee_description,delivery_date\n" +
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
                String employeeDescription = resultSet.getString(7);
                LocalDateTime deliveryDate = resultSet.getObject(8, LocalDateTime.class);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                serviceTracking.setEmployeeDescription(employeeDescription);
                serviceTracking.setDeliveryDate(deliveryDate);
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
            String query = "select id,user_id, user_description,create_date,status,title,delivery_date\n" +
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
                LocalDateTime deliveryDate = resultSet.getObject("delivery_date", LocalDateTime.class);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                serviceTracking.setDeliveryDate(deliveryDate);
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
            String query = "select id,user_id, user_description,create_date,status,title,delivery_date\n" +
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
                LocalDateTime deliveryDate = resultSet.getObject("delivery_date", LocalDateTime.class);
                serviceTracking.setDeliveryDate(deliveryDate);
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

    public static void serviceReceive(String id, String employeeId, String employeeDescription, char status, double price) {
        try {
            String query = "UPDATE ServiceTracking\n" +
                    "SET employee_id=?,\n" +
                    "    employee_description=?,\n" +
                    "    price=?,\n" +
                    "    estimated_delivery_date=?,\n" +
                    "    status=?\n" +
                    "where id = ?";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, employeeDescription);
            preparedStatement.setDouble(3, price);
            preparedStatement.setObject(4, LocalDateTime.now().plusDays(7));
            preparedStatement.setString(5, status + "");
            preparedStatement.setString(6, id);
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
            preparedStatement.setString(1, serviceTracking.getEmployeeDescription());
            preparedStatement.setObject(2, serviceTracking.getDeliveryDate());
            preparedStatement.setDouble(3, serviceTracking.getPrice());
            preparedStatement.setString(4, serviceTracking.getStatus() + "");
            preparedStatement.setString(5, serviceTracking.getId());
            preparedStatement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updateFail(ServiceTracking serviceTracking) {
        try {
            String query = "update ServiceTracking\n" +
                    "set employee_description=?,\n" +
                    "    delivery_date=?,\n" +
                    "    status=?\n" +
                    "where id=?";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, serviceTracking.getEmployeeDescription());
            preparedStatement.setObject(2, LocalDateTime.now());
            preparedStatement.setString(3, serviceTracking.getStatus() + "");
            preparedStatement.setString(4, serviceTracking.getId());
            preparedStatement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int getAmountWaiting() {
        int amount = 0;
        try {
            String query = "select count(1) from ServiceTracking\n" +
                    "where status ='1'";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) amount = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int getAmountWaitingSearch(String serviceIdSearch) {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ServiceTracking\n" +
                    "where status = '1'\n" +
                    "  and id like ?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + serviceIdSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) amount = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int getAmountCancel() {
        int amount = 0;
        try {
            String query = "select count(1) from ServiceTracking\n" +
                    "where status ='0'";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) amount = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int getAmountCancelSearch(String serviceIdSearch) {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ServiceTracking\n" +
                    "where status = '0'\n" +
                    "  and id like ?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + serviceIdSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) amount = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int getAmountAccept() {
        int amount = 0;
        try {
            String query = "select count(1) from ServiceTracking\n" +
                    "where status ='2'";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) amount = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int getAmountAcceptedSearch(String serviceIdSearch) {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ServiceTracking\n" +
                    "where status = '2'\n" +
                    "  and id like ?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + serviceIdSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) amount = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int getAmountFail() {
        int amount = 0;
        try {
            String query = "select count(1) from ServiceTracking\n" +
                    "where status ='3'";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) amount = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int getAmountFailSearch(String serviceIdSearch) {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ServiceTracking\n" +
                    "where status = '3'\n" +
                    "  and id like ?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + serviceIdSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) amount = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int getAmountSuccess() {
        int amount = 0;
        try {
            String query = "select count(1) from ServiceTracking\n" +
                    "where status ='4'";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) amount = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int getAmountSuccessSearch(String serviceIdSearch) {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ServiceTracking\n" +
                    "where status = '4'\n" +
                    "  and id like ?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + serviceIdSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) amount = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static ArrayList<ServiceTracking> serviceTrackingSearch(String serviceIdSearch, int page) {
        ArrayList<ServiceTracking> list = null;
        try {
            String query = "select id,user_id, user_description,create_date,status,title\n" +
                    "                    from ServiceTracking\n" +
                    "                    where status = '1'\n" +
                    "                    and id like ?\n" +
                    "                    order by create_date asc\n" +
                    "                    OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + serviceIdSearch + "%");
            preparedStatement.setInt(2, page);
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

    public static ArrayList<ServiceTracking> serviceAccepetedSearch(String serviceIdSearch, int page) {
        ArrayList<ServiceTracking> list = null;
        try {
            String query = "      select id,user_id, user_description,create_date,status,title,employee_description,price,estimated_delivery_date\n" +
                    "                    from ServiceTracking\n" +
                    "                    where status = '2'\n" +
                    "                    and id like ?\n" +
                    "                    order by create_date asc\n" +
                    "                    OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + serviceIdSearch + "%");
            preparedStatement.setInt(2, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String userId = resultSet.getString(2);
                String userDescription = resultSet.getString(3);
                LocalDateTime createDate = resultSet.getObject(4, LocalDateTime.class);
                char status = resultSet.getString(5).charAt(0);
                String title = resultSet.getString(6);
                String employeeDescription = resultSet.getString(7);
                double price = resultSet.getDouble(8);
                LocalDateTime estimatedDeliveryDate = resultSet.getObject("estimated_delivery_date", LocalDateTime.class);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                serviceTracking.setPrice(price);
                serviceTracking.setEstimatedDeliveryDate(estimatedDeliveryDate);
                serviceTracking.setEmployeeDescription(employeeDescription);
                list.add(serviceTracking);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static ArrayList<ServiceTracking> serviceSuccessSearch(String serviceIdSearch, int page) {
        ArrayList<ServiceTracking> list = null;
        try {
            String query = "select id,user_id, user_description,create_date,status,title,delivery_date\n" +
                    "from ServiceTracking\n" +
                    "where status = '4'\n" +
                    "                    and id like ?\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + serviceIdSearch + "%");
            preparedStatement.setInt(2, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String userId = resultSet.getString(2);
                String userDescription = resultSet.getString(3);
                LocalDateTime createDate = resultSet.getObject(4, LocalDateTime.class);
                char status = resultSet.getString(5).charAt(0);
                String title = resultSet.getString(6);
                LocalDateTime deliveryDate = resultSet.getObject("delivery_date", LocalDateTime.class);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                serviceTracking.setDeliveryDate(deliveryDate);
                list.add(serviceTracking);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<ServiceTracking> serviceFailSearch(String serviceIdSearch, int page) {
        ArrayList<ServiceTracking> list = null;
        try {
            String query = "select id,user_id, user_description,create_date,status,title,delivery_date\n" +
                    "from ServiceTracking\n" +
                    "where status = '3'\n" +
                    "                    and id like ?\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+serviceIdSearch+"%");
            preparedStatement.setInt(2, page);
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
                LocalDateTime deliveryDate = resultSet.getObject("delivery_date", LocalDateTime.class);
                serviceTracking.setDeliveryDate(deliveryDate);
                list.add(serviceTracking);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<ServiceTracking> serviceCanceledSearch(String serviceIdSearch, int page) {
        ArrayList<ServiceTracking> list = null;
        try {
            String query = "select id,user_id, user_description,create_date,status,title,employee_description,delivery_date\n" +
                    "from ServiceTracking\n" +
                    "where status = '0'\n" +
                    " and id like ?\n" +
                    "order by create_date asc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";

            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+serviceIdSearch+"%");
            preparedStatement.setInt(2, page);
            ResultSet resultSet = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String userId = resultSet.getString(2);
                String userDescription = resultSet.getString(3);
                LocalDateTime createDate = resultSet.getObject(4, LocalDateTime.class);
                char status = resultSet.getString(5).charAt(0);
                String title = resultSet.getString(6);
                String employeeDescription = resultSet.getString(7);
                LocalDateTime deliveryDate = resultSet.getObject(8, LocalDateTime.class);
                ServiceTracking serviceTracking = new ServiceTracking(id, userId, userDescription, createDate, status, title);
                serviceTracking.setEmployeeDescription(employeeDescription);
                serviceTracking.setDeliveryDate(deliveryDate);
                list.add(serviceTracking);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void main(String[] args) {


    }
}
