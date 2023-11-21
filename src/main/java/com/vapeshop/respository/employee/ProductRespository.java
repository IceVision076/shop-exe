package com.vapeshop.respository.employee;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.ImageProduct;
import com.vapeshop.entity.ImportProduct;
import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
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
                //Take first image to show
                String imgUrl = getFirstProductImage(id);
                //create entity
                Product product = new Product(id, productName, brand, detail, origin, status);
                ProductType productType = new ProductType();
                ImageProduct imageProduct = new ImageProduct();

                imageProduct.setImageUrl(imgUrl);
                productType.getImageProducts().add(imageProduct);
                product.getProductTypes().add(productType);
                list.add(product);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String getFirstProductImage(String productID) {
        String image_url = "";
        try {
            String query = "select top 1 image_url from Product p\n" +
                    "join ProductType PT on p.Id = PT.product_id\n" +
                    "join ImageProduct I on PT.Id = I.product_type_id\n" +
                    "where p.Id=?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productID);
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

    public static ArrayList<ImageProduct> getImgProductType(String productTypeId) {
        ArrayList<ImageProduct> list = null;
        try {
            String query = "select * from ImageProduct where product_type_id=?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productTypeId);
            ResultSet rs = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {

                String id = rs.getString(2);
                String imgUrl = rs.getString(3);

                ImageProduct imageProduct = new ImageProduct(productTypeId, id, imgUrl);
                list.add(imageProduct);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
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
                remainingAmountUpdate(productType);
                productType.setImageProducts(getImgProductType(id));
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
                    " product_name=? , brand=? , detail=? , origin=? ,status=? where id=?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getBrand());
            preparedStatement.setString(3, product.getDetail());
            preparedStatement.setString(4, product.getOrigin());
            preparedStatement.setString(5, product.getStatus() + "");
            preparedStatement.setString(6, product.getIdProduct());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateProductType(ProductType productType) {

        try {
            String query = "Update ProductType \n" +
                    "SET  name=?,price=?\n" +
                    "    where id=?";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productType.getTypeName());
            preparedStatement.setDouble(2, productType.getTypePrice());
            preparedStatement.setString(3, productType.getProductTypeId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNewProductId(int typeProduct) {
        String newID = "";
        try {
            String topID = "";
            String query = "SELECT TOP 1 ID FROM Product\n" +
                    "                WHERE Product.Id like ?\n" +
                    "                ORDER BY ID DESC\n";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            switch (typeProduct) {
                //vape
                case 1:
                    preparedStatement.setString(1, "V%");
                    break;
                //dầu
                case 2:
                    preparedStatement.setString(1, "J%");
                    break;
                //phụ kiện
                case 3:
                    preparedStatement.setString(1, "A%");
                    break;

            }

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                topID = resultSet.getString(1);
                topID = topID.substring(2);
                int maxID = Integer.parseInt(topID) + 1;
                topID = "";
                for (int i = 1; i <= 8 - (maxID + "").length(); i++) {
                    topID = topID + 0;
                }
                topID = topID + maxID;
                switch (typeProduct) {
                    //vape
                    case 1:
                        newID = "V" + topID;
                        break;
                    //dầu
                    case 2:
                        newID = "J" + topID;
                        break;
                    //phụ kiện
                    case 3:
                        newID = "A" + topID;
                        break;
                }

            }


            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newID;
    }

    public static void addNewProduct(Product product, ProductType productType, ImageProduct imageProduct) {
        try {
            String query = "insert into Product(Id, product_name, brand, detail, origin, status)\n" +
                    "values (?,?,?,?,?,?)\n" +
                    "insert into ProductType(Id, product_id, name, price,status)\n" +
                    "values (?,?,?,?,?)\n" +
                    "insert into ImageProduct(product_type_id, id, image_url)\n" +
                    "values (?,?,?)";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getIdProduct());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getBrand());
            preparedStatement.setString(4, product.getDetail());
            preparedStatement.setString(5, product.getOrigin());
            preparedStatement.setString(6, product.getStatus() + "");
            preparedStatement.setString(7, productType.getProductTypeId());
            preparedStatement.setString(8, productType.getProductId());
            preparedStatement.setString(9, productType.getTypeName());
            preparedStatement.setDouble(10, productType.getTypePrice());
            preparedStatement.setString(11, "1");
            preparedStatement.setString(12, imageProduct.getProductTypeId());
            preparedStatement.setString(13, getNewImgId());
            preparedStatement.setString(14, imageProduct.getImageUrl());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNewProductTypeId(String productId) {
        String newProductTypeId = "";
        try {
            String query = "select Top 1 *\n" +
                    "from ProductType\n" +
                    "where product_id = ?\n" +
                    "order by id desc";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String maxIdRecent = resultSet.getString(1);
                char postfix = maxIdRecent.charAt(9);
                newProductTypeId = productId + (char) (postfix + 1);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newProductTypeId;
    }

    public static void addNewProductType(ProductType productType) {

        try {
            String query = "INSERT INTO ProductType (Id, product_id, name, price,status) values (?,?,?,?,?)\n" +
                    "insert into ImageProduct (product_type_id, id, image_url) values (?,?,?) ";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productType.getProductTypeId());
            preparedStatement.setString(2, productType.getProductId());
            preparedStatement.setString(3, productType.getTypeName());
            preparedStatement.setDouble(4, productType.getTypePrice());
            preparedStatement.setString(5, "1");
            preparedStatement.setString(6, productType.getProductTypeId());
            preparedStatement.setString(7, getNewImgId());
            preparedStatement.setString(8, productType.getImageProducts().get(0).getImageUrl());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNewImgId() {
        String newImgId = "";
        try {
            String query = "select top 1 * from ImageProduct order by id desc ";
            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                int maxIdRecent = Integer.parseInt(rs.getString(2).substring(3));
                for (int i = 1; i <= 7 - (maxIdRecent + "").length(); i++) {
                    newImgId = newImgId + "0";
                }
                newImgId = newImgId + (maxIdRecent + 1);

            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "IMG" + newImgId;
    }//IMG0000104

    public static boolean checkExitsLotId(String lotId) {
        boolean check = false;
        try {
            String query = "select * from ImportProduct where lot_id=? ";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, lotId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check = true;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public static void addNewLot(ImportProduct importProduct) {
        try {
            String query = "insert into ImportProduct(lot_id, lot_name, product_type_id, quantity, date_time)\n" +
                    "values (?,?,?,?,?) ";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, importProduct.getLotId());
            preparedStatement.setString(2, importProduct.getLotName());
            preparedStatement.setString(3, importProduct.getProductTypeId());
            preparedStatement.setInt(4, importProduct.getQuantity());
            preparedStatement.setObject(5, importProduct.getDateTime());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getProductTypeRealAmount(String productTypeId) {
        int amount = 0;
        try {
            String query = "select sum (quantity) from ImportProduct \n" +
                    "where product_type_id = ? ";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productTypeId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) amount = rs.getInt(1);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    public static ArrayList<ImportProduct> getImportList(String productTypeId, int page) {
        ArrayList<ImportProduct> list = null;
        try {
            String query = "select *\n" +
                    "from ImportProduct\n" +
                    "where product_type_id = ?\n" +
                    "order by date_time desc \n" +
                    " OFFSET (?-1)*10 ROWS\n" +
                    "FETCH FIRST 10 ROWS ONLY";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productTypeId);
            preparedStatement.setInt(2,page);
            ResultSet rs = preparedStatement.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                String lotId = rs.getString("lot_id");
                String lotName = rs.getString("lot_name");

                int quantity = rs.getInt("quantity");
                LocalDateTime dateTime = rs.getObject("date_time", LocalDateTime.class);
                ImportProduct importProduct = new ImportProduct(lotId, lotName, productTypeId, quantity, dateTime);
                list.add(importProduct);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public static int getImportProductTypeAmount(String productTypeId) {
        int amount = 0;
        try {
            String query = "select count(1)\n" +
                    "from ImportProduct\n" +
                    "where product_type_id=? ";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productTypeId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) amount = rs.getInt(1);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    public static void  remainingAmountUpdate(ProductType productType){

        try {
            String query ="    select dbo.remainingAmount(?) as remaining_amount";
        Connection connection=DBConnect.getConnection();
        PreparedStatement  preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,productType.getProductTypeId());
        ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
              int remainingAmount=  resultSet.getInt("remaining_amount");
              productType.setRealAmount(remainingAmount);
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void  updateContinueSellProductType(String productTypeId){

        try {
            String query ="UPDATE ProductType set status='1' where Id=?";
            Connection connection=DBConnect.getConnection();
            PreparedStatement  preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,productTypeId);
            preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void  updateStopSellProductType(String productTypeId){

        try {
            String query ="UPDATE ProductType set status='0' where Id=?";
            Connection connection=DBConnect.getConnection();
            PreparedStatement  preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,productTypeId);
            preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        getImportList("A00000001A",1).stream().forEach(System.out::println);
    }
}
