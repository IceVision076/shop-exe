package com.vapeshop.respository.employee;

import com.vapeshop.config.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatisticalRespository {
    public static int totalUser() {
        int totalUser = 0;
        try {
            String qwery = "select count(1) from UserInfo where role='0'";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(qwery);
            if (resultSet.next())
                totalUser = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalUser;
    }

    public static int[] productAmountChart() {
        int[] result=new int[3];
        try {
            String query = "select *\n" +
                    "from (select 'Vape' as 'Product', count(1) as 'Amount'\n" +
                    "      from Product\n" +
                    "      where id like 'V%'\n" +
                    "      union\n" +
                    "      select 'Accessory' as 'Product', count(1) as 'Amount'\n" +
                    "      from Product\n" +
                    "      where id like 'A%'\n" +
                    "      union\n" +
                    "      select 'Juice'as 'Product', count(1) as 'Amount'\n" +
                    "      from Product\n" +
                    "      where id like 'J%') x\n" +
                    "order by x.Product";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i=0;
            while (resultSet.next()){
             result[i]=resultSet.getInt(2);
           i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i:productAmountChart()
             ) {
            System.out.println(i);
        }

    }
}
