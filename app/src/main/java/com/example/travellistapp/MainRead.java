package com.example.travellistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView pListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Place> ListPlace = new
            ArrayList<Place>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListPlace);
        pListView = (ListView) findViewById(R.id.list_places);
        pListView.setAdapter(adapter_off);
        pListView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        pListView.setClickable(true);
        ListPlace.clear();

        List<Place> place = db.ReadPlace();
        for (Place plc : place) {
            Place daftar = new Place();
            daftar.set_id(plc.get_id());
            daftar.set_title(plc.get_title());
            daftar.set_location(plc.get_location());
            daftar.set_url(plc.get_url());

            ListPlace.add(daftar);
            if ((ListPlace.isEmpty())) {
                Toast.makeText(MainRead.this, "No data found",
                        Toast.LENGTH_SHORT).show();
            } else {

            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = pListView.getItemAtPosition(i);
        Place detailPlace = (Place)o;
        String Sid = detailPlace.get_id();
        String STitle = detailPlace.get_title();
        String SLocation = detailPlace.get_location();
        String SUrl = detailPlace.get_url();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ititle", STitle);
        goUpdel.putExtra("Ilocation", SLocation);
        goUpdel.putExtra("Iurl", SUrl);

        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListPlace.clear();
        pListView.setAdapter(adapter_off);
        List<Place> places = db.ReadPlace();
        for (Place plc : places) {
            Place daftar = new Place();
            daftar.set_id(plc.get_id());
            daftar.set_title(plc.get_title());
            daftar.set_location(plc.get_location());
            daftar.set_url(plc.get_url());
            ListPlace.add(daftar);
            if ((ListPlace.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}