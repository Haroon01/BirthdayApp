package com.haroon.mybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.util.JsonUtils;

import java.util.concurrent.TimeUnit;

import java.util.Objects;

public class DonateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_ActionBar);
        setContentView(R.layout.activity_donate);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        setTitle("");

        Button btnDonate = findViewById(R.id.btnDonate);
        final TextView txtName = findViewById(R.id.txtDonateName);
        final TextView txtAmnt = findViewById(R.id.txtdonateAmt);
        final TextView txtMsg = findViewById(R.id.txtdonatemsg);


        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String amnt = txtAmnt.getText().toString();
                String msg = txtMsg.getText().toString();

                if(name.isEmpty() || amnt.isEmpty()){
                    toast("Please enter a name and amount");
                }
                else{
                    toast("Sending...");

                    txtName.setText("");
                    txtMsg.setText("");
                    txtAmnt.setText("");

                    toast("Successful! Thank you!!");
                }

            }
        });


    }

    private void toast(String text){
        Toast.makeText(getApplicationContext(),text, Toast.LENGTH_LONG).show();
    }
}
