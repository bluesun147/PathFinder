package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);

        ImageView goback = findViewById(R.id.goback); // 뒤로가기

        editText = findViewById(R.id.editText); // 입력 창

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // 입력창 리스너
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {  // 입력 후 돋보기 누르면 search_page_start로 넘어감
                    String TEXT = editText.getText().toString(); // TEXT는 입력한 문자열 (역)
                    Intent intent = new Intent(getBaseContext(), SearchStationActivity.class);
                    intent.putExtra("TEXT", TEXT); // 다른 액티비티에서 사용. https://itsaessak.tistory.com/342
                    startActivity(intent);
                }
                return true;
            }
        });

        // 출발역 한번 입력 받았으면 두번째 입력은 도착역 받아야 함. 즉 받은 출발역 기억해야 함.


        goback.setOnClickListener(new View.OnClickListener() { // 뒤로가기
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class); // 지도 화면으로
                startActivity(intent);
            }
        });
    }
}