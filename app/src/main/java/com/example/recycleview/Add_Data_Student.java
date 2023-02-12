package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Data_Student extends AppCompatActivity {

    Button btnAdd;
    TextView manzil, sabaq, sabqi, date;
    TextView name;

    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_student);

        manzil = findViewById(R.id.editTextTextPersonName);
        sabaq = findViewById(R.id.editTextTextPersonName2);
        sabqi = findViewById(R.id.editTextTextPersonName3);
        date = findViewById(R.id.editTextTextPersonName4);

        name = findViewById(R.id.studentNameAdd);


        btnAdd = findViewById(R.id.button);

        db = new DBHandler(this);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("Name"));


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast = new Toast(Add_Data_Student.this);
                toast.setText("Record Added for " + name.getText().toString());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();

                int id = intent.getIntExtra("id", 0);
                Log.d("ID: ", Integer.toString(id));

                Student newStudent = new Student(name.getText().toString(),id);

                db.AddData(newStudent, date.getText().toString(), manzil.getText().toString(),
                                        sabaq.getText().toString(), sabqi.getText().toString());

                finish();
            }
        });
    }
}