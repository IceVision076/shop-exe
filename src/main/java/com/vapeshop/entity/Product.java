package com.vapeshop.entity;

public class Product {
    private String idProduct;

    private String productName;
    private String brand;
    private String detail;
    private String origin;
    private double price;
    private char status;
    private String idProductType;
    private String typeName;

    private String imgURL;



    public Product() {
    }

    public Product(String idProduct, String productName, String brand, String detail, String origin, char status) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.brand = brand;
        this.detail = detail;
        this.origin = origin;
        this.status = status;
    }


    public Product(String idProduct, String productName, String brand,double price, String detail, String origin, String imgURL, char status) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.detail = detail;
        this.origin = origin;
        this.imgURL = imgURL;
        this.status = status;
    }
    public Product(String idProduct, String productName, String typeName, double price, String brand, String detail, String origin, String imgURL, char status) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.typeName = typeName;
        this.price = price;
        this.brand = brand;
        this.detail = detail;
        this.origin = origin;
        this.imgURL = imgURL;
        this.status = status;
    }
//    Product(idProduct,idProductType,productName,typeName,price,brand,detail,origin,imgURL,status)
    public Product(String idProduct, String idProductType, String productName, String typeName, double price, String brand, String detail, String origin, String imgURL, char status) {
        this.idProduct = idProduct;
        this.idProductType = idProductType;
        this.productName = productName;
        this.typeName = typeName;
        this.price = price;
        this.brand = brand;
        this.detail = detail;
        this.origin = origin;
        this.imgURL = imgURL;
        this.status = status;
    }

    public Product(String idProductType, String typeName, double price) {
        this.idProductType = idProductType;
        this.typeName = typeName;
        this.price = price;
    }

    public Product(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public char getStatus() {
        return status;
    }

    public String getTypeName() {
        return typeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(String idProductType) {
        this.idProductType = idProductType;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", detail='" + detail + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", idProductType='" + idProductType + '\'' +
                ", typeName='" + typeName + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}
