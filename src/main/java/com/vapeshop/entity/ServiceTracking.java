package com.vapeshop.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServiceTracking {

    private String id;
    private String employeeId;
    private String userId;
    private String userDescription;
    private String employeeDescription;
    private LocalDateTime createDate;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime deliveryDate;
    private char status;
    private double price;
    private String title;
    // getters and setters


    public ServiceTracking() {
    }

    public ServiceTracking(String id, String userId, String userDescription, LocalDateTime createDate, char status, String title) {
        this.id = id;
        this.userId = userId;
        this.userDescription = userDescription;
        this.createDate = createDate;
        this.status = status;
        this.title = title;
    }

    public ServiceTracking(String id, String employeeId, String userId, String userDescription, String employeeDescription, LocalDateTime createDate, LocalDateTime estimatedDeliveryDate, LocalDateTime deliveryDate, char status, double price, String title) {
        this.id = id;
        this.employeeId = employeeId;
        this.userId = userId;
        this.userDescription = userDescription;
        this.employeeDescription = employeeDescription;
        this.createDate = createDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
        this.price = price;
        this.title = title;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getEmployeeDescription() {
        return employeeDescription;
    }

    public void setEmployeeDescription(String employeeDescription) {
        this.employeeDescription = employeeDescription;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return "ServiceTracking{" +
                "id='" + id + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", userId='" + userId + '\'' +
                ", userDescription='" + userDescription + '\'' +
                ", employeeDescription='" + employeeDescription + '\'' +
                ", createDate=" + createDate +
                ", estimatedDeliveryDate=" + estimatedDeliveryDate +
                ", deliveryDate=" + deliveryDate +
                ", status=" + status +
                ", price=" + price +
                ", title=" + title +
                '}';
    }
}
