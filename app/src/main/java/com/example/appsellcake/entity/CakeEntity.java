package com.example.appsellcake.entity;

public class CakeEntity {
    private int imgDetail;
    private double price;
    private String name;
    private String detail;

    public CakeEntity(int imgDetail, double price, String name, String detail) {
        this.imgDetail = imgDetail;
        this.price = price;
        this.name = name;
        this.detail = detail;
    }

    public int getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(int imgDetail) {
        this.imgDetail = imgDetail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
