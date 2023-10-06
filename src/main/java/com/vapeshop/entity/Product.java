package com.vapeshop.entity;

import java.util.ArrayList;

public class Product {
    private String idProduct;
    private String productName;
    private String brand;
    private String detail;
    private String origin;

    private char status;

    private ArrayList<ProductType> productTypes;

    public Product() {
        this.productTypes = new ArrayList<>();
    }

    public Product(String idProduct, String productName, String brand, String detail, String origin, char status) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.brand = brand;
        this.detail = detail;
        this.origin = origin;
        this.status = status;
        this.productTypes = new ArrayList<>();
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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public ArrayList<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(ArrayList<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", detail='" + detail + '\'' +
                ", origin='" + origin + '\'' +
                ", status=" + status +
                ", productTypes=" + productTypes +
                '}';
    }
}
