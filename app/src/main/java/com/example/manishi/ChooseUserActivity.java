package com.example.manishi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseUserActivity extends AppCompatActivity {
    Button Faculty_Button, Student_Button;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);
        Faculty_Button =findViewById(R.id.faculty_button);
        Student_Button =findViewById(R.id.student_button);
        Faculty_Button.setOnClickListener(view -> {
            str = "Mentor";
            send(str);
        });
        Student_Button.setOnClickListener(view -> {
            str = "Student";
            send(str);
        });
    }

    private void send(String str) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.putExtra("message_key", str);
        startActivity(intent);
    }
}