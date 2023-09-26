package com.vapeshop.entity;

import java.time.LocalDate;

public class Voucher {
    private String id;
    private String voucherName;
    private double voucherPercent;
    private LocalDate createDate;
    private LocalDate closeDate;
    private char status;

    public Voucher() {
    }

    public Voucher(String id, String voucherName, double voucherPercent, LocalDate createDate, LocalDate closeDate, char status) {
        this.id = id;
        this.voucherName = voucherName;
        this.voucherPercent = voucherPercent;
        this.createDate = createDate;
        this.closeDate = closeDate;
        this.status = status;
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
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
