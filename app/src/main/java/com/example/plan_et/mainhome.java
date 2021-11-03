package com.example.plan_et;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class mainhome extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //그릴 xml 뷰 파일을 연결시켜준다. 설정한다
        setContentView(R.layout.activity_main);
        //start 버튼 클릭시 캘린더 홈으로 전환

        ImageButton startButton = (ImageButton) findViewById(R.id.mainhome_start_button1);

        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainhome.this, Calendar.class);
                startActivity(intent);
            }
        });
    }
}
