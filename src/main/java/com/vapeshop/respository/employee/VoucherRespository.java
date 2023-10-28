package com.vapeshop.respository.employee;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.Voucher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VoucherRespository {
    public static ArrayList<Voucher> getProductPage(int page) {
        ArrayList<Voucher> list = null;
        try {
            String query = "SELECT *\n" +
                    "FROM Voucher\n" +
                    "order by create_date desc\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet rs = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("id");
                String voucherName = rs.getString("vourcher_name");
                double voucherPercent = rs.getDouble("vourcher_percent");
                LocalDateTime createDate = rs.getObject("create_date", LocalDateTime.class);
                LocalDateTime closeDate = rs.getObject("close_date", LocalDateTime.class);
                char status = rs.getString("status").charAt(0);
                Voucher voucher = new Voucher(id, voucherName, voucherPercent, createDate, closeDate, status);
                list.add(voucher);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static int getVoucherAmount() {
        int amount = 0;
        try {
            String query = "select  count(1) from Voucher";
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

    public static void addVoucher(Voucher voucher) {
        try {
            String query = "INSERT INTO Voucher(id,vourcher_name,vourcher_percent,create_date,close_date,status)\n" +
                    "VALUES (?,?,?,?,?,?)";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, voucher.getId());
            preparedStatement.setString(2, voucher.getVoucherName());
            preparedStatement.setDouble(3, voucher.getVoucherPercent());
            preparedStatement.setObject(4, voucher.getCreateDate());
            preparedStatement.setObject(5, voucher.getCloseDate());
            preparedStatement.setString(6, voucher.getStatus() + "");
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openVoucher(String id) {
        try {
            String query = "update Voucher set status='1'\n" +
                    "where id=?\n";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void closeVoucher(String id) {
        try {
            String query = "update Voucher set status='0'\n" +
                    "where id=?\n";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        getProductPage(1).stream().forEach(System.out::println);
        System.out.println(getVoucherAmount());
    }
}
