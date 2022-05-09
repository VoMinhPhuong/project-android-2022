package com.example.appsellcake.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.appsellcake.entity.CakeEntity;

@Database(entities = {CakeEntity.class}, version = 1)
public abstract class DatabaseCake extends RoomDatabase {

    public abstract  CakeDao cakeDao();

}
