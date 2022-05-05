package com.example.appsellcake.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appsellcake.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class registerActivity extends AppCompatActivity {
    private EditText txtname,txtemail_register,txtpassword_rigister,txtpassword_rigister2;
    private Button btnlogin;
    private TextView btnregister;

    private FirebaseAuth auth;
    private FirebaseDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        txtname = findViewById(R.id.register_txttentaikhoan);
        txtpassword_rigister=findViewById(R.id.register_txtmatkhau);
        txtemail_register = findViewById(R.id.register_txtemail);
        txtpassword_rigister2= findViewById(R.id.register_txtnhaplaimatkhau);
        btnregister = findViewById(R.id.register_btnresister);
        btnlogin =findViewById(R.id.register_btnlogin);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtYourName= txtname.getText().toString().trim();
                String txtEmailRegister = txtemail_register.getText().toString().trim();
                String txtTypePasswordRegister = txtpassword_rigister.getText().toString().trim();
                String txtReTypePasswordRegister = txtpassword_rigister2.getText().toString().trim();

                // check
                if(txtYourName.equals("") || txtEmailRegister.equals("") || txtTypePasswordRegister.equals("") || txtReTypePasswordRegister.equals("")) {
                    Toast.makeText(registerActivity.this, "Bạn cần nhập đầy đủ thông tin để tiếp tục!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(txtTypePasswordRegister.length() < 6) {
                    Toast.makeText(registerActivity.this, "Mật khẩu cần phải lớn hơn 6 kí tự!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!txtTypePasswordRegister.equals(txtReTypePasswordRegister)) {
                    Toast.makeText(registerActivity.this, "Mật khẩu nhập lại không khớp!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // action
                OnClick_register(txtEmailRegister, txtTypePasswordRegister);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registerActivity.this,loginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void OnClick_register(String email, String password)
    {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(registerActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    HashMap<String,Object> map = new HashMap<>();
                    map.put("name",txtname.getText().toString().trim());
                    map.put("email",txtemail_register.getText().toString().trim());
                    db.getReference().child("managerUsers").push().child("User").setValue(map);

                    Toast.makeText(registerActivity.this,"Bạn đã đăng ký thành công",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(registerActivity.this,loginActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(registerActivity.this,"Đăng ký không thành công!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
