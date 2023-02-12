package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewData extends AppCompatActivity {

    TextView name;
    ListView list;
    Student student;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        Intent intent = getIntent();

        name = findViewById(R.id.textView);


        name.setText(intent.getStringExtra("name"));

        list = findViewById(R.id.listData);
        db = new DBHandler(this);

        student = new Student(intent.getStringExtra("name"), intent.getIntExtra("id", 0));

        student = db.getData(student);

        ArrayList<String> toDisplay = new ArrayList<>();
        for(int i = 0; i < student.getData().size(); i++) {
            toDisplay.add((student.getData().get(i).toString()));
            Log.d("SIZE: ", toDisplay.get(i));
        }

        ArrayAdapter<String> adp = new ArrayAdapter<String>(ViewData.this, android.R.layout.simple_list_item_1, toDisplay);

        list.setAdapter(adp);
        adp.notifyDataSetChanged();
    }
}