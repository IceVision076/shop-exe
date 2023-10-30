package com.vapeshop.respository.user;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.ImageProduct;
import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {
    //Get all Product from Product,productType,ImageProduct table
    public static ArrayList<ProductType> getAllProduct() {
        ArrayList<ProductType> products = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT pd.[id]\n"
                    + "      ,pdt.[Id]\n"
                    + "      ,pd.[product_name]\n"
                    + "      ,pdt.[name]\n"
                    + "      ,pdt.[price]\n"
                    + "      ,pd.[brand]\n"
                    + "      ,pd.[detail]\n"
                    + "      ,pd.[origin]\n"
                    + "      ,pd.[status]\n"
                    + "  FROM [dbo].[Product] pd\n"
                    + "INNER JOIN [ProductType] pdt on pdt.[product_id] = pd.[id]"
                    );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idProduct = rs.getString(1);
                String idProductType = rs.getString(2);
                String productName = rs.getString(3);
                String typeName = rs.getString(4);
                double price = rs.getDouble(5);
                String brand = rs.getString(6);
                String detail = rs.getString(7);
                String origin = rs.getString(8);
                char status = rs.getString(9).charAt(0);
                Product product = new Product(idProduct,productName,brand,detail,origin,status);
                ProductType productType = new ProductType(idProductType,idProduct,typeName,price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                products.add(productType);
            }
            con.close();
            return products;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }



    //Calculate total of Product
    public static int getTotalProduct(){
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) from [dbo].[ProductType]"
            );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static ArrayList<ImageProduct> getImageProduct (String productTypeID) {
        ArrayList<ImageProduct> imageProductArrayList = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("select * from ImageProduct\n" +
                    "where product_type_id = ?"
            );
            stmt.setString(1,productTypeID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String productTypeId = rs.getString(1);
                String id = rs.getString(2);
                String imageUrl = rs.getString(3);
                ImageProduct imageProduct = new ImageProduct(productTypeID, id, imageUrl);
                imageProductArrayList.add(imageProduct);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return imageProductArrayList;
    }

            //pagination Product list: 6 product per page

    public static ArrayList<ProductType> pagingProduct(int index) {
        ArrayList<ProductType> pagingProduct = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT pd.[id]\n"
                    + "      ,pdt.[Id]\n"
                    + "      ,pd.[product_name]\n"
                    + "      ,pdt.[name]\n"
                    + "      ,pdt.[price]\n"
                    + "      ,pd.[brand]\n"
                    + "      ,pd.[detail]\n"
                    + "      ,pd.[origin]\n"
                    + "      ,pd.[status]\n"
                    + "  FROM [dbo].[Product] pd\n"
                    + "INNER JOIN [ProductType] pdt on pdt.[product_id] = pd.[id]"
                    + "ORDER BY pdt.[id]\n"
                    + "OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY\n"
            );
            stmt.setInt(1, (index-1)*9);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idProduct = rs.getString(1);
                String idProductType = rs.getString(2);
                String productName = rs.getString(3);
                String typeName = rs.getString(4);
                double price = rs.getDouble(5);
                String brand = rs.getString(6);
                String detail = rs.getString(7);
                String origin = rs.getString(8);
                char status = rs.getString(9).charAt(0);
                Product product = new Product(idProduct,productName,brand,detail,origin,status);
                ProductType productType = new ProductType(idProductType,idProduct,typeName,price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                pagingProduct.add(productType);
            }
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return pagingProduct;
    }

