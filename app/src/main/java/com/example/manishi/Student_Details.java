package com.example.manishi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Student_Details extends AppCompatActivity {
    TextView Show, Mobile_number, Show_mail;
    CardView cardView;
    LinearLayout More_Details,All_Details;
    Button Call, Whatsapp, Mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Show = findViewById(R.id.show);
        More_Details = findViewById(R.id.more_details);
        All_Details = findViewById(R.id.all_details);
        cardView = findViewById(R.id.cardView);
        Call = findViewById(R.id.call);
        Whatsapp = findViewById(R.id.whatsapp);
        Mail = findViewById(R.id.mail);
        Show_mail = findViewById(R.id.show_email);
        Mobile_number = findViewById(R.id.show_mobile);
        int original_height = All_Details.getLayoutParams().height;
        More_Details.setVisibility(View.GONE);
        Show.setText("Show more");
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) cardView.getLayoutParams();
        params.height= 300;
    }
}