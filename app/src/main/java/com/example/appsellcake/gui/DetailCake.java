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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.appsellcake.R;
import com.example.appsellcake.dao.CakeDao;
import com.example.appsellcake.dao.DatabaseCake;
import com.example.appsellcake.dao.DatabaseHoaDon;
import com.example.appsellcake.dao.HoaDonDAO;
import com.example.appsellcake.dao.HoaDonFirebaseDAO;
import com.example.appsellcake.entity.CakeEntity;
import com.example.appsellcake.entity.HoaDon;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class DetailCake extends AppCompatActivity {
    private ImageButton btncong;
    private ImageButton btntru;
    private TextView tvsl;
    private TextView tvprice;
    private TextView tvtotal;
    private FirebaseAuth auth;
    private TextView tvSkip;

    private ImageView imgdetail;
    private TextView tvName;
    private TextView tvdetail;
    private DatabaseHoaDon dbhd;
    private HoaDonDAO daohd;
    private double thanhTien ;
    private Button btnMua;
    HoaDonFirebaseDAO hoaDonFirebaseDAO;

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

        btnMua = findViewById(R.id.btnMua);
        tvSkip = findViewById(R.id.tvSkip);

        auth= FirebaseAuth.getInstance();
        dbhd = Room.databaseBuilder(getApplicationContext(),DatabaseHoaDon.class,"HoaDon").allowMainThreadQueries().build();
        daohd = dbhd.hoaDonDAO();



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
        dbhd = Room.databaseBuilder(getApplicationContext(),DatabaseHoaDon.class,"hoadon").allowMainThreadQueries().build();
        dao = db.cakeDao();
        daohd = dbhd.hoaDonDAO();

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
                thanhTien = Double.parseDouble(tvprice.getText().toString())* Double.parseDouble(tvsl.getText().toString());
                tvtotal.setText(thanhTien+"");
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
                 thanhTien = Double.parseDouble(tvprice.getText().toString())* Double.parseDouble(tvsl.getText().toString());
                tvtotal.setText(thanhTien+"");

            }
        });

        btnMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = new Random().nextInt(100000);
                double gia = Double.parseDouble(price2);
                HoaDon hoaDon = new HoaDon(id,name,sl,gia,thanhTien);
                daohd.saveHoaDon(hoaDon);
                hoaDonFirebaseDAO = new HoaDonFirebaseDAO("Order");
                addData(daohd.findHoaDonByID(id));

                Log.d("ABC","So Luong"+sl +" gia: " + gia+" thanh Tien: " + thanhTien);
            }
        });

    }

    private void addData(HoaDon hoaDon) {
        hoaDonFirebaseDAO.add(hoaDon).addOnSuccessListener(suc -> {
            Toast.makeText(this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(err -> {
            Toast.makeText(this, "Đặt hàng không thành công", Toast.LENGTH_SHORT).show();
        });
    }
    public void close(View view) {
        startActivity(new Intent(this, Home.class));
    }
}
