package com.example.frameworksample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    CardView card1,card2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        card1 =  findViewById(R.id.card_View_1page);
        card2 =  findViewById(R.id.cardView);


        //implement onClick event for Implicit Intent



        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://192.168.1.113:8080/login?from=%2F"));
                startActivity(i);
            }
        });



        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(i);
            }
        });

    }
}