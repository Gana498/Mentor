package com.example.manishi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StudentRVAdapter extends RecyclerView.Adapter<StudentRVAdapter.ViewHolder> {
    // creating variables for our list, context, interface and position.
    private ArrayList<StudentRVModal> studentRVModalArrayList;
    private Context context;
    private StudentClickInterface studentClickInterface;
    int lastPos = -1;

    // creating a constructor.
    public StudentRVAdapter(ArrayList<StudentRVModal> studentRVModalArrayList, Context context) {
        this.studentRVModalArrayList = studentRVModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout file on below line.
        View view = LayoutInflater.from(context).inflate(R.layout.student_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentRVAdapter.ViewHolder holder, int position) {
        // setting data to our recycler view item on below line.
        StudentRVModal studentRVModal = studentRVModalArrayList.get(position);
        holder.studentNameTV.setText(studentRVModal.getStudentFullName());
        holder.studentNumberIV.setText("Rs. " + studentRVModal.getStudentRollNumber());
        // adding animation to recycler view item on below line.

    }

    @Override
    public int getItemCount() {
        return studentRVModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // creating variable for our image view and text view on below line.
        private TextView studentNameTV, studentNumberIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing all our variables on below line.
            studentNameTV = itemView.findViewById(R.id.show_name);
            studentNumberIV = itemView.findViewById(R.id.show_roll_number);

        }
    }

    // creating a interface for on click
    public interface StudentClickInterface {
        void onStudentClick(int position);
    }
}
