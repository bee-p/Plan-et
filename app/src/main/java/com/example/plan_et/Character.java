package com.example.plan_et;

import android.graphics.Matrix;
import android.os.Bundle;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Date;
import java.util.Locale;


public class Character extends AppCompatActivity {

    private Intent intent = getIntent();    // 데이터 받기 위한 intent
    private ProgressBar expBar;
    private TextView textViewDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        // ----- 경험치 바 연결 ----- \\
        expBar = (ProgressBar) findViewById(R.id.progressBar);

        // 할 일이 체크(완수)된 수를 받아 그 수만큼 경험치 상승


        // ----- 날짜 ----- \\
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

        String year = yearFormat.format(currentTime);
        String month = yearFormat.format(currentTime);
        String day = yearFormat.format(currentTime);

        // 날짜 textView 연결
        textViewDate = (TextView) findViewById(R.id.dateTextView);

        // 현재 날짜로 텍스트 출력(변경)
        textViewDate.setText("오늘은\n" + year + "년 " + month + "월 " + day + "일 입니다.");
    }
}