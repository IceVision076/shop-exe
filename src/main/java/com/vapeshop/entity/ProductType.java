package com.vapeshop.entity;

public class ProductType {

    private String id;
    private String productId;
    private String name;
    private double price;

    public ProductType() {
    }

    public ProductType(String id, String productId, String name, double price) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
