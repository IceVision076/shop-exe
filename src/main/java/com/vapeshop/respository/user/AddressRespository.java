package com.vapeshop.respository.user;

import com.vapeshop.config.DBAddressConnect;
import com.vapeshop.entity.address.District;
import com.vapeshop.entity.address.Province;
import com.vapeshop.entity.address.Ward;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressRespository {
    public static List<Province> getAllProvinces() {
        List<Province> provinceList = null;
        try {
            String query = "select * from Province";
            Connection connection = DBAddressConnect.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            provinceList = new ArrayList<>();
            while (resultSet.next()) {
                String provinceID = resultSet.getString("code");
                String provinceName = resultSet.getString("province_name_en");
                Province province = new Province(provinceID, provinceName);
                provinceList.add(province);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return provinceList;
    }
    public static List<District> getDistrictByProvinceId(String provinceId) {
        List<District> districts = null;
        try {
            String query = "select d.*\n" +
                    "from province\n" +
                    "         join district d on province.code = d.province_code\n" +
                    "where province.code = ?";
            Connection connection = DBAddressConnect.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, provinceId);
            ResultSet resultSet = statement.executeQuery();
            districts = new ArrayList<>();
            while (resultSet.next()) {
                String districtId = resultSet.getString("code");
                String districtName = resultSet.getString("full_name_en");
                District district = new District(districtId, districtName);
                districts.add(district);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return districts;
    }
    public static List<Ward> getWardByDistrictId(String districtId) {
        List<Ward>  wardList = null;
        try {
            String query = "select ward.* from ward\n" +
                    "join district d on d.code = ward.district_code\n" +
                    "where d.code = ?";
            Connection connection = DBAddressConnect.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, districtId);
            ResultSet resultSet = statement.executeQuery();
            wardList = new ArrayList<>();
            while (resultSet.next()) {
                String wardId = resultSet.getString("code");
                String wardName = resultSet.getString("ward_name_vn");
                Ward ward=new Ward(wardId,wardName);
                wardList.add(ward);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return wardList;
    }
    public static void main(String[] args){
        getDistrictByProvinceId("48").stream().forEach(System.out::println);
      //  getWardByDistrictId("495").stream().forEach(System.out::println);
    }
}
