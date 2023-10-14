package com.vapeshop.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static String dbName = "VapeShopDB";
    public static String portNumber = "1433";
    public static String userID = "sa";
    public static String password = "123456789";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=" + dbName + ";encrypt=false";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        System.out.println("Kết nối database");
        return DriverManager.getConnection(url, userID, password);
    }



    //    Test connection
    public static void main(String[] args) {
        try {
            if (DBConnect.getConnection() != null) {
                System.out.println("Connect successfully!");
            } else {
                System.out.println("Connect failed!");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Error at model.DBContext.DBContext().getConnertion()");
        }
    }
}