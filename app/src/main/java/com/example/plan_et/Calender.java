package com.example.plan_et;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.widget.CalendarView;
import android.widget.TextView;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Calender extends AppCompatActivity {

    CalenderView calenderView;
    TextView today;


    @Override
   public void onCreate(Bundle savedlnstanceState){
        super.onCreate(savedlnstanceState);
        setContentView(R.layout.calenderhome);

        today =findViewById(R.id.today);
        calenderView =findViewById(R.id.qweqwe);
        //날짜 변환
        DateFormat formatter= new SimpleDateFormat("yyyy년MM월dd일");
        Date date =new Date(calenderView.getDate());

        today.setText(formatter.format(date));

        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(@NonNull CalendarView,int year, int month, int dayOfmonth){
                String day;
                day=year+"년"+(month+1)+"월"+dayOfmonth+"일";
                today.setText(day);
            }
        });
    }
}