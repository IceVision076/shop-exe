package com.vapeshop.entity;

public class ProductType {

    private String productTypeId;
    private String productId;
    private String typeName;
    private double typePrice;
    private String imgURL;
    public ProductType() {
    }

    public ProductType(String productTypeId, String productId, String typeName, double typePrice) {
        this.productTypeId = productTypeId;
        this.productId = productId;
        this.typeName = typeName;
        this.typePrice = typePrice;
    }

    public ProductType(String productTypeId, String typeName, double typePrice) {
        this.productTypeId = productTypeId;
        this.typeName = typeName;
        this.typePrice = typePrice;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getTypePrice() {
        return typePrice;
    }

    public void setTypePrice(double typePrice) {
        this.typePrice = typePrice;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id='" + productTypeId + '\'' +
                ", productId='" + productId + '\'' +
                ", name='" + typeName + '\'' +
                ", price=" + typePrice +
                '}';
    }
}
