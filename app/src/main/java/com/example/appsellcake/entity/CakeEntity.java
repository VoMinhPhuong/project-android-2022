package com.example.appsellcake.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CakeEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "imgDetail")
    private int imgDetail;
    @ColumnInfo(name = "soluong")
    private int soluong;
    @ColumnInfo(name = "price")
    private String price;

    @ColumnInfo(name = "detail")
    private String detail;
    @ColumnInfo(name = "loai")
    private String loai;

    public CakeEntity() {
    }

    public CakeEntity(@NonNull String name, int imgDetail, int soluong, String price, String detail, String loai) {
        this.name = name;
        this.imgDetail = imgDetail;
        this.soluong = soluong;
        this.price = price;
        this.detail = detail;
        this.loai = loai;

    }

    public CakeEntity(int soluong) {
        this.soluong = soluong;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(int imgDetail) {
        this.imgDetail = imgDetail;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
