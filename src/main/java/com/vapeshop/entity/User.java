package com.vapeshop.entity;

public class User {
    private String id;
    private String userName;
    private String passWord;
    private String fullName;
    private String email;
    private String role;
    private String phone;
    private String status;
    private String avatarImg;
    private String address;

    public User() {
    }

    ;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }



    public User(String id, String userName, String passWord, String fullName, String email, String role, String phone, String status, String avatarImg, String address) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.phone = phone;
        this.status = status;
        this.avatarImg = avatarImg;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", fullName=" + fullName + ", email=" + email + ", role=" + role + ", phone=" + phone + ", status=" + status + ", avatarImg=" + avatarImg + ", address=" + address + '}';
    }
}
