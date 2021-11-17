package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.*;

public class MainActivity extends AppCompatActivity {


    //default locations
    //the locations could be read from a file but this way is easier for tester to add them

    //Hagia Sophia
    double la1 = 41.00796827755169;
    double lo1 = 28.981333921857733;

    //The Guggenheim
    double la2 = 44.325040;
    double lo2 = -74.175620;

    //Taj Mahal
    double la3 = 27.175014;
    double lo3 = 78.042152;

    //Dancing House
    double la4 = 50.839748;
    double lo4 = -0.317850;

    //Château de Chenonceau
    double la5 = 47.330891;
    double lo5 = 1.065580;

    //Niterói Contemporary Art Museum
    double la6 = -19.510091;
    double lo6 = -42.204798;

    //Pyramids of Giza
    double la7 = 29.99657;
    double lo7 = 31.137863;

    //Acropolis of Athens
    double la8 = 37.975706;
    double lo8 = 23.727653;

    //Centre Pompidou
    double la9 = 48.865799;
    double lo9 = 2.351006;

    //The Gateway Arch
    double la10 = 29.99657;
    double lo10 = -90.187523;

    //Musée d’Orsay
    double la11 = 48.861733;
    double lo11 = 2.3256;

    //The Gherkin
    double la12 = 51.519169;
    double lo12 = -0.081093;

    //Metropolitan Cathedral of Brasília
    double la13 = -14.119529;
    double lo13 = -51.857664;

    //Mosque-Cathedral of Córdoba
    double la14 = 37.879464;
    double lo14 = -4.7793010;

    //Westminster Abbey
    double la15 = 51.496046;
    double lo15 = -0.1399763;

    //Dresden Frauenkirche
    double la16 = 51.051919;
    double lo16 = 13.741527;

    //Château Frontenac
    double la17 = 46.811993;
    double lo17 = -71.20523;

    //The Colosseum
    double la18 = 41.890321;
    double lo18 = 12.492230;

    //One World Trade Center
    double la19 = 40.712897;
    double lo19 = -74.01338;

    //The Lotus Temple
    double la20 = 28.553522;
    double lo20 = 77.258829;

    //St. Basil’s Cathedral
    double la21 = 55.752535;
    double lo21 = 37.623112;

    //Ontario tech U
    double la22 = 43.946783317193756;
    double lo22 = -78.89442687177309;

    //Casa Milà
    double la23 = 41.395368;
    double lo23 = 2.1618702;

    //The White House
    double la24 = 38.897709;
    double lo24 = -77.036529;

    //Forbidden City
    double la25 = 39.916955;
    double lo25 = 116.39073;

    //Sagrada Família
    double la26 = 41.403750;
    double lo26 = 2.1743343;

    //Lincoln Center
    double la27 = 40.772590;
    double lo27 = -73.98346;

    //The Shard
    double la28 = 51.504606;
    double lo28 = -0.086478;

    //Le Mont-Saint-Michel
    double la29 = 48.621034;
    double lo29 = -1.532717;

    //Bran Castle
    double la30 = 45.514969;
    double lo30 = 25.367152;

    //Angkor Wat
    double la31 = 13.411101;
    double lo31 = 103.86546;

    //Sultan Ahmed Mosque
    double la32 = 41.005457;
    double lo32 = 28.976812;

    //Konark Sun Tower
    double la33 = 19.887699;
    double lo33 = 86.094555;

    //Chrysler Building
    double la34 = 40.751641;
    double lo34 = -73.97550;

    //Sacré-Coeur
    double la35 = 40.754720;
    double lo35 = -74.17857;

    //Potala Palace
    double la36 = 29.655428;
    double lo36 = 91.118589;

    //Musée du Louvre
    double la37 = 48.86070283;
    double lo37 = 2.337665455;

    //Sydney Opera House
    double la38 = -33.8567784;
    double lo38 = 151.2153001;

    //Guggenheim Museum
    double la39 = 43.26893575;
    double lo39 = -2.93411249;

    //Fallingwater
    double la40 = 39.90636206;
    double lo40 = -79.4678091;

    //The Pantheon
    double la41 = 41.898570850;
    double lo41 = 12.476872897;

    //Space Needle
    double la42 = 47.620524382;
    double lo42 = -122.3492881;

    //Villa Savoye
    double la43 = 48.924537269;
    double lo43 = 2.0282589402;

    //House of Parliament
    double la44 = 51.500606430;
    double lo44 = -0.124209152;

    //Burj Khalifa
    double la45 = 25.197235815;
    double lo45 = 55.274387126;

    //Leaning Tower of Pisa
    double la46 = 43.722951979;
    double lo46 = 10.39661845;

    //São Paulo Museum of Art
    double la47 = -23.56163034;
    double lo47 = -46.65594627;

    //The Flatiron Building
    double la48 = 40.741158025;
    double lo48 = -73.98966641;

    //The Sistine Chapel
    double la49 = 41.903235844;
    double lo49 = 12.454469892;

    //Eiffel Tower
    double la50 = 48.858490077;
    double lo50 = 2.2943525518;

    //other objects initialized

    Button add;
    Button delete;
    Button update;

    Button coordSearch;
    EditText in_address;
    TextView la;
    TextView lo;

    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(this);

        //UNCOMMENT THIS LINE IF YOU WISH TO ADD THE 50 DEFAULT LOCATION
        populate_db();

