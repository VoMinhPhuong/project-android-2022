package com.example.appsellcake.dao;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.appsellcake.entity.HoaDon;

@Database(entities = {HoaDon.class}, version = 1)
public abstract class DatabaseHoaDon extends RoomDatabase {
    public abstract HoaDonDAO hoaDonDAO();


}
