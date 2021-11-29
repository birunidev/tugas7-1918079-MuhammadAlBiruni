package com.example.travellistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView mainImage = findViewById(R.id.main_image);
        setContentView(R.layout.activity_main);
    }

    public void create(View view){
        Intent a = new
                Intent(MainActivity.this,MainCreate.class);
        startActivity(a);
    }
    public void read(View view){
        Intent b = new Intent(MainActivity.this,MainRead.class);
        startActivity(b);
    }
}