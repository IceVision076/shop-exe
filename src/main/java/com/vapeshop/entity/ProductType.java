package com.vapeshop.entity;

import com.vapeshop.respository.employee.ProductRespository;

import java.util.ArrayList;

public class ProductType {

    private String productTypeId;
    private String productId;
    private String typeName;
    private double typePrice;
    private Product product;
    private ArrayList<ImageProduct> imageProducts;
    private char typeStatus;
    private int realAmount;

    private int selledAmount;

    public ProductType() {
        this.imageProducts = new ArrayList<>();
    }

    public ProductType(String productTypeId, String productId, String typeName, double typePrice) {
        this.productTypeId = productTypeId;
        this.productId = productId;
        this.typeName = typeName;
        this.typePrice = typePrice;
        this.product = new Product();
        this.imageProducts = new ArrayList<>();
    }

    public ProductType(String productTypeId, String productId, String typeName, double typePrice, Product product, ArrayList<ImageProduct> imageProducts, char typeStatus) {
        this.productTypeId = productTypeId;
        this.productId = productId;
        this.typeName = typeName;
        this.typePrice = typePrice;
        this.product = product;
        this.imageProducts = imageProducts;
        this.typeStatus = typeStatus;
    }

    public ProductType(String productTypeId, String productId, String typeName, double typePrice, ArrayList<ImageProduct> imageProducts, char typeStatus) {
        this.productTypeId = productTypeId;
        this.productId = productId;
        this.typeName = typeName;
        this.typePrice = typePrice;
        this.imageProducts = imageProducts;
        this.typeStatus = typeStatus;
    }

    public ProductType(String productTypeId, String productId, String typeName, double typePrice, ArrayList<ImageProduct> imageProducts) {
        this.productTypeId = productTypeId;
        this.productId = productId;
        this.typeName = typeName;
        this.typePrice = typePrice;
        this.imageProducts = imageProducts;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<ImageProduct> getImageProducts() {
        return imageProducts;
    }

    public void setImageProducts(ArrayList<ImageProduct> imageProducts) {
        this.imageProducts = imageProducts;
    }

    public String getPriceString () {
        return Double.toString(this.typePrice);
    }

    public char getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(char typeStatus) {
        this.typeStatus = typeStatus;
    }

    public int getSelledAmount() {
        return selledAmount;
    }

    public void setSelledAmount(int selledAmount) {
        this.selledAmount = selledAmount;
    }

    public int getRealAmount() {
//        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>" + ProductRespository.getProductTypeRealAmount(this.productTypeId));
//        return ProductRespository.getProductTypeRealAmount(this.productTypeId);
        return realAmount;
    }

    public void setRealAmount(int realAmount) {
        this.realAmount = realAmount;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "productTypeId='" + productTypeId + '\'' +
                ", productId='" + productId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typePrice=" + typePrice +
                ", product=" + product +
                ", imageProducts=" + imageProducts +
                '}';
    }
}
