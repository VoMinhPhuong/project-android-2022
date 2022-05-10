package com.example.appsellcake.gui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.appsellcake.R;
import com.example.appsellcake.adapter.ListCakeAdapter;
import com.example.appsellcake.entity.ListCakeEntity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ListCakeAdapter adapterListCase;
    ArrayList<ListCakeEntity> listCakeEntities;
    GridView gridView;
    FirebaseFirestore fStore;
    DatabaseReference databaseReference;

    Button btnGato;
    Button btnTiramisu;
    Button btnMouse;
    Button btnChese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnGato = findViewById(R.id.btnGato);
        btnGato.requestFocus();
        btnTiramisu = findViewById(R.id.btnTiramisu);
        btnMouse = findViewById(R.id.btnMouse);
        btnChese = findViewById(R.id.btnChese);
        gridView = findViewById(R.id.gridList);
        listCakeEntities = new ArrayList<>();
        fStore = FirebaseFirestore.getInstance();
    }

    private void setColor(Button button) {
        button.setBackgroundResource(R.drawable.category_buton_click);
    }

    private void resetColor(Button button) {
        button.setBackgroundResource(R.drawable.category_boder);
    }

    public void gatoClick(View view) {
        setColor(btnGato);
        resetColor(btnChese);
        resetColor(btnMouse);
        resetColor(btnTiramisu);
        getDataInFireBase("Gato");
    }

    public void tiramisuClick(View view) {
        setColor(btnTiramisu);
        resetColor(btnChese);
        resetColor(btnMouse);
        resetColor(btnGato);
        getDataInFireBase("Tiramisu");
    }

    public void mouseClick(View view) {
        setColor(btnMouse);
        resetColor(btnChese);
        resetColor(btnGato);
        resetColor(btnTiramisu);
        getDataInFireBase("Mouse");
    }

    public void cheseClick(View view) {
        setColor(btnChese);
        resetColor(btnGato);
        resetColor(btnMouse);
        resetColor(btnTiramisu);
        getDataInFireBase("Cheese");
    }

    private void getDataInFireBase(String category) {
        listCakeEntities.clear();
        databaseReference = FirebaseDatabase.getInstance().getReference(category);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String name = dataSnapshot.child("nameCake").getValue().toString();
                    String price = dataSnapshot.child("price").getValue().toString();
                    String category = dataSnapshot.child("category").getValue().toString();
                    String detail = dataSnapshot.child("detail").getValue().toString();
                    String img = dataSnapshot.child("img").getValue().toString();
                    ListCakeEntity entity = new ListCakeEntity(name,price,category,detail,img);
                    listCakeEntities.add(entity);
                }
                adapterListCase = new ListCakeAdapter(Home.this, R.layout.item_list_cake, listCakeEntities);
                gridView.setAdapter(adapterListCase);
                adapterListCase.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}