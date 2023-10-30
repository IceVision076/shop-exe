package com.vapeshop.entity;

import java.time.LocalDateTime;

public class Poster {
    private String id;
    private String imgUrl;
    private User user;
    private LocalDateTime dateCreate;
    private char status;

    public Poster() {
    }

    public Poster(String id, String imgUrl, User user, LocalDateTime dateCreate, char status) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.user = user;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "id='" + id + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", user=" + user +
                ", dateCreate=" + dateCreate +
                ", status=" + status +
                '}';
    }
}
