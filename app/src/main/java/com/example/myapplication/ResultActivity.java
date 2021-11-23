package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    // 결과 경로 3개 보여주는 화면. 노선 보여주기 이전 화면 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);

        ImageButton button = findViewById(R.id.button); // 경로확인 버튼

        TextView start = findViewById(R.id.start); // 출발역 :
        TextView end = findViewById(R.id.end); // 도착역 :

        Intent intent = getIntent(); // SearchActiity에서 출발역, 도착역 받아옴 

        String startStation = intent.getExtras().getString("start"); // 출발 역
        start.setText("출발역: " + startStation); 

        String endStation = intent.getExtras().getString("end"); // 도착 역
        end.setText("도착역: " + endStation);

        button.setOnClickListener(new View.OnClickListener() { // 경로 확인 누르면 경로 보여줌
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                startActivity(intent);
            }
        });

    }
}
