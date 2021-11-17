package com.example.assignment2;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.sql.ResultSet;

public class Database extends SQLiteOpenHelper {

    private static final String TAG = "Database";
    private static final String Table = "locs_111111";
    private static final String COL1 = "ID";
    private static final String COL2 = "address";
    private static final String COL3 = "latitude";
    private static final String COL4 = "longitude";



    //make database
    public Database(@Nullable Context context) {

        super(context, Table,null,21);
    }

    //obtain all data from database
    public Cursor display_notes(){
        SQLiteDatabase database = this.getWritableDatabase();
        //query for all data from table
        Cursor all_data = database.rawQuery("select * from i_table;", null);
        return all_data;
    }

    //-----adding data to database

    public void Upload(int id, String address, double lat, double lon){
        //get title subtitle and note
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put("ID", id);
        values.put("address", address);
        values.put("latitude", lat);
        values.put("longitude", lon);

        //add values to table and display
        long num_notes = database.insert("i_table",null,values);

        //log the amount of notes or error code
        Log.e(TAG,"amount of locations:" + num_notes);

    }



    //delete old database, create a new version of the database
    @Override
    public void onUpgrade(SQLiteDatabase data, int oldVersion, int newVersion) {
        data.execSQL("DROP TABLE IF EXISTS i_table");
        onCreate(data);

    }


    //make the database if there is no previous instance
    @Override
    public void onCreate(SQLiteDatabase data) {
        data.execSQL("create table if not exists i_table(ID INTEGER, address TEXT, latitude REAL, longitude REAL)");

    }

    //delete function requires id of location to be deleted
    public void deleteLocation(int id){
        SQLiteDatabase data = this.getWritableDatabase();

        //query deletes all rows with matching id
        String query = "DELETE FROM " + "i_table" + " WHERE "
                + COL1 + " = " + id;
        Log.d(TAG, "deleted" + query);

        data.execSQL(query);
    }

    public void updateLocation(int id, String address, double lat, double lon){
        SQLiteDatabase data = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //putting values
        values.put("ID", id);
        values.put("address", address);
        values.put("latitude", lat);
        values.put("longitude", lon);

        //using update method from the database helper to update
        data.update("i_table", values, "ID = ?", new String[]{Integer.toString(id)});
    }

    //these 2 get functions return latitude and longitude abd take string for input
    public String getLat(String address){
        SQLiteDatabase data = this.getWritableDatabase();
        String str_val = "not_found";

        //raw query find everything
        String query = "SELECT * FROM i_table";


        Cursor cursor = data.rawQuery(query, null);

        //find the latitude where address = the input
        while (cursor.moveToNext()){
             if (cursor.getString(1).equals(address)){
                 str_val = cursor.getString(2);
             }
        }


        return str_val;
    }

    public String getLon(String address){
        SQLiteDatabase data = this.getWritableDatabase();
        String str_val = "not_found";

        String query = "SELECT * FROM i_table";


        Cursor cursor = data.rawQuery(query, null);

        while (cursor.moveToNext()){
            if (cursor.getString(1).equals(address)){
                str_val = cursor.getString(3);
            }
        }


        return str_val;
    }







}

