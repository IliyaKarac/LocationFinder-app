package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteLocation extends AppCompatActivity {

    Database database;

    //button and edit text
    Button deleteLocation;
    EditText location_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_location);

        //initialize database
        database = new Database(getApplicationContext());
        //define input
        deleteLocation = (Button) findViewById(R.id.button5);
        location_id = (EditText) findViewById(R.id.loc_id);

        //onClick call function
        deleteLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(location_id.getText().toString());
                database.deleteLocation(id);

            }
        });

    }
}