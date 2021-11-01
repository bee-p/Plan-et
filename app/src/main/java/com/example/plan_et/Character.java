package com.example.plan_et;

import android.graphics.Matrix;
import android.os.Bundle;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageButton;
import android.widget.ProgressBar;


public class Character extends AppCompatActivity {

    private Intent intent = getIntent();    // 데이터 받기 위한 intent
    private ProgressBar expBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        // 경험치 바 연결
        expBar = (ProgressBar) findViewById(R.id.progressBar);

        // 할 일이 체크(완수)된 수를 받아 그 수만큼 경험치 상승
    }
}