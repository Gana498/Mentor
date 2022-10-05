package com.example.manishi;

import static com.example.manishi.R.id.idEdtStudentRollNumber;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddStudentActivity extends AppCompatActivity {
    private Button addStudentBtn;
    private TextInputEditText studentRollNumberEdt,studentFullNameEdt, studentBranchEdt, studentSectionEdt, studentYearEdt, studentPhoneEdt, parentPhoneEdt,studentPersonalEmailEdt,
            studentAadhaarEdt, fatherAadhaarEdt, motherAadhaarEdt, studentPresentAddressEdt, studentPermanentAddressEdt;
    FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String studentID;
    private Boolean flagA;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        flagA = false;
        addStudentBtn = findViewById(R.id.idBtnAddStudent);
        studentRollNumberEdt = findViewById(idEdtStudentRollNumber);
        studentFullNameEdt = findViewById(R.id.idEdtStudentFullName);
        studentBranchEdt = findViewById(R.id.idEdtStudentBranch);
        studentSectionEdt = findViewById(R.id.idEdtStudentSection);
        studentYearEdt = findViewById(R.id.idEdtStudentYear);
        studentPhoneEdt = findViewById(R.id.idEdtStudentPhoneNumber);
        parentPhoneEdt = findViewById(R.id.idEdtParentPhoneNumber);
        studentPersonalEmailEdt = findViewById(R.id.idEdtPersonalEmail);
        studentAadhaarEdt = findViewById(R.id.idEdtStudentAadhaarNumber);
        fatherAadhaarEdt = findViewById(R.id.idEdtFatherAadhaarNumber);
        motherAadhaarEdt = findViewById(R.id.idEdtMotherAadhaarNumber);
        studentPresentAddressEdt = findViewById(R.id.idEdtEnterPresentAddress);
        studentPermanentAddressEdt = findViewById(R.id.idEdtEnterPermanentAddress);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Students");
        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagA = true;
                String studentRollNumber = studentRollNumberEdt.getText().toString().toUpperCase();
                String studentFullName = studentFullNameEdt.getText().toString().toUpperCase();
                String studentBranch = studentBranchEdt.getText().toString().toUpperCase();
                String studentSection = studentSectionEdt.getText().toString().toUpperCase();
                String studentYear = studentYearEdt.getText().toString();
                String studentPhone = studentPhoneEdt.getText().toString();
                String parentPhone = parentPhoneEdt.getText().toString();
                String studentPersonalEmail = studentPersonalEmailEdt.getText().toString();
                String studentAadhaar = studentAadhaarEdt.getText().toString();
                String fatherAadhaar = fatherAadhaarEdt.getText().toString();
                String motherAadhaar = motherAadhaarEdt.getText().toString();
                String studentPresentAddress = studentPresentAddressEdt.getText().toString();
                String studentPermanentAddress = studentPermanentAddressEdt.getText().toString();
                String studentID = studentRollNumber;

                StudentRVModal studentRVModal = new StudentRVModal(studentID, studentRollNumber, studentFullName, studentBranch, studentSection, studentYear, studentPhone, parentPhone, studentPersonalEmail, studentAadhaar,fatherAadhaar, motherAadhaar, studentPresentAddress, studentPermanentAddress);
                databaseReference.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChild(studentID) && flagA){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Toast.makeText(AddStudentActivity.this, "Student Existed..", Toast.LENGTH_SHORT).show();
                            finish();
                            flagA = false;
                        }
                        else if (flagA){
                            databaseReference.child(studentID).setValue(studentRVModal);
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Toast.makeText(AddStudentActivity.this, "Student Added..", Toast.LENGTH_SHORT).show();
                            finish();
                            flagA = false;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(AddStudentActivity.this, "Fail to add Student..", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}