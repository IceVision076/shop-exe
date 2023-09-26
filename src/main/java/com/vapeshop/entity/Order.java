package com.vapeshop.entity;

import java.time.LocalDate;

public class Order {
    private String orderId;
    private String userId;
    private String productId;
    private LocalDate createDate;
    private LocalDate deliveryDate;
    private char status;
    private String voucherId;

    public Order() {
    }

    public Order(String orderId, String userId, String productId, LocalDate createDate, LocalDate deliveryDate, char status, String voucherId) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.createDate = createDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.voucherId = voucherId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", createDate=" + createDate +
                ", deliveryDate=" + deliveryDate +
                ", status=" + status +
                ", voucherId='" + voucherId + '\'' +
                '}';
    }
}
