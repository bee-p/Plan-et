package com.example.plan_et;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class tutorial extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial1);

        Button tutorial1_2 = (Button) findViewById(R.id.tutorial1_2);
        tutorial1_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        tutorial2.class);
                startActivity(intent);
            }
        });

        Button tutorial1_startbutton = (Button) findViewById(R.id.tutorial1_startbutton);
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
