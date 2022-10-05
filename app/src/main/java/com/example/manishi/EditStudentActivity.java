package com.example.manishi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class EditStudentActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private EditText studentRollNumberEdt, studentFullNameEdt, studentBranchEdt, studentSectionEdt, studentYearEdt, studentPhoneEdt,
            parentPhoneEdt,studentPersonalEmailEdt, studentAadhaarEdt, fatherAadhaarEdt, motherAadhaarEdt,
            studentPresentAddressEdt, studentPermanentAddressEdt;
    Button getStudentBtn,updateStudentBtn, deleteStudentBtn;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        firebaseDatabase = FirebaseDatabase.getInstance();
        studentRollNumberEdt = findViewById(R.id.idEdtStudentRollNumber);
        getStudentBtn = findViewById(R.id.idBtnGetStudentData);
        updateStudentBtn =findViewById(R.id.idBtnUpdateStudent);
        deleteStudentBtn = findViewById(R.id.idBtnDeleteStudent);
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
        getStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentID = studentRollNumberEdt.getText().toString().trim().toUpperCase();
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Students");
                Query query = databaseReference.orderByChild("studentRollNumber").equalTo(studentID);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.exists()){
                            for(DataSnapshot ds : dataSnapshot.getChildren()){
                                studentFullNameEdt.setText((ds.child("studentFullName").getValue().toString().toUpperCase()));
                                studentBranchEdt.setText((ds.child("studentBranch").getValue().toString().toUpperCase()));
                                studentSectionEdt.setText((ds.child("studentSection").getValue().toString().toUpperCase()));
                                studentYearEdt.setText((ds.child("studentYear").getValue().toString().toUpperCase()));
                                studentPhoneEdt.setText((ds.child("studentPhone").getValue().toString()));
                                parentPhoneEdt.setText((ds.child("parentPhone").getValue().toString()));
                                studentPersonalEmailEdt.setText((ds.child("studentPersonalEmail").getValue().toString()));
                                studentAadhaarEdt.setText((ds.child("studentAadhaar").getValue().toString()));
                                fatherAadhaarEdt.setText((ds.child("fatherAadhaar").getValue().toString()));
                                motherAadhaarEdt.setText((ds.child("motherAadhaar").getValue().toString()));
                                studentPresentAddressEdt.setText((ds.child("studentPresentAddress").getValue().toString()));
                                studentPermanentAddressEdt.setText((ds.child("studentPermanentAddress").getValue().toString()));
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Display",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        updateStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                        databaseReference.child(studentID).setValue(studentRVModal).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                                Toast.makeText(EditStudentActivity.this, "Student Updated..", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EditStudentActivity.this, "Fail to Update Student..", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        deleteStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String StudentID = studentRollNumberEdt.getText().toString().toUpperCase().trim();
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Students").child(StudentID);
                databaseReference.removeValue();
                // displaying a toast message on below line.
                // opening a main activity on below line.
                startActivity(new Intent(EditStudentActivity.this, MainActivity.class));
                Toast.makeText(getApplicationContext(), "Student Deleted..", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
