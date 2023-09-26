package com.vapeshop.entity;

import java.time.LocalDate;

public class ImportProduct {

    private String lotId;
    private String productTypeId;
    private int quantity;
    private LocalDate dateTime;

    public ImportProduct() {
    }

    public ImportProduct(String lotId, String productTypeId, int quantity, LocalDate dateTime) {
        this.lotId = lotId;
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

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }
    // getters and setters

    @Override
    public String toString() {
        return "ImportProduct{" +
                "lotId='" + lotId + '\'' +
                ", productTypeId='" + productTypeId + '\'' +
                ", quantity=" + quantity +
                ", dateTime=" + dateTime +
                '}';
    }
}