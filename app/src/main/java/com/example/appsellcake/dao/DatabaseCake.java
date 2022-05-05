package com.example.appsellcake.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.appsellcake.entity.Cake;

@Database(entities = {Cake.class}, version = 1)
public abstract class DatabaseCake extends RoomDatabase {

    public abstract  CakeDao cakeDao();

}