        //all buttons and text fields
        add = (Button) findViewById(R.id.button);
        delete = (Button) findViewById(R.id.button2);
        update = (Button) findViewById(R.id.button3);

        coordSearch = (Button) findViewById(R.id.button7);
        in_address = (EditText) findViewById(R.id.address_val);
        la = (TextView) findViewById(R.id.display_lat);
        lo = (TextView) findViewById(R.id.display_lon);


        //onClick look at the inputed address and find its latitude and longitude values then display them
        coordSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lat = database.getLat(in_address.getText().toString());
                String lon = database.getLon(in_address.getText().toString());
                //double lon = database.getLon(in_address.getText());
                la.setText(lat);
                lo.setText(lon);
            }
        });

        //open a different activity respective to the button name
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openadd();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendelete();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openupdate();
            }
        });




    }




    //3 methods called to change activity
    public void openadd(){
        Intent toAdd = new Intent(this,AddLocation.class);
        startActivity(toAdd);
    }
    public void opendelete(){
        Intent toDelete = new Intent(this,DeleteLocation.class);
        startActivity(toDelete);
    }
    public void openupdate(){
        Intent toUpdate = new Intent(this,UpdateLocation.class);
        startActivity(toUpdate);
    }


    //function that populates first 50 locations in db
    public void populate_db(){
        Geocoder a = new Geocoder(MainActivity.this,Locale.getDefault());
        database.Upload(1,getAddress(la1,la1),la1,lo1);
        database.Upload(2,getAddress(la2,la2),la2,lo2);
        database.Upload(3,getAddress(la3,la3),la3,lo3);
        database.Upload(4,getAddress(la4,la4),la4,lo4);
        database.Upload(5,getAddress(la5,la5),la5,lo5);
        database.Upload(6,getAddress(la6,la6),la6,lo6);
        database.Upload(7,getAddress(la7,la7),la7,lo7);
        database.Upload(8,getAddress(la8,la8),la8,lo8);
        database.Upload(9,getAddress(la9,la9),la9,lo9);
        database.Upload(10,getAddress(la10,la10),la10,lo10);

        database.Upload(11,getAddress(la11,la11),la11,lo11);
        database.Upload(12,getAddress(la12,la12),la12,lo12);
        database.Upload(13,getAddress(la13,la13),la13,lo13);
        database.Upload(14,getAddress(la14,la14),la14,lo14);
        database.Upload(15,getAddress(la15,la15),la15,lo15);
        database.Upload(16,getAddress(la16,la16),la16,lo16);
        database.Upload(17,getAddress(la17,la17),la17,lo17);
        database.Upload(18,getAddress(la18,la18),la18,lo18);
        database.Upload(19,getAddress(la19,la19),la19,lo19);
        database.Upload(20,getAddress(la20,la20),la20,lo20);

        database.Upload(21,getAddress(la21,la21),la21,lo21);
        database.Upload(22,getAddress(la22,la22),la22,lo22);
        database.Upload(23,getAddress(la23,la23),la23,lo23);
        database.Upload(24,getAddress(la24,la24),la24,lo24);
        database.Upload(25,getAddress(la25,la25),la25,lo25);
        database.Upload(26,getAddress(la26,la26),la26,lo26);
        database.Upload(27,getAddress(la27,la27),la27,lo27);
        database.Upload(28,getAddress(la28,la28),la28,lo28);
        database.Upload(29,getAddress(la29,la29),la29,lo29);
        database.Upload(30,getAddress(la30,la30),la30,lo30);

        database.Upload(31,getAddress(la31,la31),la31,lo31);
        database.Upload(32,getAddress(la32,la32),la32,lo32);
        database.Upload(33,getAddress(la33,la33),la33,lo33);
        database.Upload(34,getAddress(la34,la34),la34,lo34);
        database.Upload(35,getAddress(la35,la35),la35,lo35);
        database.Upload(36,getAddress(la36,la36),la36,lo36);
        database.Upload(37,getAddress(la37,la37),la37,lo37);
        database.Upload(38,getAddress(la38,la38),la38,lo38);
        database.Upload(39,getAddress(la39,la39),la39,lo39);
        database.Upload(40,getAddress(la40,la40),la40,lo40);

        database.Upload(41,getAddress(la41,la41),la41,lo41);
        database.Upload(42,getAddress(la42,la42),la42,lo42);
        database.Upload(43,getAddress(la43,la43),la43,lo43);
        database.Upload(44,getAddress(la44,la44),la44,lo44);
        database.Upload(45,getAddress(la45,la45),la45,lo45);
        database.Upload(46,getAddress(la46,la46),la46,lo46);
        database.Upload(47,getAddress(la47,la47),la47,lo47);
        database.Upload(48,getAddress(la48,la48),la48,lo48);
        database.Upload(49,getAddress(la49,la49),la49,lo49);
        database.Upload(50,getAddress(la50,la50),la50,lo50);



    }


    //function takes in 2 doubles a latitude and longitude uses geocoder to obtain an address with these locations
    public String getAddress(double la, double lo){
        String address = "error in address";
        Geocoder a;
        List<Address> tmpList;
        a = new Geocoder(this,Locale.getDefault());

        try {
            tmpList = a.getFromLocation(la,lo,1);
            address = tmpList.get(0).getAddressLine(0);

            return address;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return address;
    }


}