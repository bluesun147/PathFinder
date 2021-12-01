package com.example.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
// 메뉴 화면
public class MenuActivity extends AppCompatActivity {
// 액티비티 만들때마다 인텐트 쓰려면 manifest에 추가해야 함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);

        ImageView goback = findViewById(R.id.goback); // 뒤로가기

        ImageView savedRoute = findViewById(R.id.savedRoute); // 저장 노선

        ImageView middle = findViewById(R.id.middle); // 중간 역

        goback.setOnClickListener(new View.OnClickListener() { // 뒤로가기 누르면 메인 화면으로
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });

        savedRoute.setOnClickListener(new View.OnClickListener() { // 저장 노선 페이지로 이동
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SavedRouteActivity.class);
                startActivity(intent);

            }
        });

        middle.setOnClickListener(new View.OnClickListener() { // 중간 역 페이지로 이동
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MiddleSearchActivity.class);
                startActivity(intent);
            }
        });
    }
}