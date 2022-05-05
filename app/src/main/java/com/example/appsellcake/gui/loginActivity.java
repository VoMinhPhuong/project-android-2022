package com.example.appsellcake.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appsellcake.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    private EditText txtemail,txtpassword;
    private Button btnsignin;
    private TextView btnregister;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtemail = findViewById(R.id.login_txtemail);
        txtpassword = findViewById(R.id.login_txtmatkhau);
        btnsignin = findViewById(R.id.login_btnlogin);
        btnregister = findViewById(R.id.login_btndangky);
        auth = FirebaseAuth.getInstance();

        btnsignin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String txtEmail = txtemail.getText().toString().trim();
                String txtPassword = txtpassword.getText().toString().trim();

                if(txtEmail.equals("")|| txtPassword.equals(""))
                {
                    Toast.makeText(loginActivity.this,"Vui lòng nhập email và password",Toast.LENGTH_LONG).show();
                    return;
                }
                onClick_btnSignIn(txtEmail,txtPassword);

            }
        });
        btnregister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this, registerActivity.class);
                startActivity(intent);
            }
        });
    }
    private void onClick_btnSignIn(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(loginActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(loginActivity.this, "Đăng nhập thành công. Xin chúc mừng bạn.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(loginActivity.this,Home.class);
                Bundle bl = new Bundle();
                bl.putString("email",email);
                intent.putExtras(bl);
                startActivity(intent);
            }
        });
    }
}
