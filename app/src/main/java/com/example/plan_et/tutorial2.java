package com.example.plan_et;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class tutorial2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial2);

        Button tutorial2_3 = (Button) findViewById(R.id.tutorial2_3);
        tutorial2_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        tutorial3.class);
                startActivity(intent);
            }
        });


        Button tutorial2_1 = (Button) findViewById(R.id.tutorial2_1);
        tutorial2_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        tutorial.class);
                startActivity(intent);
            }
        });

        Button tutorial1_startbutton = (Button) findViewById(R.id.tutorial2_startbutton);
        tutorial1_startbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),
                        mainhome.class);
                startActivity(intent2);
            }
        });
    }


}