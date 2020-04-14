package com.haroon.mybirthday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLocate;
    private Button btnContact;
    private Button btnDonate;
    private Button btnSchedule;

    //TODO: set all titles to @styles/title theme

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Initialising all the buttons and linking them up with layout file
        btnLocate = findViewById(R.id.btnLocate);
        btnContact = findViewById(R.id.btnContact);
        btnSchedule = findViewById(R.id.btnSchedule);
        btnDonate = findViewById(R.id.btnDonate);

        //setting listeners for the buttons to perform actions once clicked
        btnLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocation();
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
            }
        });

        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSchedule();
            }
        });

        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDonate();
            }
        });

    }



    //These methods are used to open the child activities
    public void openLocation(){
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }
    public void openSchedule(){
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }
    public void openContact(){
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }
    public void openDonate(){
        Intent intent = new Intent(this, DonateActivity.class);
        startActivity(intent);
    }
}
