package com.example.appsellcake.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsellcake.R;
import com.example.appsellcake.dao.CakeDao;
import com.example.appsellcake.dao.DatabaseCake;
import com.example.appsellcake.entity.CakeEntity;

public class DetailCake extends AppCompatActivity {
    private ImageButton btncong;
    private ImageButton btntru;
    private TextView tvsl;
    private TextView tvprice;
    private TextView tvtotal;

    private int sl=1;
    private DatabaseCake db;
    private CakeDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cake);


        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        tvsl = findViewById(R.id.tvsl);
        tvprice= findViewById(R.id.tvprice);
        tvtotal = findViewById(R.id.tvtotal);





        db = Room.databaseBuilder(getApplicationContext(),DatabaseCake.class,"chi tiết-cake").allowMainThreadQueries().build();

        dao = db.cakeDao();

        tvsl.setText(sl+"");
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CakeEntity cake = new CakeEntity();
                sl= sl+1;
                tvsl.setText(sl+"");
                dao.saveCakes(new CakeEntity(sl));
                cake.setSoluong(cake.getSoluong()+1);
                try {
                    dao.updateCake(cake);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CakeEntity cake = new CakeEntity();

                sl=sl-1;

                if(sl<1){
                    Toast.makeText(DetailCake.this, "Số lượng không được nhỏ hơn 1", Toast.LENGTH_SHORT).show();
                    sl=1;
                }else {
                    tvsl.setText(sl+"");
                    dao.saveCakes(new CakeEntity(sl));
                    cake.setSoluong(cake.getSoluong() + 1);
                    try {
                        dao.updateCake(cake);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });



//        btntru.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                sl = sl-1;
//                if(sl<1){
//                    Toast.makeText(DetailCake.this, "Số lượng không được nhỏ hơn 1", Toast.LENGTH_SHORT).show();
//                }else {
//                    tvsl.setText(sl+"");
//                }
//
//            }
//        });
    }
}
