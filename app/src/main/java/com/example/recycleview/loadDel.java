package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class loadDel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_del);

        Intent intent = getIntent();

        DBHandler db = new DBHandler(this);

        int id = intent.getIntExtra("id",0);

        db.deleteStudent(id);

        finish();
    }
}