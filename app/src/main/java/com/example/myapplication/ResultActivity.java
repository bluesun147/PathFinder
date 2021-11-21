package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ResultActivity extends AppCompatActivity {
    // 결과 경로 3개 보여주는 화면. 노선 보여주기 이전 화면 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);

        ImageButton button = findViewById(R.id.button);


        /*button.setOnClickListener(new View.OnClickListener() { // 경로 확인 누르면 경로 보여줌
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), 경로.class);
                startActivity(intent);
            }
        });*/

    }
}