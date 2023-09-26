package com.vapeshop.entity;

public class OrderDetail {
    private String orderId;
    private String productTypeId;
    private int amount;
    private double priceAtPurchase;

    public OrderDetail() {
    }

    public OrderDetail(String orderId, String productTypeId, int amount, double priceAtPurchase) {
        this.orderId = orderId;
        this.productTypeId = productTypeId;
        this.amount = amount;
        this.priceAtPurchase = priceAtPurchase;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public void setPriceAtPurchase(double priceAtPurchase) {
        this.priceAtPurchase = priceAtPurchase;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId='" + orderId + '\'' +
                ", productTypeId='" + productTypeId + '\'' +
                ", amount=" + amount +
                ", priceAtPurchase=" + priceAtPurchase +
                '}';
    }
}
