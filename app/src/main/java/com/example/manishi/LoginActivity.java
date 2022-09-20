package com.example.manishi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button Login;
    TextView Welcome;
    String str;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        Welcome = findViewById(R.id.welcome_textView);
        Intent intent = getIntent();
        str = intent.getStringExtra("message_key");
        Welcome.setText(str+" Login");
        Login = findViewById(R.id.login_button);
        Login.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            finish();
        });



    }
}