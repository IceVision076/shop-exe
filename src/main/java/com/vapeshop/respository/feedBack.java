package com.vapeshop.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class feedBack {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void feedBack(String user_id, String user_description, String status, String title){
            String query = "INSERT INTO [dbo].[ServiceTracking]\n" +
                    "           ([id]\n" +
                    "\t\t\t,[user_id]         \n" +
                    "           ,[user_description]\n" +
                    "           ,[create_date]\n" +
                    "           ,[status] \n" +
                    "           ,[title])\n" +
                    "     VALUES\n" +
                    "           (?,?,?,?,?,?)";
            status = "1";
    }

    public static String serviceTracking(String lastId){
        int idGet = Integer.parseInt(lastId.substring(2)+1);
        String result = "ST";
        for(int i = 1; i<= 8 - (idGet + "").length(); i++){
            result = result + "0";
        }
        result = result + idGet;
        return result;
    }


    private void closeResources(){
        try {
            if(rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (conn != null)
                conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
