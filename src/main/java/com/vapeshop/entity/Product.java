package com.vapeshop.entity;

public class Product {
    private String id;
    private String productName;
    private String brand;
    private String detail;
    private String origin;
    private char status;

    public Product() {
    }

    public Product(String id, String productName, String brand, String detail, String origin, char status) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.detail = detail;
        this.origin = origin;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", detail='" + detail + '\'' +
                ", origin='" + origin + '\'' +
                ", status=" + status +
                '}';
    }
}
