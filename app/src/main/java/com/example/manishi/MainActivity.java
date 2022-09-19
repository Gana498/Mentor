package com.example.manishi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    Button Login;
    ImageView rImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        Login = findViewById(R.id.login_button);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
            }
        });
        rImage = findViewById(R.id.rImage);
        FirebaseDatabase firebaseDatabase
                = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference
                = firebaseDatabase.getReference();
        DatabaseReference getImage
                = databaseReference.child("image");
        getImage.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(
                            @NonNull DataSnapshot dataSnapshot)
                    {
                        String link = dataSnapshot.getValue(
                                String.class);

                        Picasso.get().load(link).into(rImage);
                    }

                    @Override
                    public void onCancelled(
                            @NonNull DatabaseError databaseError)
                    {
                        Toast
                                .makeText(MainActivity.this,
                                        "Error Loading Image",
                                        Toast.LENGTH_SHORT)
                                .show();
                    }
                });


    }
}