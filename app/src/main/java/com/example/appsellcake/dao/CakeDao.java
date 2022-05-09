package com.example.appsellcake.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.appsellcake.entity.CakeEntity;

import java.util.List;

@Dao
public interface CakeDao {

    //load
    @Query("select * from CakeEntity")
    List<CakeEntity> getCakes();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void saveCakes(CakeEntity cakes);

    @Update
    void updateCake(CakeEntity cake);
}
