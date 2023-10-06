//package com.vapeshop.respository.employee;
//
//import com.vapeshop.config.DBConnect;
//import com.vapeshop.entity.ImageProduct;
//import com.vapeshop.entity.Product;
//import com.vapeshop.entity.ProductType;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//public class ProductRespository {
//    public static ArrayList<Product> getProductPage(int page) {
//        ArrayList<Product> list = null;
//        try {
//            String query = "SELECT\n" +
//                    "  *\n" +
//                    "FROM\n" +
//                    "   Product\n" +
//                    "order by id\n" +
//                    "OFFSET (?-1)*10 ROWS\n" +
//                    "    FETCH FIRST 10 ROWS ONLY;\n";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, page);
//            ResultSet rs = preparedStatement.executeQuery();
//            list = new ArrayList<>();
//            while (rs.next()) {
//                String id = rs.getString(1);
//                String productName = rs.getString(2);
//                String brand = rs.getString(3);
//                String detail = rs.getString(4);
//                String origin = rs.getString(5);
//                char status = (char) rs.getInt(6);
//                String img_url = getFirstProductImage(id);
//
//                Product product = new Product(id, productName, brand, detail, origin, status);
//                product.setImgURL(img_url);
//                list.add(product);
//            }
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public static String getFirstProductImage(String id) {
//        String image_url = "";
//        try {
//            String query = "select top 1 image_url from Product p\n" +
//                    "join ProductType PT on p.Id = PT.product_id\n" +
//                    "join ImageProduct I on PT.Id = I.product_type_id\n" +
//                    "where p.Id=?";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) image_url = rs.getString(1);
//
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return image_url;
//    }
//
//    public static String getFirstProductTypeImage(String id, String productID) {
//        String image_url = "";
//        try {
//            String query = "select top 1 image_url from\n" +
//                    "                  ProductType PT\n" +
//                    "                    join ImageProduct I on PT.Id = I.product_type_id\n" +
//                    "                where PT.Id=? and PT.product_id=?;";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, id);
//            preparedStatement.setString(2, productID);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) image_url = rs.getString(1);
//
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return image_url;
//    }
//
//    public static int getProductAmount() {
//        int amount = 0;
//        try {
//            String query = "select  count(1) from Product";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) amount = rs.getInt(1);
//
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return amount;
//    }
//
//    public static ArrayList<ProductType> getProductTypePage(String productID, int page) {
//        ArrayList<ProductType> list = null;
//        try {
//            String query = "SELECT *\n" +
//                    "FROM ProductType\n" +
//                    "where product_id=?\n" +
//                    "order by id\n" +
//                    "OFFSET (? - 1) * 10 ROWS FETCH FIRST 10 ROWS ONLY";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, productID);
//            preparedStatement.setInt(2, page);
//            ResultSet rs = preparedStatement.executeQuery();
//            list = new ArrayList<>();
//            while (rs.next()) {
//
//                String id = rs.getString(1);
//                String productId = rs.getString(2);
//                String name = rs.getString(3);
//                double price = rs.getDouble(4);
//
//
//                ProductType productType = new ProductType(id, productId, name, price);
//                productType.setImgURL(getFirstProductTypeImage(id, productID));
//                list.add(productType);
//            }
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public static int getProductTypeAmount(String productId) {
//        int amount = 0;
//        try {
//            String query = "select  count(1) from ProductType where product_id=? ";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, productId);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) amount = rs.getInt(1);
//
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return amount;
//    }
//
//    public static Product getProductById(String id) {
//        Product product = null;
//        try {
//            String query = "select * from Product where Id=? ";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) {
//
//                String productName = rs.getString(2);
//                String brand = rs.getString(3);
//                String detail = rs.getString(4);
//                String origin = rs.getString(5);
//                char status = (char) rs.getInt(6);
//                product = new Product(id, productName, brand, detail, origin, status);
//            }
//
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return product;
//    }
//
//    public static void updateProduct(Product product) {
//
//        try {
//            String query = "update Product set\n" +
//                    " product_name=? , brand=? , detail=? , origin=? ,status=? where id=?";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, product.getProductName());
//            preparedStatement.setString(2, product.getBrand());
//            preparedStatement.setString(3, product.getDetail());
//            preparedStatement.setString(4, product.getOrigin());
//            preparedStatement.setString(5, product.getStatus() + "");
//            preparedStatement.setString(6, product.getIdProduct());
//            preparedStatement.executeUpdate();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void updateProductType(ProductType productType) {
//
//        try {
//            String query = "Update ProductType \n" +
//                    "SET  name=?,price=?\n" +
//                    "    where id=?";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, productType.getTypeName());
//            preparedStatement.setDouble(2, productType.getTypePrice());
//            preparedStatement.setString(3, productType.getProductTypeId());
//            preparedStatement.executeUpdate();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String getNewProductId(int typeProduct) {
//        String newID="";
//        try {
//            String topID="";
//            String query = "SELECT TOP 1 ID FROM Product\n" +
//                    "                WHERE Product.Id like ?\n" +
//                    "                ORDER BY ID DESC\n";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            switch (typeProduct){
//                //vape
//                case 1:
//                    preparedStatement.setString(1,"V%");
//                    break;
//                //dầu
//                case 2:
//                    preparedStatement.setString(1,"J%");
//                    break;
//                //phụ kiện
//                case 3:
//                    preparedStatement.setString(1,"A%");
//                    break;
//
//            }
//
//            ResultSet resultSet= preparedStatement.executeQuery();
//            if(resultSet.next()){
//                topID=resultSet.getString(1);
//                topID=topID.substring(2);
//                int maxID=Integer.parseInt(topID)+1;
//                topID="";
//                for(int i=1;i<=8-(maxID+"").length();i++){
//                    topID=topID+0;
//                }
//                topID=topID+maxID;
//                switch (typeProduct){
//                    //vape
//                    case 1:
//                        newID="V"+topID;
//                        break;
//                    //dầu
//                    case 2:
//                        newID="J"+topID;
//                        break;
//                    //phụ kiện
//                    case 3:
//                        newID="A"+topID;
//                        break;
//                }
//
//            }
//
//
//
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return newID;
//    }
//
//    public static void addNewProduct(Product product, ProductType productType, ImageProduct imageProduct){
//        try {
//            String query = "insert into Product(Id, product_name, brand, detail, origin, status)\n" +
//                    "values (?,?,?,?,?,?)\n" +
//                    "insert into ProductType(Id, product_id, name, price)\n" +
//                    "values (?,?,?,?)\n" +
//                    "insert into ImageProduct(product_type_id, id, image_url)\n" +
//                    "values (?,?,?)";
//            Connection connection = DBConnect.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1,product.getIdProduct());
//            preparedStatement.setString(2,product.getProductName());
//            preparedStatement.setString(3,product.getBrand());
//            preparedStatement.setString(4,product.getDetail());
//            preparedStatement.setString(5,product.getOrigin());
//            preparedStatement.setString(6,product.getStatus()+"");
//            preparedStatement.setString(7,productType.getProductTypeId());
//            preparedStatement.setString(8,productType.getProductId());
//            preparedStatement.setString(9,productType.getTypeName());
//            preparedStatement.setDouble(10,productType.getTypePrice());
//            preparedStatement.setString(11,imageProduct.getProductTypeId());
//            preparedStatement.setString(12,imageProduct.getId());
//            preparedStatement.setString(13,imageProduct.getImageUrl());
//            preparedStatement.executeUpdate();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//
//        System.out.println(getNewProductId(3));
//    }
//
//}
