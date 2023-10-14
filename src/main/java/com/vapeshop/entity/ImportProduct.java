package com.vapeshop.entity;

import java.time.LocalDateTime;

public class ImportProduct {

    private String lotId;
    private String lotName;
    private String productTypeId;
    private int quantity;
    private LocalDateTime dateTime;

    public ImportProduct() {
    }

    public ImportProduct(String lotId, String lotName, String productTypeId, int quantity, LocalDateTime dateTime) {
        this.lotId = lotId;
        this.lotName = lotName;
        this.productTypeId = productTypeId;
        this.quantity = quantity;
        this.dateTime = dateTime;
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ImportProduct{" +
                "lotId='" + lotId + '\'' +
                ", lotName='" + lotName + '\'' +
                ", productTypeId='" + productTypeId + '\'' +
                ", quantity=" + quantity +
                ", dateTime=" + dateTime +
                '}';
    }
}