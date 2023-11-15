package com.vapeshop.entity;

public class ImageProduct {

    private String productTypeId;
    private String id;
    private String imageUrl;

    public ImageProduct() {
    }

    public ImageProduct(String productTypeId, String id, String imageUrl) {
        this.productTypeId = productTypeId;
        this.id = id;
        this.imageUrl = imageUrl;
    }



    // getters and setters

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ImageProduct{" +
                "productTypeId='" + productTypeId + '\'' +
                ", id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}