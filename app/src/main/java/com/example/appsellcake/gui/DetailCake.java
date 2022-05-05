package com.example.appsellcake.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.appsellcake.R;

public class DetailCake extends AppCompatActivity {
    private ImageButton btncong;
    private ImageButton btntru;
    private TextView tvsl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cake);


        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        tvsl = findViewById(R.id.tvsl);


        tvsl.setText("1");


        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int sl=1;
                sl = sl++;
                tvsl.setText(sl+"");

            }
        });
    }
}