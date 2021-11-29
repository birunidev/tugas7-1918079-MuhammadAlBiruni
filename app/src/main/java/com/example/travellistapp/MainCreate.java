package com.example.travellistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {

    private MyDatabase db;
    private EditText ETitle, ELocation, EUrl;
    private String STitle, SLocation, SUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        ETitle = (EditText) findViewById(R.id.create_title);
        ELocation = (EditText) findViewById(R.id.create_location);
        EUrl = (EditText) findViewById(R.id.create_url);

        Button btnCreate = (Button)
                findViewById(R.id.create_btn);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STitle = String.valueOf(ETitle.getText());
                SLocation = String.valueOf(ELocation.getText());
                SUrl = String.valueOf(EUrl.getText());

                if (STitle.equals("")){
                    ETitle.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama tempat",
                            Toast.LENGTH_SHORT).show();
                }
                else if (SLocation.equals("")) {
                    ELocation.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi lokasi",
                            Toast.LENGTH_SHORT).show();
                }else if(SUrl.equals("")){
                    EUrl.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi url gambar", Toast.LENGTH_SHORT).show();
                }
                else {
                    ETitle.setText("");
                    ELocation.setText("");
                    EUrl.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreatePlace(new Place(null, STitle,
                            SLocation, SUrl));

                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}