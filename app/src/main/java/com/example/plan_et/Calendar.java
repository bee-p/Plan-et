package com.example.plan_et;

import static android.R.color.black;

import static android.graphics.Color.BLACK;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Calendar extends AppCompatActivity
{
    public String readDay = null;
    public String readDay2=null;
    public String str = null;
    public String str2 = null;
    public String str3 = null;
    public String str4 = null;
    public CalendarView calendarView;
    public Button cha_Btn, del_Btn, save_Btn;
    public Button cha_Btn2, del_Btn2, save_Btn2;


    public TextView diaryTextView, textView2,textView3 ,checklist_text1,checklist_text2;
    public EditText contextEditText,contextEditText2,checklist1,checklist2;
    public ImageButton button ,button2,button3,button4;

    // 캐릭터 홈으로 정보를 보내기 위한 intent
    private Intent charIntent;
    private int count;

    // bottom쪽 버튼(캐릭터 홈으로 가기)
    private Button gotoChar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendarhome);

        //Calendarhome에서 mainhome으로 화면 전환
       Button home_button= (Button) findViewById(R.id.home_button);
        home_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),mainhome.class);
                startActivity(intent);
            }
        });

        //calendarhome에서 ChallengeMap으로 화면 전환
        Button ch_21button= (Button) findViewById(R.id.ch21_button);
        ch_21button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),ChallengeMap.class);
                startActivity(intent1);
            }
        });

        // calendarhome에서 activity_character로 화면 전환
        gotoChar = (Button) findViewById(R.id.goToChar);
        gotoChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(charIntent);
            }
        });


        calendarView = findViewById(R.id.calendarView);
        diaryTextView = findViewById(R.id.diaryTextView);
        save_Btn = findViewById(R.id.save_Btn);
        del_Btn = findViewById(R.id.del_Btn);
        cha_Btn = findViewById(R.id.cha_Btn);
        save_Btn2 = findViewById(R.id.save_Btn2);
        del_Btn2 = findViewById(R.id.del_Btn2);
        cha_Btn2 = findViewById(R.id.cha_Btn2);


        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        //체크박스 버튼
        button= (ImageButton)findViewById(R.id.checkbox1);
        button2= (ImageButton)findViewById(R.id.checkbox2);
        button.setOnClickListener(imgButtonHandler);
        button2.setOnClickListener(imgButtonHandler);
        contextEditText = findViewById(R.id.contextEditText);
        contextEditText2 = findViewById(R.id.contextEditText2);

        //체크리스트
        button3= (ImageButton)findViewById(R.id.checklist_checkbox1);
        button4= (ImageButton)findViewById(R.id.checklist_checkbox2);
        button3.setOnClickListener(imgButtonHandler);
        button4.setOnClickListener(imgButtonHandler);
        checklist1= findViewById(R.id.checklist1);
        checklist2 = findViewById(R.id.checklist2);
        checklist_text1= findViewById(R.id.checklist_text1);
        checklist_text2 = findViewById(R.id.checklist_text2);


        // 데이터 전송 intent 설정
        charIntent = new Intent(this, Character.class);
        count = 0;






        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                save_Btn2.setVisibility(View.VISIBLE);
                contextEditText2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                cha_Btn2.setVisibility(View.INVISIBLE);
                del_Btn2.setVisibility(View.INVISIBLE);

                //체크리스트
                checklist1.setVisibility(View.VISIBLE);
                checklist2.setVisibility(View.VISIBLE);
                diaryTextView.setText(String.format("%d / %d / %d", year, month + 1, dayOfMonth));
                contextEditText.setText("");
                contextEditText2.setText("");
                checklist1.setText("");
                checklist2.setText("");



                checkDay(year, month, dayOfMonth);
            }
        });



        save_Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                saveDiary(readDay);
                str = contextEditText.getText().toString();
                textView2.setText(str);

                save_Btn.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.VISIBLE);
                del_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);

            }
        });
        save_Btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                saveDiary2(readDay2);
                str2 = contextEditText2.getText().toString();
                textView3.setText(str2);

                save_Btn2.setVisibility(View.INVISIBLE);
                cha_Btn2.setVisibility(View.VISIBLE);
                del_Btn2.setVisibility(View.VISIBLE);
                contextEditText2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.VISIBLE);

            }
        });
    }

    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            Button btn = (Button) v;
            btn.setBackgroundResource(R.drawable.checkbox_com);
            count++;
        }
    };


    public void checkDay(int cYear, int cMonth, int cDay)
    {
        readDay = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";
        readDay2 = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + +2+ ".txt";

        FileInputStream fis;
        FileInputStream fis2;

        try
        {
            fis = openFileInput(readDay);
            fis2 = openFileInput(readDay2);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();
            byte[] fileData2 = new byte[fis2.available()];
            fis2.read(fileData2);
            fis2.close();

            str = new String(fileData);
            str2 = new String(fileData2);

            contextEditText.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView2.setText(str);
            textView2.setTextColor(Color.parseColor("#000000"));



            contextEditText2.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.VISIBLE);
            textView3.setText(str2);


            save_Btn.setVisibility(View.INVISIBLE);
            cha_Btn.setVisibility(View.VISIBLE);

            del_Btn.setVisibility(View.VISIBLE);

            save_Btn2.setVisibility(View.INVISIBLE);
            cha_Btn2.setVisibility(View.VISIBLE);
            del_Btn2.setVisibility(View.VISIBLE);

            cha_Btn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    contextEditText.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText(str);

                    save_Btn.setVisibility(View.VISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                    textView2.setText(contextEditText.getText());
                }

            });


            cha_Btn2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    contextEditText2.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.INVISIBLE);
                    contextEditText2.setText(str2);

                    save_Btn2.setVisibility(View.VISIBLE);
                    cha_Btn2.setVisibility(View.INVISIBLE);
                    del_Btn2.setVisibility(View.INVISIBLE);
                    textView3.setText(contextEditText2.getText());
                }

            });


            del_Btn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText("");
                    contextEditText.setVisibility(View.VISIBLE);
                    save_Btn.setVisibility(View.VISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                    removeDiary(readDay);
                }
            });
            if (textView2.getText() == null)
            {
                textView2.setVisibility(View.INVISIBLE);
                diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
            }


            del_Btn2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    textView3.setVisibility(View.INVISIBLE);
                    contextEditText2.setText("");
                    contextEditText2.setVisibility(View.VISIBLE);
                    save_Btn2.setVisibility(View.VISIBLE);
                    cha_Btn2.setVisibility(View.INVISIBLE);
                    del_Btn2.setVisibility(View.INVISIBLE);
                    removeDiary(readDay);
                }
            });



            if (textView3.getText() == null)
            {
                textView3.setVisibility(View.INVISIBLE);
                diaryTextView.setVisibility(View.VISIBLE);
                save_Btn2.setVisibility(View.VISIBLE);
                cha_Btn2.setVisibility(View.INVISIBLE);
                del_Btn2.setVisibility(View.INVISIBLE);
                contextEditText2.setVisibility(View.VISIBLE);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();

        // 할 일 체크한 값(수량) 캐릭터에 보내기
        charIntent.putExtra("exp", count);
        // count 다시 초기화
        count = 0;
    }


    @SuppressLint("WrongConstant")
    public void removeDiary(String readDay)
    {
        FileOutputStream fos;
        FileOutputStream fos2;

        try
        {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = "";
            fos.write((content).getBytes());
            fos.close();
            fos2 = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content2 = "";
            fos2.write((content2).getBytes());
            fos2.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void saveDiary(String readDay)
    {
        FileOutputStream fos;

        try
        {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = contextEditText.getText().toString();
            fos.write((content).getBytes());
            fos.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void saveDiary2(String readDay)
    {

        FileOutputStream fos2;
        try
        {
            fos2 = openFileOutput(readDay,  MODE_APPEND );
            String content2 = contextEditText2.getText().toString();
            fos2.write((content2).getBytes());
            fos2.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}








//import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.view.View;
//import android.widget.Button;
//
//import android.content.Intent;
//
//
//public class Calender extends AppCompatActivity {
//
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.calendarhome);
////개발자 정보 버튼 클릭시 액티비티 전환
//        Button add_schehlue = (Button) findViewById(R.id.add_schedule);
//        add_schehlue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), Add_schedule.class);
//                startActivity(intent);
//            }
//        });
//
//
//    }
//}
//
//    public String fname = null;
//    public String str = null;
//    public CalendarView calendarView;
//
//    public Button cha_Btn, del_Btn, save_Btn;
//    public TextView diaryTextView, textView2, textView3;
//    public EditText contextEditText;
//
//
//    @Override
//    public void onCreate(Bundle savedlnstanceState) {
//        super.onCreate(savedlnstanceState);
//        setContentView(R.layout.calenderhome);
//        calendarView = findViewById(R.id.calendarView);
//        diaryTextView = findViewById(R.id.diaryTextView);
//        save_Btn = findViewById(R.id.save_Btn);
//        del_Btn = findViewById(R.id.del_Btn);
//        cha_Btn = findViewById(R.id.cha_Btn);
//        contextEditText = findViewById(R.id.contextEditText);
//
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView View, int year, int month, int dayOfMonth) {
//                diaryTextView.setVisibility(View.VISIBLE);
//                save_Btn.setVisibility(View.VISIBLE);
//                contextEditText.setVisibility(View.VISIBLE);
//                //text2
//                cha_Btn.setVisibility(View.INVISIBLE);
//                del_Btn.setVisibility(View.INVISIBLE);
//                diaryTextView.setText(String.format("%d / %d / %d", year, month + 1, dayOfMonth));
//                contextEditText.setText("");
//                checkDay(year, month, dayOfMonth);
//
//
//            }
//        });
//        save_Btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                saveDiary(fname);
//                str = contextEditText.getText().toString();
//                textView2.setText(str);
//                save_Btn.setVisibility(View.INVISIBLE);
//                cha_Btn.setVisibility(View.VISIBLE);
//                del_Btn.setVisibility(View.VISIBLE);
//                contextEditText.setVisibility(View.INVISIBLE);
//                textView2.setVisibility(View.VISIBLE);
//
//            }
//        });
//    }
//
//    public void checkDay(int cYear, int cMonth, int cDay) {
//        fname = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";//저장할 파일 이름설정
//        FileInputStream fis = null;//FileStream fis 변수
//
//        try {
//            fis = openFileInput(fname);
//
//            byte[] fileData = new byte[fis.available()];
//            fis.read(fileData);
//            fis.close();
//
//            str = new String(fileData);
//
//            contextEditText.setVisibility(View.INVISIBLE);
//            textView2.setVisibility(View.VISIBLE);
//            textView2.setText(str);
//
//            save_Btn.setVisibility(View.INVISIBLE);
//            cha_Btn.setVisibility(View.VISIBLE);
//            del_Btn.setVisibility(View.VISIBLE);
//
//            cha_Btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    contextEditText.setVisibility(View.VISIBLE);
//                    textView2.setVisibility(View.INVISIBLE);
//                    contextEditText.setText(str);
//
//                    save_Btn.setVisibility(View.VISIBLE);
//                    cha_Btn.setVisibility(View.INVISIBLE);
//                    del_Btn.setVisibility(View.INVISIBLE);
//                    textView2.setText(contextEditText.getText());
//                }
//
//            });
//            del_Btn.setOnClickListener(view -> {
//                textView2.setVisibility(View.INVISIBLE);
//                contextEditText.setText("");
//                contextEditText.setVisibility(View.VISIBLE);
//                save_Btn.setVisibility(View.VISIBLE);
//                cha_Btn.setVisibility(View.INVISIBLE);
//                del_Btn.setVisibility(View.INVISIBLE);
//                removeDiary(fname);
//            });
//            if (textView2.getText() == null) {
//                textView2.setVisibility(View.INVISIBLE);
//                diaryTextView.setVisibility(View.VISIBLE);
//                save_Btn.setVisibility(View.VISIBLE);
//                cha_Btn.setVisibility(View.INVISIBLE);
//                del_Btn.setVisibility(View.INVISIBLE);
//                contextEditText.setVisibility(View.VISIBLE);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @SuppressLint("WrongConstant")
//    public void removeDiary(String readDay) {
//        FileOutputStream fos = null;
//
//        try {
//            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
//            String content = "";
//            fos.write((content).getBytes());
//            fos.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @SuppressLint("WrongConstant")
//    public void saveDiary(String readDay) {
//        FileOutputStream fos = null;
//
//        try {
//            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
//            String content = contextEditText.getText().toString();
//            fos.write((content).getBytes());
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}