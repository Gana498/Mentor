package com.example.manishi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button Logout, Register_1, Register_2;
    Spinner branch_dropdown, S_type_dropdown, Gender_dropdown;
    LinearLayout Ll,Ll2;
    ScrollView Sv;
    CardView Cv;
    ConstraintLayout CL;
    TextView SD;
    String[] branch_list = { "Select your Branch.","ECE","CSE","MEC","EEE","CIVIL" },student_type={"Select Type","Scholar","Management"}, gender ={"Select Gender", "Male", "Female"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Logout = findViewById(R.id.logout_button);
        SD = findViewById(R.id.student_details);
        CL = findViewById(R.id.cl);
        Cv = findViewById(R.id.cv);
        Ll = findViewById(R.id.ll);
        Ll2 = findViewById(R.id.ll2);
        Sv = findViewById(R.id.sv);
        Register_1 = findViewById(R.id.rb1);
        Register_2 = findViewById(R.id.rb2);


        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        Ll.setVisibility(View.GONE);

        Register_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ll.setVisibility(View.VISIBLE);
                Register_1.setVisibility(View.GONE);
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });

        Cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CL.getVisibility()!=View.GONE){
                    CL.setVisibility(View.GONE);
                    Ll.setPadding(10,20,10,20);
                    Ll2.setPadding(0,20,-600,20);
                }
                else {
                    CL.setVisibility(View.VISIBLE);
                    Ll.setPadding(0,20,-150,20);
                    Ll2.setPadding(0,20,-450,20);
                }
            }
        });

        branch_dropdown = findViewById(R.id.branch_type);
        branch_dropdown.setOnItemSelectedListener(this);
        ArrayAdapter<String> branch_adapter = new ArrayAdapter<>(this, R.layout.branch_item, branch_list);
        branch_adapter.setDropDownViewResource(R.layout.dropdown_item);
        branch_dropdown.setAdapter(branch_adapter);

        S_type_dropdown = findViewById(R.id.student_type);
        S_type_dropdown.setOnItemSelectedListener(this);
        ArrayAdapter<String> S_type_adapter = new ArrayAdapter<>(this, R.layout.branch_item, student_type);
        S_type_adapter.setDropDownViewResource(R.layout.dropdown_item);
        S_type_dropdown.setAdapter(S_type_adapter);

        Gender_dropdown = findViewById(R.id.gender);
        Gender_dropdown.setOnItemSelectedListener(this);
        ArrayAdapter<String> Gender_adapter = new ArrayAdapter<>(this, R.layout.branch_item, gender);
        Gender_adapter.setDropDownViewResource(R.layout.dropdown_item);
        Gender_dropdown.setAdapter(Gender_adapter);

        Register_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),Student_Details.class));
            }
        });

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        ((TextView) adapterView.getChildAt(0)).setTextColor(R.color.black);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}