package com.vapeshop.respository;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRespository {
    public static ArrayList<Product> getProductPage(int page) {
        ArrayList<Product> list = null;
        try {
            String query = "SELECT\n" +
                    "  *\n" +
                    "FROM\n" +
                    "   Product\n" +
                    "order by id\n" +
                    "OFFSET (?-1)*10 ROWS\n" +
                    "    FETCH FIRST 10 ROWS ONLY;\n";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, page);
            ResultSet rs = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString(1);
                String productName = rs.getString(2);
                String brand = rs.getString(3);
                String detail = rs.getString(4);
                String origin = rs.getString(5);
                char status = (char) rs.getInt(6);
                String img_url = getFirstProductImage(id);

                Product product = new Product(id, productName, brand, detail, origin, status);
                product.setImage_url(img_url);
                list.add(product);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String getFirstProductImage(String id) {
        String image_url = "";
        try {
            String query = "select top 1 image_url from Product p\n" +
                    "join ProductType PT on p.Id = PT.product_id\n" +
                    "join ImageProduct I on PT.Id = I.product_type_id\n" +
                    "where p.Id=?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) image_url = rs.getString(1);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image_url;
    }

    public static String getFirstProductTypeImage(String id, String productID) {
        String image_url = "";
        try {
            String query = "select top 1 image_url from\n" +
                    "                  ProductType PT\n" +
                    "                    join ImageProduct I on PT.Id = I.product_type_id\n" +
                    "                where PT.Id=? and PT.product_id=?;";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, productID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) image_url = rs.getString(1);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image_url;
    }

    public static int getProductAmount() {
        int amount = 0;
        try {
            String query = "select  count(1) from Product";
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

    public static ArrayList<ProductType> getProductTypePage(String productID, int page) {
        ArrayList<ProductType> list = null;
        try {
            String query = "SELECT *\n" +
                    "FROM ProductType\n" +
                    "where product_id=?\n" +
                    "order by id\n" +
                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productID);
            preparedStatement.setInt(2, page);
            ResultSet rs = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {

                String id = rs.getString(1);
                String productId = rs.getString(2);
                String name = rs.getString(3);
                double price = rs.getDouble(4);


                ProductType productType = new ProductType(id, productId, name, price);
                productType.setImage_url(getFirstProductTypeImage(id, productID));
                list.add(productType);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int getProductTypeAmount(String productId) {
        int amount = 0;
        try {
            String query = "select  count(1) from ProductType where product_id=? ";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) amount = rs.getInt(1);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    public static Product getProductById(String id) {
        Product product = null;
        try {
            String query = "select * from Product where Id=? ";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {

                String productName = rs.getString(2);
                String brand = rs.getString(3);
                String detail = rs.getString(4);
                String origin = rs.getString(5);
                char status = (char) rs.getInt(6);
                product = new Product(id, productName, brand, detail, origin, status);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    public static void updateProduct(Product product) {

        try {
            String query = "update Product set\n" +
                    " product_name=? , brand=? , detail=? , origin=? ,status=? where id=?"
                   ;
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getBrand());
            preparedStatement.setString(3, product.getDetail());
            preparedStatement.setString(4, product.getOrigin());
            preparedStatement.setString(5,product.getStatus()+"");
            preparedStatement.setString(6, product.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        getProductTypePage("V00000010", 1).stream().forEach(System.out::println);
        System.out.println(getProductTypeAmount("V00000010"));
    }

}
