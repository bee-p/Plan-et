package com.example.plan_et;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class tutorial3 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial3);

        Button tutorial3_2 = (Button) findViewById(R.id.tutorial3_2);
        tutorial3_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        tutorial2.class);
                startActivity(intent);
            }
        });

        Button tutorial3_startbutton = (Button) findViewById(R.id.tutorial3_startbutton);
        tutorial3_startbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),
                        mainhome.class);
                startActivity(intent2);
            }
        });

    }


}