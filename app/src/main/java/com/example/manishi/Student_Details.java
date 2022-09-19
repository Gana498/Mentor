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
    TextView Show, Mobile_number;
    CardView cardView;
    LinearLayout More_Details,All_Details;
    Button Call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Show = findViewById(R.id.show);
        More_Details = findViewById(R.id.more_details);
        All_Details = findViewById(R.id.all_details);
        cardView = findViewById(R.id.cardView);
        Call = findViewById(R.id.call);
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
                    Show.setText("Show less");
                    params.height= LinearLayout.LayoutParams.WRAP_CONTENT;

                }
                else{
                    More_Details.setVisibility(View.GONE);
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
    }
}