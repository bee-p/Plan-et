package com.example.plan_et;
import androidx.annotation.NonNull;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;


public class Calender extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calenderhome);
//개발자 정보 버튼 클릭시 액티비티 전환
        Button add_schehlue = (Button) findViewById(R.id.add_schedule);
        add_schehlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Add_schedule.class);
                startActivity(intent);
            }
        });


    }
}
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