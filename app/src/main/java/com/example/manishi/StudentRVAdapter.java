package com.example.manishi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentRVAdapter extends RecyclerView.Adapter<StudentRVAdapter.ViewHolder> {
    // creating variables for our list, context, interface and position.
    private ArrayList<StudentRVModal> studentRVModalArrayList;
    private Context context;

    // creating a constructor.
    public StudentRVAdapter( Context context, ArrayList<StudentRVModal> studentRVModalArrayList) {
        this.studentRVModalArrayList = studentRVModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout file on below line.
        View view = LayoutInflater.from(context).inflate(R.layout.student_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StudentRVAdapter.ViewHolder holder, int position) {
        // setting data to our recycler view item on below line.
        StudentRVModal studentRVModal = studentRVModalArrayList.get(position);
        holder.studentNameTV.setText(":"+studentRVModal.getStudentFullName());
        holder.studentNumberIV.setText(":"+ studentRVModal.getStudentRollNumber());
        // adding animation to recycler view item on below line.

    }

    @Override
    public int getItemCount() {
        return studentRVModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // creating variable for our image view and text view on below line.
        private  TextView studentNameTV;
        private  TextView studentNumberIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing all our variables on below line.
            studentNameTV = itemView.findViewById(R.id.show_name);
            studentNumberIV = itemView.findViewById(R.id.show_roll_number);

        }
    }
}
