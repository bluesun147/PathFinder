package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MiddleResultActivity extends AppCompatActivity {
    // 결과 경로 3개 보여주는 화면. 노선 보여주기 이전 화면
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.middle_result_page);

        ImageButton button = findViewById(R.id.button); // 경로확인 버튼

        TextView me = findViewById(R.id.me); // 나의 역 :
        TextView you = findViewById(R.id.you); // 상대 역 :

        Intent intent = getIntent(); // SearchActiity에서 출발역, 도착역 받아옴

        String myStation = intent.getExtras().getString("me"); // 나의 역
        me.setText("나의 역: " + myStation);

        String youuStation = intent.getExtras().getString("you"); // 상대 역
        you.setText("상대 역: " + youuStation);

        button.setOnClickListener(new View.OnClickListener() { // 경로 확인 누르면 경로 보여줌
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                startActivity(intent);
            }
        });

    }
}
