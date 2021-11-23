package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;
// 지도 화면
public class SubActivity extends AppCompatActivity {
// https://youngest-programming.tistory.com/36 ==> this. gradle 수정하면 sync 해야 함. 우측 코끼리 아이콘
// https://m.blog.naver.com/oaie/222019137852


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        
        //PhotoView photoView = findViewById(R.id.photoView);
        //photoView.setImageResource(R.drawable.mb4);

        ImageView menu = findViewById(R.id.menu); // 메뉴 버튼

        ImageView search = findViewById(R.id.search); // 검색 버튼

        menu.setOnClickListener(new View.OnClickListener() { // 메뉴 눌렀을 시 메뉴 페이지로 이동
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() { // 검색 눌렀을 시 검색 페이지로 이동
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                //startActivity(intent);


                String startStation = "출발 역을 입력하세요";
                String endStation = "도착 역을 입력하세요";

                Intent intent = new Intent(getBaseContext(), SearchActivity.class);
                //tartActivity(intent);
                intent.putExtra("startStation", startStation);
                intent.putExtra("endStation", endStation);
                startActivityForResult(intent, 1000);
            }
        });
    }
}