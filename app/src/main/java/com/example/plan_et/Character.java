package com.example.plan_et;

import android.graphics.Matrix;
import android.os.Bundle;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Date;
import java.util.Locale;


public class Character extends AppCompatActivity {

    private Intent intent = getIntent();    // 데이터 받기 위한 intent
    private ProgressBar expBar;
    private TextView textViewDate;
    private ImageView charImage;

    // 행성 이미지(id) 배열
    private int imageList[] = {R.drawable.earth_ch, R.drawable.marth_ch,
                                    R.drawable.jupiter_ch, R.drawable.venus_ch, R.drawable.uranus_ch};
    private int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        // 경험치 바 연결
        expBar = (ProgressBar) findViewById(R.id.progressBar);

        // 날짜 textView 연결
        textViewDate = (TextView) findViewById(R.id.dateTextView);

        // 캐릭터 이미지 연결
        charImage = (ImageView) findViewById(R.id.mainCharacter);
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        // 할 일이 체크(완수)된 수를 받아 그 수만큼 경험치 상승


        // 현재 경험치가 100 이상이라면
        if(expBar.getProgress() >= 100)
        {
            // 다음 단계의 캐릭터 이미지로 변경
            charImage.setImageResource(imageList[++imageIndex]);
        }


        // ----- 날짜 ----- \\
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

        String year = yearFormat.format(currentTime);
        String month = yearFormat.format(currentTime);
        String day = yearFormat.format(currentTime);

        // 현재 날짜로 텍스트 출력(변경)
        textViewDate.setText("오늘은\n" + year + "년 " + month + "월 " + day + "일 입니다.");
    }
}