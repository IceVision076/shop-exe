package com.vapeshop.respository;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.ImageProduct;
import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    //Get all Product from Product,productType,ImageProduct table
    public static ArrayList<Product> getAllProduct() {
        ArrayList<Product> products = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT pd.[id]\n"
                    + "      ,pdt.[Id]\n"
                    + "      ,pd.[product_name]\n"
                    + "      ,pdt.[name]\n"
                    + "      ,pdt.[price]\n"
                    + "      ,pd.[brand]\n"
                    + "      ,pd.[detail]\n"
                    + "      ,pd.[origin]\n"
                    + "      ,ipd.[image_url]\n"
                    + "      ,pd.[status]\n"
                    + "  FROM [dbo].[Product] pd\n"
                    + "INNER JOIN [ProductType] pdt on pdt.[product_id] = pd.[id]"
                    + "INNER JOIN [ImageProduct] ipd on ipd.[product_type_id] = pdt.[id]"
                    );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String idProductType = rs.getString(2);
                String productName = rs.getString(3);
                String typeName = rs.getString(4);
                double price = rs.getDouble(5);
                String brand = rs.getString(6);
                String detail = rs.getString(7);
                String origin = rs.getString(8);
                String imgURL = rs.getString(9);
                char status = rs.getString(10).charAt(0);

                products.add(new Product(id,idProductType,productName,typeName,price,brand,detail,origin,imgURL,status));
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
            PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) from [dbo].[Product]"
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

    //pagination Product list: 6 product per page

    public static List<Product> pagingProduct(int index){
        List<Product> productList = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT pd.[id]\n"
                    + "      ,pdt.[Id]\n"
                    + "      ,pd.[product_name]\n"
                    + "      ,pdt.[name]\n"
                    + "      ,pdt.[price]\n"
                    + "      ,pd.[brand]\n"
                    + "      ,pd.[detail]\n"
                    + "      ,pd.[origin]\n"
                    + "      ,ipd.[image_url]\n"
                    + "      ,pd.[status]\n"
                    + "  FROM [dbo].[Product] pd\n"
                    + "INNER JOIN [ProductType] pdt on pdt.[product_id] = pd.[id]\n"
                    + "INNER JOIN [ImageProduct] ipd on ipd.[product_type_id] = pdt.[id]\n"
                    + "ORDER BY pd.[id]\n"
                    + "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY\n"
            );
            stmt.setInt(1, (index-1)*6);
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
                String imgURL = rs.getString(9);
                char status = rs.getString(10).charAt(0);

                productList.add(new Product(idProduct,idProductType,productName,typeName,price,brand,detail,origin,imgURL,status));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    //Get product by ID when choose in product list
    public static Product getProductByID(String idp){
        Product product = null;
        try ( Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT pd.[id]\n"
                    + "      ,pd.[product_name]\n"
                    + "      ,pd.[brand]\n"
                    + "      ,pdt.[price]\n"
                    + "      ,pd.[detail]\n"
                    + "      ,pd.[origin]\n"
                    + "      ,ipd.[image_url]\n"
                    + "      ,pd.[status]\n"
                    + "FROM [dbo].[Product] pd\n"
                    + "INNER JOIN [ProductType] pdt on pdt.[product_id] = pd.[id]\n"
                    + "INNER JOIN [ImageProduct] ipd on ipd.[product_type_id] = pdt.[id]\n"
                    + "WHERE pd.[id] = ?  "
            );
            stmt.setString(1, idp);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String productName = rs.getString(2);
                String brand = rs.getString(3);
                double price = rs.getDouble(4);
                String detail = rs.getString(5);
                String origin = rs.getString(6);
                String imgURL = rs.getString(7);
                char status = rs.getString(8).charAt(0);

                product = new Product(id,productName,brand,price,detail,origin,imgURL,status);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public static ArrayList<Product> getImageByID(String idproduct){
        ArrayList<Product> imageProducts = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT ipd.[image_url]\n"
                    + "  FROM [dbo].[ProductType] pd INNER JOIN ImageProduct ipd on ipd.[product_type_id] = pd.[id]\n"
                    + "WHERE pd.[product_id] = ?  "
            );
            stmt.setString(1, idproduct);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String image_url = rs.getString(1);

                imageProducts.add(new Product(image_url));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return imageProducts;
    }


    public static ArrayList<ProductType> getTypeByID(String idproduct){
        ArrayList<ProductType> TypeProducts = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT pd.[Id],\n"
                    + " pd.[name],\n"
                    + " pd.[price]\n"
                    + "  FROM [dbo].[ProductType] pd\n"
                    + "WHERE pd.[product_id] = ?  "
            );
            stmt.setString(1, idproduct);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idType = rs.getString(1);
                String typeName = rs.getString(2);
                double price = rs.getDouble(3);

                TypeProducts.add(new ProductType(idType,typeName,price));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return TypeProducts;
    }

    public static void main(String[] args) {
        List<Product> productArrayList=pagingProduct(1);
        for (Product p: productArrayList
             ) {
            System.out.println(p);
        }
    }
}
