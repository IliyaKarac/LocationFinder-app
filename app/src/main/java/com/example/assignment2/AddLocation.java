package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddLocation extends AppCompatActivity {

    //initializing databases xml elements and variables
    Database database;

    Button addLocation;

    EditText id1;
    EditText add_ress;
    EditText lat;
    EditText lon;

    int id_val;
    String str_address;
    double lat_val;
    double lon_val;

    //warning message if title is empty
    private void warning(String warning){ Toast.makeText(this,warning, Toast.LENGTH_SHORT).show(); }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);
        database = new Database(getApplicationContext());

        addLocation = (Button) findViewById(R.id.button4);

        id1 = (EditText) findViewById(R.id.id_);
        add_ress = (EditText) findViewById(R.id.adressID);
        lat = (EditText) findViewById(R.id.latID);
        lon = (EditText) findViewById(R.id.lonID);

        //onClick get values of edit texts
        addLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String test3 =id1.getText().toString();
                str_address = add_ress.getText().toString();
                String test1 =lat.getText().toString();
                String test2 =lon.getText().toString();

                //check if they are empty
                if(str_address.length() == 0 || test1.length() == 0 || test2.length() == 0 || test3.length() == 0){

                    warning("All fields must be filled in");
                }

                //upload to database
                else {
                    //if not convert to correct data type and add
                    id_val = Integer.parseInt(test3);
                    lat_val = Double.parseDouble(lat.getText().toString());
                    lon_val = Double.parseDouble(lon.getText().toString());




                    //database.Upload(object);
                    database.Upload(id_val,str_address,lat_val,lon_val);
                }
            }
        });
    }






}