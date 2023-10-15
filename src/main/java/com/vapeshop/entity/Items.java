package com.vapeshop.entity;

import com.vapeshop.respository.OrderRepository;

import java.text.DecimalFormat;

public class Items {
    private ProductType productType;
    private int ammout;
    DecimalFormat formatter = new DecimalFormat("#,###,###");

    public Items() {
    }

    public Items(ProductType productType, int ammout) {
        this.productType = productType;
        this.ammout = ammout;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getAmmout() {
        return ammout;
    }

    public void setAmmout(int ammout) {
        this.ammout = ammout;
    }

        public double getPrice() {
        return productType.getTypePrice() * ammout;
    }
    public double getPriceAfterPurchase (String OrderId) {
        for (int i = 0 ; i < 10 ; i ++) {
            System.out.println(OrderId);
            System.out.println(productType.getProductId());
            System.out.println("me");
            System.out.println(OrderRepository.getPriceOrdered(OrderId,productType.getProductId()));
        }
        return OrderRepository.getPriceOrdered(OrderId,productType.getProductId());
    }
    public String getPriceString() {
        return formatter.format(getPrice());
    }

    public boolean equal(Items item) {
        if (this.productType.getProductId().compareToIgnoreCase(item.productType.getProductTypeId()) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Items{" +
                "productType=" + productType +
                ", ammout=" + ammout +
                ", formatter=" + formatter +
                '}';
    }
}
