package com.example.appsellcake.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;

import com.example.appsellcake.R;
import com.example.appsellcake.adapter.CategoryAdapter;
import com.example.appsellcake.adapter.ListCakeAdapter;
import com.example.appsellcake.entity.CategoryEntity;
import com.example.appsellcake.entity.ListCakeEntity;

import java.util.ArrayList;


public class Home extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    ArrayList<CategoryEntity> catoryEntities;
    private RecyclerView recyclerViewCatories;
    ListCakeAdapter adapterListCase;
    ArrayList<ListCakeEntity> listCakeEntities;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gridView = findViewById(R.id.gridList);
        listCakeEntities = new ArrayList<>();

        listCakeEntities.add(new ListCakeEntity("Tiramisu 5 vị","180.000 VNĐ", R.drawable.t1));
        listCakeEntities.add(new ListCakeEntity("Tiramisu dâu","150.000 VNĐ",R.drawable.tiramisu_dau));
        listCakeEntities.add(new ListCakeEntity("Tiramisu chanh dây","170.000 VNĐ",R.drawable.tiramisu_chanh));
        listCakeEntities.add(new ListCakeEntity("Tiramisu trà xanh","200.000 VNĐ",R.drawable.tiramisu_tra));

        adapterListCase = new ListCakeAdapter(this,R.layout.item_list_cake,listCakeEntities);
        gridView.setAdapter(adapterListCase);
        recyclerViewCatory();
    }

    private void recyclerViewCatory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        recyclerViewCatories = findViewById(R.id.recyclerView);
        recyclerViewCatories.setLayoutManager(linearLayoutManager);

        catoryEntities = new ArrayList<>();
        catoryEntities.add(new CategoryEntity(R.drawable.gato_1, "Gato"));
        catoryEntities.add(new CategoryEntity(R.drawable.tiramisu_1, "Tiramisu"));
        catoryEntities.add(new CategoryEntity(R.drawable.mouse_1, "Mouse"));
        catoryEntities.add(new CategoryEntity(R.drawable.chese, "Chese"));

        adapter = new CategoryAdapter(catoryEntities);
        recyclerViewCatories.setAdapter(adapter);
    }
}