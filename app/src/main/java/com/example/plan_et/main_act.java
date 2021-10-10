package com.example.plan_et;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class main_act extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;  // 바텀 네비게이션 뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_act);

        bottomNavigationView = findViewById(R.id.bottomNavi);

        // 처음화면..일단 캘린더로 뒀음
        // FrameLayout에 fragment.xml 띄우기
        getSupportFragmentManager().beginTransaction().add(R.id.item_calender, new Calender()).commit();

        // 바텀 네비게이션 뷰 안의 아이템 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    // item을 클릭시 id값을 가져와 FramLayout에 fragment.xml 띄우기
                    case R.id.item_calender:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Calender()).commit();
                        break;

                    case R.id.item_character:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Character()).commit();
                        break;
                }

                return true;
            }
        });
    }
}