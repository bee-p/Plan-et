package com.example.plan_et;


import android.os.Bundle;
import android.content.Intent;

import android.os.Handler;



import androidx.appcompat.app.AppCompatActivity;


public class splash extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler hand = new Handler();

        hand.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), tutorial.class);
                startActivity(i);
                finish();

            }
        }, 2000);



    }
}
