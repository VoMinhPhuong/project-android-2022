package com.example.appsellcake.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hoadon")
public class HoaDon {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "ten")
    private String ten;
    @ColumnInfo(name = "sl")
    private int sl;
    @ColumnInfo(name = "gia")
    private double gia;
    @ColumnInfo(name = "thanhTien")
    private double thanhTien;

    public HoaDon() {
    }

    public HoaDon(int id, String ten, int sl, double gia, double thanhTien) {
        this.id = id;
        this.ten = ten;
        this.sl = sl;
        this.gia = gia;
        this.thanhTien = this.sl * this.gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}

