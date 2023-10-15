package com.vapeshop.entity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order { //gio hang = cart
    private String orderId; // id cua order
    private String userId;
    private LocalDate createDate;
    private char status;
    private String voucherId;
    private List<Items> cart; //list cac item
    DecimalFormat formatter = new DecimalFormat("#,###,###");
    private int paymentType = 0; //0 la COD , 1 la CK
    private double discountPercent =0f; //phan tram giam gia
    private String discountCode; //ma giam gia
    public Order() {
        cart = new ArrayList<>();
    }

    public Order(String orderId, String userId, LocalDate createDate, char status, String voucherId, List<Items> cart, DecimalFormat formatter, int paymentType, double discountPercent, String discountCode) {
        this.orderId = orderId;
        this.userId = userId;
        this.createDate = createDate;
        this.status = status;
        this.voucherId = voucherId;
        this.cart = cart;
        this.formatter = formatter;
        this.paymentType = paymentType;
        this.discountPercent = discountPercent;
        this.discountCode = discountCode;
    }

    /*====================================START GET/SET() METHOD============================================================*/

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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
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

    public List<Items> getCart() {
        return cart;
    }

    public void setCart(List<Items> cart) {
        this.cart.addAll(cart);
    }

    public DecimalFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(DecimalFormat formatter) {
        this.formatter = formatter;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    /*====================================END GET/SET() METHOD============================================================*/


    /*====================================START EXTENDED METHOD============================================================*/
    public void removeAll(){
        cart.clear();
    }

    public String addItems(Items item) {
        if (cart.isEmpty()) {
            cart.add(item);
            return "=========>CART : add Thanh Cong<==========";
        } else {
            for (Items items : cart) {
                if (items.equal(item)) {
                    Items hang = cart.get(cart.indexOf(items));
                    hang.setAmmout(hang.getAmmout() + item.getAmmout());
                    return "=========>CART : add Thanh Cong<==========";

                }
            }
            cart.add(item);
            return "=========>CART : add Thanh Cong<==========";
        }
    }

    public double getThanhTien(double phatsinh) { //done
        double tong = 0;
        for (Items item : cart) {
            tong += item.getPrice();
        }
        return tong + phatsinh;
    }
    public double getThanhTienAfterPurchase(double phatsinh) {
        double tong = 0;
        for (Items item : cart) {
            tong += item.getPriceAfterPurchase(orderedId);
        }
        return tong + phatsinh;
    }
    public double getThanhTienAfterPurchaseDiscount(double phatsinh) {
        double tong = 0;
        for (Items item : cart) {
            tong += item.getPriceAfterPurchase(orderedId);
        }
        return (tong + phatsinh) - (tong*discountPercent);
    }
    public String getThanhTienString(double phatsinh) {
        if (cart.isEmpty()) {
            return "0";
        }
        return formatter.format(getThanhTien(phatsinh));

    }
    public String getThanhTienStringDiscount(double phatsinh) {
        if (cart.isEmpty()) {
            return "0";
        }
        return formatter.format(getThanhTienDiscount(phatsinh));

    }
    public double getThanhTienDiscount(double phatsinh) {
        double tong = 0;
        for (Items item : cart) {
            tong += item.getPrice();
        }
        double x = (tong - tong *discountPercent) + phatsinh;
        System.out.println(x);
        System.out.println(x);
        System.out.println(x);
        System.out.println(x);
        return x;
    }
    public String getThanhTienStringAfterPurchase(double phatsinh) {
        if (cart.isEmpty()) {
            return "0";
        }
        return formatter.format(getThanhTienAfterPurchase(phatsinh));

    }
    public String getThanhTienStringAfterPurchaseDiscount(double phatsinh) {
        if (cart.isEmpty()) {
            return "0";
        }
        return formatter.format(getThanhTienAfterPurchaseDiscount(phatsinh));

    }

    /*====================================END EXTENDED METHOD============================================================*/

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                ", voucherId='" + voucherId + '\'' +
                ", cart=" + cart +
                ", formatter=" + formatter +
                ", paymentType=" + paymentType +
                ", discountPercent=" + discountPercent +
                ", discountCode='" + discountCode + '\'' +
                '}';
    }
}
