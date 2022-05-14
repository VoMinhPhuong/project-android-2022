package com.example.appsellcake.dao;

import com.example.appsellcake.entity.HoaDon;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HoaDonFirebaseDAO {
    private DatabaseReference databaseReference;
    public HoaDonFirebaseDAO(String Order) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Order);
    }

    public Task<Void> add(HoaDon bussines) {
        return databaseReference.push().setValue(bussines);
    }
}
