package com.haroon.mybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Objects;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_ActionBar);
        setContentView(R.layout.activity_contact);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle("");

        Button btncall = findViewById(R.id.btnCall);
        Button btnemail = findViewById(R.id.btnEmail);

        Button btnemailna = findViewById(R.id.btnEmailNA); // these buttons are used for the user if they are unavailable to attend
        Button btntextna = findViewById(R.id.btnTextNA);

        final TextView txtName = findViewById(R.id.txtName);

        final String email = getString(R.string.email);
        final String phnNumber = getString(R.string.mobileNo);



        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:" + phnNumber));

                startActivity(intent);
            }
        });

        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);


                String uriText = "mailto:" + email + "?subject=" + Uri.encode("Email regarding the party invitation");

                intent.setData(Uri.parse(uriText));

                startActivity(intent);
            }
        });

        btnemailna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();

                if (name.equals("")){
                    toast("Please tell me who you are! :(");
                }
                else{
                    Intent intent = new Intent(Intent.ACTION_SENDTO);

                    intent.setData(Uri.parse("mailto:" + email + "?subject=" + Uri.encode("Hi, its "+ name + ", Sorry, I cant come.")));

                    startActivity(intent);

                }

            }
        });

        btntextna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                if (name.equals("")){

                    toast("Please tell me who you are! :(");

                }
                else{
                    Intent intent = new Intent(Intent.ACTION_SENDTO);

                    intent.setData(Uri.parse("smsto:" + phnNumber));

                    String text = "Hi, it's " + name + "! \nSorry, I cannot come to the party!";
                    intent.putExtra("sms_body", text);

                    startActivity(intent);

                }

            }
        });

    }

    private void toast(String text){
        Toast.makeText(getApplicationContext(),text, Toast.LENGTH_LONG).show();
    }
}