//    //Get product by ID when choose in product list
    public static Product getProductByID(String idp){
        Product productDetail = new Product();
        try ( Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT pd.[id]\n"
                    + "      ,pdt.[Id]\n"
                    + "      ,pd.[product_name]\n"
                    + "      ,pdt.[name]\n"
                    + "      ,pdt.[price]\n"
                    + "      ,pd.[brand]\n"
                    + "      ,pd.[detail]\n"
                    + "      ,pd.[origin]\n"
                    + "      ,pd.[status]\n"
                    + "  FROM [dbo].[Product] pd\n"
                    + "INNER JOIN [ProductType] pdt on pdt.[product_id] = pd.[id]"
                    + "WHERE pd.[id] = ?"
            );
            stmt.setString(1, idp);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idProduct = rs.getString(1);
                String idProductType = rs.getString(2);
                String productName = rs.getString(3);
                String typeName = rs.getString(4);
                double price = rs.getDouble(5);
                String brand = rs.getString(6);
                String detail = rs.getString(7);
                String origin = rs.getString(8);
                char status = rs.getString(9).charAt(0);

                ProductType productType = new ProductType(idProductType,idProduct,typeName,price);
                productType.setImageProducts(getImageProduct(idProductType));
                productDetail.setIdProduct(idProduct);
                productDetail.setProductName(productName);
                productDetail.setBrand(brand);
                productDetail.setDetail(detail);
                productDetail.setOrigin(origin);
                productDetail.setStatus(status);
                productDetail.getProductTypes().add(productType);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productDetail;
    }
    public static ArrayList<ProductType> getProductByBrand(String brands,String idp){
        ArrayList<ProductType> relateProduct = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT pd.[id]\n"
                    + "      ,pdt.[Id]\n"
                    + "      ,pd.[product_name]\n"
                    + "      ,pdt.[name]\n"
                    + "      ,pdt.[price]\n"
                    + "      ,pd.[brand]\n"
                    + "      ,pd.[detail]\n"
                    + "      ,pd.[origin]\n"
                    + "      ,pd.[status]\n"
                    + "  FROM [dbo].[Product] pd\n"
                    + "INNER JOIN [ProductType] pdt on pdt.[product_id] = pd.[id]"
                    + "WHERE  pd.[brand] = ? AND pd.[id] != ?"
            );
            stmt.setString(1, brands);
            stmt.setString(2, idp);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idProduct = rs.getString(1);
                String idProductType = rs.getString(2);
                String productName = rs.getString(3);
                String typeName = rs.getString(4);
                double price = rs.getDouble(5);
                String brand = rs.getString(6);
                String detail = rs.getString(7);
                String origin = rs.getString(8);
                char status = rs.getString(9).charAt(0);
                Product product = new Product(idProduct,productName,brand,detail,origin,status);
                ProductType productType = new ProductType(idProductType,idProduct,typeName,price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                relateProduct.add(productType);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return relateProduct;
    }

    public static ArrayList<ProductType> getTop3Product(){
        ArrayList<ProductType> listTop3Product = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT TOP 3 pd.[id]\n"
                    + "      ,pdt.[Id]\n"
                    + "      ,pd.[product_name]\n"
                    + "      ,pdt.[name]\n"
                    + "      ,pdt.[price]\n"
                    + "      ,pd.[brand]\n"
                    + "      ,pd.[detail]\n"
                    + "      ,pd.[origin]\n"
                    + "      ,pd.[status]\n"
                    + "  FROM [dbo].[Product] pd\n"
                    + "INNER JOIN [ProductType] pdt on pdt.[product_id] = pd.[id]\n"
                    + "ORDER BY Price DESC"
            );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idProduct = rs.getString(1);
                String idProductType = rs.getString(2);
                String productName = rs.getString(3);
                String typeName = rs.getString(4);
                double price = rs.getDouble(5);
                String brand = rs.getString(6);
                String detail = rs.getString(7);
                String origin = rs.getString(8);
                char status = rs.getString(9).charAt(0);
                Product product = new Product(idProduct,productName,brand,detail,origin,status);
                ProductType productType = new ProductType(idProductType,idProduct,typeName,price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                listTop3Product.add(productType);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listTop3Product;
    }

            public static void main (String[]args){
                ArrayList<ProductType> product = ProductRepository.getTop3Product();
                for (ProductType p:product
                     ) {
                    System.out.println(p);
                }
            }
        }
