package com.example.recycleview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Student> studentList = new ArrayList<Student>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    FloatingActionButton add;
    TextView editTextPIN;

    Button github;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.floatingActionButton);
        github= findViewById((R.id.btnGit));
        DBHandler db = new DBHandler(this);

        studentList.addAll(db.getStudents());

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new RVAdapter(studentList);
        recyclerView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("WELCOME");
                builder.setMessage("Enter Name: ");
                View view2 = getLayoutInflater().inflate(R.layout.activity_dialogue_layout, null);
                builder.setView(view2);
                builder.setCancelable(true);
                builder.setPositiveButton("ADD", (dialog, which) -> {
                    //I want the String pin to be toasted on clicking the "YES" positive button
                    editTextPIN = view2.findViewById(R.id.editTextTextPersonName5);
                    String pin = editTextPIN.getText().toString();

                    Toast.makeText(MainActivity.this, pin, Toast.LENGTH_SHORT).show();

                    db.addStudent(pin);
                    studentList.clear();
                    studentList.addAll(db.getStudents());
                    adapter.notifyDataSetChanged();

                }).setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String url = "https://github.com/umarfaizan-dev/sabqi";
                Uri webpage = Uri.parse(url);

                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });
    }
}