package com.vapeshop.entity;

public class User {

    private String id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private char role;
    private String phone;
    private char status;
    private String avataImg;
    private String address;

    public User() {
    }

    public User(String id, String username, String password, String fullName, String email, char role, String phone, char status, String avataImg, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.phone = phone;
        this.status = status;
        this.avataImg = avataImg;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getAvataImg() {
        return avataImg;
    }

    public void setAvataImg(String avataImg) {
        this.avataImg = avataImg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", avataImg='" + avataImg + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
