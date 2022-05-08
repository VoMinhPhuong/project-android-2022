package com.example.appsellcake.entity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class ListCakeEntity {
    public String tenBanh, donGia,loaiBanh,chiTiet;
    public String hinhAnh;

    public ListCakeEntity(String tenBanh, String donGia, String loaiBanh, String chiTiet, String hinhAnh) {
        this.tenBanh = tenBanh;
        this.donGia = donGia;
        this.loaiBanh = loaiBanh;
        this.chiTiet = chiTiet;
        this.hinhAnh = hinhAnh;
    }
}
