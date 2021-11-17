package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateLocation extends AppCompatActivity {

    //initializing databases xml elements and variables
    Database database;

    Button updateLocation;

    EditText id_;
    EditText add_ress;
    EditText lat;
    EditText lon;

    int id_val;
    String address_val;
    double lat_val;
    double lon_val;

    //warning message if title is empty
    private void warning(String warning){ Toast.makeText(this,warning, Toast.LENGTH_SHORT).show(); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_location);

        database = new Database(getApplicationContext());
        updateLocation = (Button) findViewById(R.id.button6);
        id_ = (EditText) findViewById(R.id.ID);
        add_ress = (EditText) findViewById(R.id.ADDRESS);
        lat = (EditText) findViewById(R.id.LAT);
        lon = (EditText) findViewById(R.id.LON);

        //onClick get values of edit texts
        updateLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String test3 = id_.getText().toString();
                address_val = add_ress.getText().toString();
                String test1 =lat.getText().toString();
                String test2 =lon.getText().toString();

                //check if they are empty
                if(address_val.length() == 0 || test1.length() == 0 || test2.length() == 0 || test3.length() == 0){

                    warning("All fields must be filled in");
                }

                //update database
                else{
                    //if not convert to correct data type and add
                    id_val = Integer.parseInt(test3);
                    lat_val = Double.parseDouble(test1);
                    lon_val = Double.parseDouble(test2);



                    database.updateLocation(id_val, address_val, lat_val, lon_val);

                }

            }
        });

    }
}