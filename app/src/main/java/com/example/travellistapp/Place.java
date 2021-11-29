package com.example.travellistapp;

public class Place {
    private String _id, _title, _location, _url;

    public Place(String id, String title, String location, String url){
        this._id = id;
        this._title = title;
        this._location = location;
        this._url = url;
    }

    public Place(){}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_location() {
        return _location;
    }

    public void set_location(String _location) {
        this._location = _location;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }
}

