package com.example.appsellcake.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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

    private ImageView imgdetail;
    private TextView tvName;
    private TextView tvdetail;



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

        imgdetail=findViewById(R.id.imgdetail);

        tvName=findViewById(R.id.tvName);
        tvdetail=findViewById(R.id.tvdetail);

        Intent in = getIntent();
        String img =in.getStringExtra("imgDetail");
        String name= in.getStringExtra("name");
        String detail= in.getStringExtra("detail");
        String price2= in.getStringExtra("price");
        Log.d("ABC",""+img);
        Glide.with(DetailCake.this)
                .load(img)
                .into(imgdetail);
        tvName.setText(name);
        tvdetail.setText(detail);
        tvprice.setText(price2);



        db = Room.databaseBuilder(getApplicationContext(),DatabaseCake.class,"chi tiết-cake").allowMainThreadQueries().build();

        dao = db.cakeDao();

        tvsl.setText(sl+"");
//        double a = Double.parseDouble(tvprice.getText().toString())* Double.parseDouble(tvsl.getText().toString());
        tvtotal.setText(tvprice.getText().toString());
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
                double a = Double.parseDouble(tvprice.getText().toString())* Double.parseDouble(tvsl.getText().toString());
                tvtotal.setText(a+"");
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
                    cake.setSoluong(cake.getSoluong() - 1);
                    try {
                        dao.updateCake(cake);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                double a = Double.parseDouble(tvprice.getText().toString())* Double.parseDouble(tvsl.getText().toString());
                tvtotal.setText(a+"");

            }
        });




    }
}
