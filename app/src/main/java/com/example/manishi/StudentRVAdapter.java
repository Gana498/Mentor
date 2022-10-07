package com.example.manishi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
 class studentRVAdapter extends FirebaseRecyclerAdapter<
        StudentModal, studentRVAdapter.personsViewholder> {
    Context context;
    public studentRVAdapter(
            @NonNull FirebaseRecyclerOptions<StudentModal> options, Context context)
    {
        super(options);
        this.context = context;
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull personsViewholder holder,
                     int position, @NonNull StudentModal model)
    {
        holder.fullName.setText(":"+ model.getStudentFullName());
        holder.rollNumber.setText(":"+ model.getStudentRollNumber());
        holder.Branch.setText(":"+ model.getStudentBranch());
        holder.Year.setText(":"+ model.getStudentYear());
        holder.Section.setText(":"+ model.getStudentSection());
        holder.studentPhone.setText(":"+ model.getStudentPhone());
        holder.parentPhone.setText(":"+ model.getParentPhone());
        holder.PersonalEmail.setText(":"+ model.getStudentPersonalEmail());
        holder.studentAadhaar.setText(":"+ model.getStudentAadhaar());
        holder.fatherAadhaar.setText(":"+ model.getFatherAadhaar());
        holder.motherAadhaar.setText(":"+ model.getMotherAadhaar());
        holder.PresentAddress.setText(":"+ model.getStudentPresentAddress());
        holder.PermanentAddress.setText(":"+ model.getStudentPermanentAddress());
        if (model.getStudentPhone().length()!=10){
            holder.CallBtn.setVisibility(View.GONE);
        }

        holder.showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.linearLayout.getVisibility()!=View.VISIBLE){
                    holder.linearLayout.setVisibility(View.VISIBLE);
                    holder.ButtonLinearLayout.setVisibility(View.VISIBLE);
                }
                else {
                    holder.linearLayout.setVisibility(View.GONE);
                    holder.ButtonLinearLayout.setVisibility(View.GONE);
                }
            }
        });
        holder.CallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phone_intent = new Intent(Intent.ACTION_CALL);

                // Set data of Intent through Uri by parsing phone number
                phone_intent.setData(Uri.parse("tel:" + model.getStudentPhone()));
                view.getContext().startActivity(phone_intent);
            }
        });
        holder.WhatsappBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://wa.me/+91"+model.getStudentPhone());
                Intent whatsapp_intent = new Intent(Intent.ACTION_VIEW, uri);
                view.getContext().startActivity(whatsapp_intent);
            }
        });

    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_rv_item, parent, false);
        return new studentRVAdapter.personsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView fullName, rollNumber, Year, showMore, Branch, Section,  studentPhone, parentPhone, PersonalEmail,
                studentAadhaar, fatherAadhaar, motherAadhaar, PresentAddress, PermanentAddress;
        LinearLayout linearLayout, ButtonLinearLayout;
        Button CallBtn, WhatsappBtn;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);

            fullName = itemView.findViewById(R.id.idTVFullName);
            rollNumber = itemView.findViewById(R.id.idTVRollNumber);
            Branch =  itemView.findViewById(R.id.idTVBranch);
            Year =  itemView.findViewById(R.id.idTVYear);

            showMore = itemView.findViewById(R.id.idTVShowMoreDetails);
            linearLayout = itemView.findViewById(R.id.more_details);
            ButtonLinearLayout = itemView.findViewById(R.id.idButtonLinearLayout);
            Section =  itemView.findViewById(R.id.idTVSection);
            studentPhone =  itemView.findViewById(R.id.idTVStudentMobile);
            parentPhone =  itemView.findViewById(R.id.idTVParentMobile);
            PersonalEmail =  itemView.findViewById(R.id.idTVPersonalEmail);
            studentAadhaar =  itemView.findViewById(R.id.idTVStudentAadhaar);
            fatherAadhaar =  itemView.findViewById(R.id.idTVFatherAadhaar);
            motherAadhaar =  itemView.findViewById(R.id.idTVMotherAadhaar);
            PresentAddress =  itemView.findViewById(R.id.idTVPresentAddress);
            PermanentAddress =  itemView.findViewById(R.id.idTVPermanentAddress);
            CallBtn =  itemView.findViewById(R.id.idBtnCall);
            WhatsappBtn =  itemView.findViewById(R.id.idBtnWhatsapp);


        }
    }
}
