package com.example.appsellcake.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.appsellcake.entity.Cake;

import java.util.List;

@Dao
public interface CakeDao {

    //load
    @Query("select * from Cake")
    List<Cake> getCakes();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void saveCakes(Cake cakes);
}
