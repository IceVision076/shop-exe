package com.vapeshop.entity;

public class ProductType {

    private String id;
    private String productId;
    private String name;
    private double price;
    private String image_url;
    public ProductType() {
    }

    public ProductType(String id, String productId, String name, double price) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public ProductType(String id, String name, double price) {
        this.id = id;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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
