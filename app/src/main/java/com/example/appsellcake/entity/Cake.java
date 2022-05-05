package com.example.appsellcake.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cake {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "imgDetail")
    private int imgDetail;
    @ColumnInfo(name = "price")
    private String price;

    @ColumnInfo(name = "detail")
    private String detail;
    @ColumnInfo(name = "loai")
    private String loai;

    public Cake(int imgDetail, String price, String name, String detail, String loai) {
        this.imgDetail = imgDetail;
        this.price = price;
        this.name = name;
        this.detail = detail;
        this.loai = loai;
    }

    public int getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(int imgDetail) {
        this.imgDetail = imgDetail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
