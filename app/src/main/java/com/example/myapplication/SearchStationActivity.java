package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchStationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page_start);

        ImageView search_start = findViewById(R.id.search_start); // "출발"버튼

        ImageView search_end = findViewById(R.id.search_end); // "도착"버튼

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        TextView startStation = findViewById(R.id.startStation);
        startStation.setText(bundle.getString("TEXT") + "\uD83D\uDE87"); // search_page에서 입력한 역 출력
        // 출력하고 출발역이라고 저장해둬야 함.
        
        // "출발"버튼 누르면 다시 search_page로 돌아가서 도착역 입력 받도록.
        search_start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        // "도착"버튼 누르면 결과 페이지로
        /*search_end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), 결과.class);
                startActivity(intent);
            }
        });*/
    }
}