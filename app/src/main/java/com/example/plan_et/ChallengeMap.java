package com.example.plan_et;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChallengeMap extends AppCompatActivity {

    // 단계별 버튼 배열
    private Button button[] = new Button[21];
    private int buttonID[] = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
                        R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10,
                        R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15,
                        R.id.button16, R.id.button17, R.id.button18, R.id.button19, R.id.button20, R.id.button21};



    // 캐릭터 이미지
    private ImageView charImage;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_map);
        //challengeMap에서 character홈으로 화면 전환
        ImageButton back_button = (ImageButton) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Character.class);
                startActivity(intent);
            }
        });


        // 캐릭터 이미지 연결
        charImage = (ImageView) findViewById(R.id.char_image);

        // 데이터 수신
        intent = getIntent();

        // 수신 받은 이미지(현재 캐릭터)로 캐릭터 세팅
        charImage.setImageResource(intent.getIntExtra("id", 0));

        // 버튼 집어넣기(연결)
        for (int i = 0; i < button.length; i++)
        {
           button[i] = (Button) findViewById(buttonID[i]);
        }

        // 리스너 생성
        View.OnClickListener btnListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 클릭된 뷰 버튼으로 받기
                Button clickButton = (Button) v;

                // 클릭된 버튼 찾기
                for (Button temp : button)
                {
                    // 클릭된 버튼을 찾으면
                    if (temp == clickButton)
                    {
                        // 해당 버튼 위치로 좌표 이동
                        charImage.setX(temp.getX());
                        charImage.setY(temp.getY());
                    }
                }
            }
        };

        // 버튼에 리스너 담기
        for (int i = 0; i < button.length; i++)
        {
            button[i].setOnClickListener(btnListener);
        }
    }
}
