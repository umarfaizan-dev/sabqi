package com.example.recycleview;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyVH> {
    List<Student> studentData;

    public RVAdapter(List<Student> studentData) {
        this.studentData = studentData;
    }


    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_single_student_row, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data = studentData.get(position);
        holder.studentName.setText(holder.data.getName());
    }

    @Override
    public int getItemCount() {
        return studentData.size();
    }

    public class MyVH extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageStudent;
        TextView studentName;
        ImageButton viewBtn, addBtn, deleteBtn;
        Student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);

            studentName = itemView.findViewById(R.id.studentName);
            viewBtn = itemView.findViewById(R.id.viewBtn);
            addBtn = itemView.findViewById(R.id.addBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);

            viewBtn.setOnClickListener(this);
            addBtn.setOnClickListener(this);
            deleteBtn.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.addBtn:
                    Intent intent = new Intent(view.getContext(), Add_Data_Student.class);

                    intent.putExtra("Name", studentName.getText().toString());
                    intent.putExtra("id", data.getId());

                    view.getContext().startActivity(intent);
                    break;

                case R.id.viewBtn:
                    Intent intent1 = new Intent(view.getContext(), ViewData.class);

                    intent1.putExtra("name", studentName.getText().toString());
                    intent1.putExtra("id", data.getId());

                    view.getContext().startActivity(intent1);
                    break;

                case R.id.deleteBtn:

                    studentData.remove(data.getId());
                    notifyDataSetChanged();

                    Intent intent2 = new Intent(view.getContext(), loadDel.class);

                    intent2.putExtra("id", data.getId());
                    view.getContext().startActivity(intent2);

                    break;
            }
        }
    }
}
