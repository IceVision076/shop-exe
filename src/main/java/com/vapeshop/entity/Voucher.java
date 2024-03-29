package com.vapeshop.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Voucher {
    private String id;
    private String voucherName;
    private double voucherPercent;
    private LocalDateTime createDate;
    private LocalDateTime closeDate;
    private char status;

    private int amount;
private LocalDateTime openDate;
    public Voucher() {
    }

    public Voucher(String id, String voucherName, double voucherPercent, LocalDateTime createDate, LocalDateTime closeDate, char status, LocalDateTime openDate) {
        this.id = id;
        this.voucherName = voucherName;
        this.voucherPercent = voucherPercent;
        this.createDate = createDate;
        this.closeDate = closeDate;
        this.status = status;
        this.openDate = openDate;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public double getVoucherPercent() {
        return voucherPercent;
    }

    public void setVoucherPercent(double voucherPercent) {
        this.voucherPercent = voucherPercent;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id='" + id + '\'' +
                ", voucherName='" + voucherName + '\'' +
                ", voucherPercent=" + voucherPercent +
                ", createDate=" + createDate +
                ", closeDate=" + closeDate +
                ", status=" + status +
                '}';
    }
}
