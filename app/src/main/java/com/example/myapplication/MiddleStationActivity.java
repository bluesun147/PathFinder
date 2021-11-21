package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
// 중간 역
public class MiddleStationActivity extends AppCompatActivity {
    EditText editText; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.middle_station_page);

        ImageView goback = findViewById(R.id.goback); // 뒤로가기
        
        TextView me = findViewById(R.id.me); // "나" 버튼
        
        goback.setOnClickListener(new View.OnClickListener() { // 뒤로가기 누르면 메뉴로
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class); // 지도 화면으로
                startActivity(intent);
            }
        });

        me.setOnClickListener(new View.OnClickListener() { // 역 검색 페이지로 이동. 나를 누르면 SearchActivity가 바껴야 함
            public void onClick(View view) {

                String flagText = "중간역 검색에서 옴"; // TEXT는 입력한 문자열 (역)
                Intent intent = new Intent(getBaseContext(), SearchActivity.class);
                intent.putExtra("flagText", flagText); // 다른 액티비티에서 사용. https://itsaessak.tistory.com/342
                startActivity(intent);
            }
        });
    }
}