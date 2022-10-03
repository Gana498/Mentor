package com.example.manishi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private StudentRVAdapter studentRVAdapter;
    private ArrayList<StudentRVModal> studentRVModalArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creating variables for fab, firebase database,
        // progress bar, list, adapter,firebase auth,
        // recycler view and relative layout.
        FloatingActionButton addStudentFAB = findViewById(R.id.idFABAddCourse);
         //initializing all our variables.
        RecyclerView studentRV = findViewById(R.id.idRVStudents);
        studentRV.setHasFixedSize(true);
        studentRV.setLayoutManager(new LinearLayoutManager(this));
        Objects.requireNonNull(studentRV.getLayoutManager()).setMeasurementCacheEnabled(false);
        studentRVModalArrayList = new ArrayList<>();
        studentRVAdapter = new StudentRVAdapter(this, studentRVModalArrayList);
        studentRV.setAdapter(studentRVAdapter);
        firebaseDatabase = FirebaseDatabase.getInstance();

        // on below line we are getting database reference.
        databaseReference = firebaseDatabase.getReference("Students");
        // on below line adding a click listener for our floating action button.
        addStudentFAB.setOnClickListener(v -> {
            // opening a new activity for adding a student.
            Intent i = new Intent(MainActivity.this, AddStudentActivity.class);
            startActivity(i);
        });
//        // on below line initializing our adapter class.

        // setting layout malinger to recycler view on below line.
        studentRV.setLayoutManager(new LinearLayoutManager(this));
        // setting adapter to recycler view on below line.

        // on below line calling a method to fetch students from database.
    }
    @Override
    protected void onStart() {

        super.onStart();
        Query query = FirebaseDatabase.getInstance().getReference("Students");
        query.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                studentRVModalArrayList.clear();
                if(dataSnapshot.exists()){
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        StudentRVModal studentRVModal = snapshot.getValue(StudentRVModal.class);
                        studentRVModalArrayList.add(studentRVModal);
                    }
                    studentRVAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}
