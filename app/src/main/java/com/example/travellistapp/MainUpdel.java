package com.example.travellistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUpdel extends AppCompatActivity {

    private MyDatabase db;
    private String Sid, STitle, SLocation, SUrl;
    private EditText ETitle, ELocation, EUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        STitle = i.getStringExtra("Ititle");
        SLocation = i.getStringExtra("Ilocation");
        SUrl = i.getStringExtra("Iurl");
        ETitle = (EditText) findViewById(R.id.edit_title);
        ELocation = (EditText) findViewById(R.id.edit_location);
        EUrl = (EditText) findViewById(R.id.edit_url);

        ETitle.setText(STitle);
        ELocation.setText(SLocation);
        EUrl.setText(SUrl);

        Button btnUpdate = (Button) findViewById(R.id.edit_btn);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STitle = String.valueOf(ETitle.getText());
                SLocation = String.valueOf(ELocation.getText());
                if (STitle.equals("")){
                    ETitle.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama tempat",
                            Toast.LENGTH_SHORT).show();
                } else if (SLocation.equals("")){
                    ELocation.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi lokasi",
                            Toast.LENGTH_SHORT).show();
                } else if (SUrl.equals("")){
                    ELocation.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi url map",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdatePlace(new Place(Sid, STitle,
                            SLocation,SUrl));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.del_btn);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePlace(new Place(Sid, STitle,
                        SLocation, SUrl));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}