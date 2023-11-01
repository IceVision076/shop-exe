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
import java.util.HashSet;

public class ProductRepository {
    //Get all Product from Product,productType,ImageProduct table
    public static ArrayList<ProductType> getAllProduct() {
        ArrayList<ProductType> products = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
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
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
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
    public static int getTotalProduct() {
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) from [dbo].[ProductType]"
            );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static ArrayList<ImageProduct> getImageProduct(String productTypeID) {
        ArrayList<ImageProduct> imageProductArrayList = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("select * from ImageProduct\n" +
                    "where product_type_id = ?"
            );
            stmt.setString(1, productTypeID);
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
        try (Connection con = DBConnect.getConnection()) {
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
            stmt.setInt(1, (index - 1) * 9);
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
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
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
    public static Product getProductByID(String idp) {
        Product productDetail = new Product();
        try (Connection con = DBConnect.getConnection()) {
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

                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
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

    public static ArrayList<ProductType> getProductByBrand(String brands, String idp) {
        ArrayList<ProductType> relateProduct = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT TOP 10 pd.[id]\n"
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
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
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

    public static ArrayList<ProductType> getTop3Product() {
        ArrayList<ProductType> listTop3Product = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
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
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
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

    public static ArrayList<ProductType> getAllBrand() {
        ArrayList<ProductType> listBrand = new ArrayList<>();
        HashSet<String> brandSet = new HashSet<>();
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT DISTINCT pd.[id]\n"
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
                    + "ORDER BY pd.[brand]"
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
                if (!brandSet.contains(brand)) {
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                listBrand.add(productType);
                brandSet.add(brand);
                }

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listBrand;
    }

    public static ArrayList<ProductType> getAllProductByBrand(String brands,int index) {
        ArrayList<ProductType> productBrandList = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
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
                    + "WHERE  pd.[brand] = ?\n"
                    + "ORDER BY pd.[brand] ASC\n"
                    + "OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY\n"
            );
            stmt.setString(1,brands);
            stmt.setInt(2,(index - 1) * 9);
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
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                productBrandList.add(productType);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productBrandList;
    }

    public static ArrayList<ProductType> getProductSearch(String productSearch,int index) {
        ArrayList<ProductType> productSearchList = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
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
                    + "WHERE  pd.[product_name] LIKE ?\n"
                    + "ORDER BY pdt.[price] ASC\n"
                    + "OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY\n"
            );
            stmt.setString(1,"%" + productSearch + "%");
            stmt.setInt(2,(index - 1) * 9);
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
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                productSearchList.add(productType);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productSearchList;
    }

    public static ArrayList<ProductType> getAllProductInRange(double priceFrom, double priceTo, int index) {
        ArrayList<ProductType> productsPrice = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
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
                    + "WHERE pdt.[price] BETWEEN ? AND ?\n"
                    + "ORDER BY pdt.[price]\n"
                    + "OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY\n"
            );
            stmt.setDouble(1, priceFrom);
            stmt.setDouble(2,priceTo);
            stmt.setInt(3,(index - 1) * 9);
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
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                productsPrice.add(productType);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productsPrice;
    }

    public static ArrayList<ProductType> getAllProductIncrease(int index) {
        ArrayList<ProductType> productsPriceIncrease = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
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
                    + "ORDER BY pdt.[price] ASC\n"
                    + "OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY\n"
            );
            stmt.setInt(1,(index - 1) * 9);
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
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                productsPriceIncrease.add(productType);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productsPriceIncrease;
    }

    public static ArrayList<ProductType> getAllProductDecrease(int index) {
        ArrayList<ProductType> productsPriceDecrease = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
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
                    + "ORDER BY pdt.[price] DESC\n"
                    + "OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY\n"
            );
            stmt.setInt(1,(index - 1) * 9);
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
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                productsPriceDecrease.add(productType);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productsPriceDecrease;
    }

    public static ArrayList<ProductType> getAllProductSortByName(int index) {
        ArrayList<ProductType> productsPriceSortByName = new ArrayList<>();
        try (Connection con = DBConnect.getConnection()) {
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
                    + "ORDER BY pd.[product_name] ASC\n"
                    + "OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY\n"
            );
            stmt.setInt(1,(index - 1) * 9);
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
                Product product = new Product(idProduct, productName, brand, detail, origin, status);
                ProductType productType = new ProductType(idProductType, idProduct, typeName, price);
                productType.setProduct(product);
                productType.setImageProducts(getImageProduct(idProductType));
                productsPriceSortByName.add(productType);

            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productsPriceSortByName;
    }
//-------------------------------
    public static ProductType getProductType(String id) { //method cu la getPet()
        try {
            String query = "SELECT  TOP 1 * FROM ProductType t join ImageProduct i  on t.Id = i.product_type_id WHERE t.Id = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productTypeID = results.getString(1);
                String productId = results.getString(2);
                String productTypeName = results.getString(3);
                double productTypePrice = results.getDouble(4);
                char status = results.getString(5).charAt(0);
                String imgId = results.getString(7);
                String imgUrl = results.getString(8);

                ImageProduct imageProduct = new ImageProduct(productId, imgId, imgUrl);
                ArrayList<ImageProduct> imageProducts = new ArrayList<>();
                imageProducts.add(imageProduct);
                ProductType productType = new ProductType(productTypeID, productId, productTypeName, productTypePrice, imageProducts, status);
                System.out.println("=>>>>>>>>>>>??????????   " + productType);
                return productType;
            }
        } catch (Exception e) {
            System.out.println("=========>>Loi getProductType(String id) trong ProductRepository.java<<========== ");
        }
        return null;
    }

    public static Product getProduct(String id) { //hang moi dua tren cai tg getProductType()
        try {
            String query = "SELECT * FROM Product WHERE Id = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productID = results.getString(1);
                String productName = results.getString(2);
                String brand = results.getString(3);
                String detail = results.getString(4);
                String origin = results.getString(5);
                char status = results.getString(6).charAt(0);
                Product product = new Product(productID, productName, brand, detail, origin, status);
                return product;
            }
        } catch (Exception e) {
            System.out.println("=========>>Loi getProduct(String id) trong ProductRepository.java<<========== ");
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<ProductType> product = ProductRepository.getAllProductInRange(0,100000,1);
        for (ProductType p : product
        ) {
            System.out.println(p);
        }
    }
}
