package com.example.travellistapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Place> Place;

    public CustomListAdapter(Activity activity, List<Place> Place ){
        this.activity = activity;
        this.Place = Place;
    }

    @Override
    public int getCount(){
        return Place.size();
    }

    @Override
    public Object getItem(int location){
        return Place.get(location);
    }

    public long getItemId(int position){
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_list, null);
        }

        TextView placeTitle = (TextView) convertView.findViewById(R.id.place_title);
        TextView location = (TextView) convertView.findViewById(R.id.location);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.locationImage);

        Place p = Place.get(position);
        placeTitle.setText("Nama Tempat:" + p.get_title());
        location.setText("Lokasi: " + p.get_location());

        return convertView;
    }
}
