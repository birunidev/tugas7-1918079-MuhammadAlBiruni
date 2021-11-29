package com.example.travellistapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_travel";
    private static final String tb_places = "tb_places";
    private static final String tb_place_id = "id";
    private static final String tb_place_title = "title";
    private static final String tb_place_location = "location";
    private static final String tb_place_image_url = "image_url";


    private static final String CREATE_TABLE_PLACES = "CREATE TABLE " +
            tb_places +"("
            + tb_place_id + " INTEGER PRIMARY KEY ,"
            + tb_place_title + " TEXT ,"
            + tb_place_location + " TEXT ,"
            + tb_place_image_url + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PLACES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void CreatePlace(Place data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_place_id, data.get_id());
        values.put(tb_place_title, data.get_title());
        values.put(tb_place_location, data.get_location());
        values.put(tb_place_image_url, data.get_url());
        db.insert(tb_places, null, values);
        db.close();
    }

    public List<Place> ReadPlace(){
        List<Place> listPlace = new ArrayList<Place>();
        String selectQuery = "SELECT * FROM " + tb_places;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Place data = new Place();
                data.set_id(cursor.getString(0));
                data.set_title(cursor.getString(1));
                data.set_location(cursor.getString(2));
                data.set_url(cursor.getString(3));
                listPlace.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listPlace;
    }

    public int UpdatePlace (Place data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_place_title, data.get_title());
        values.put(tb_place_location, data.get_location());
        values.put(tb_place_image_url, data.get_url());

        return db.update(tb_places, values, tb_place_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeletePlace(Place data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_places,tb_place_id + " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
