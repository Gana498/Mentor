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
        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(More_Details.getVisibility()==View.GONE){
                    More_Details.setVisibility(View.VISIBLE);
                    Call.setVisibility(View.VISIBLE);
                    Show.setText("Show less");
                    params.height= LinearLayout.LayoutParams.WRAP_CONTENT;

                }
                else{
                    More_Details.setVisibility(View.GONE);
                    Call.setVisibility(View.GONE);
                    Show.setText("Show more");
                    params.height= 300;
                }
            }
        });
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = Mobile_number.getText().toString().substring(2,12);
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });
        Whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = Mobile_number.getText().toString().substring(2,12);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/+91"+number)));
            }
        });
        Mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = Show_mail.getText().toString();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+mail)));
            }
        });
    }
}