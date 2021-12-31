package com.example.string_up;

import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] Stypes = { "Yonex BG-65", "Yonex BG-65 Titanium", "Yonex Aerosonic", "Yonex Aerobyte", "LINING N0.1","LINING N0.7"};
    String[] Stension = { "21", "22", "23", "24", "25","26","27", "28", "29", "30", "31","32"};
    String[] SColours = { "Blue", "Black", "White", "SkyBlue", "Purple","Lavender","FlouroScent-Green"};
//    String[] Rbrand = { "Yonex", "Lining", "Ashaway", "Maxxbolt", "FZ-Forza","Victor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner Stype = (Spinner) findViewById(R.id.spinnerST);
        Spinner STension = (Spinner) findViewById(R.id.spinnerSTT);
        Spinner SColor = (Spinner) findViewById(R.id.spinnerSC);
//        Spinner Rbrand = (Spinner) findViewById(R.id.spinnerRB);

        // Spinner click listener
        Stype.setOnItemSelectedListener(this);
        STension.setOnItemSelectedListener(this);
        SColor.setOnItemSelectedListener(this);
//        Rbrand.setOnItemSelectedListener(this);

        // Spinner Drop down elements


        // Creating adapter for spinner
        ArrayAdapter<String> StringType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Stypes);
        ArrayAdapter<String> StringTension = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Stension);
        ArrayAdapter<String> StringColor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SColours);
//        ArrayAdapter<String> RacquetBrand = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (List<String>) Rbrand);
        // Drop down layout style - list view with radio button
        StringType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        StringTension.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        StringColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        RacquetBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        Stype.setAdapter(StringType);
        STension.setAdapter(StringTension);
        SColor.setAdapter(StringColor);
//        Rbrand.setAdapter(RacquetBrand);
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    public void openBRacquetDetails(View view){
        Intent i= new Intent(this,RacquetCart.class);
        startActivity(i);
    }

}
