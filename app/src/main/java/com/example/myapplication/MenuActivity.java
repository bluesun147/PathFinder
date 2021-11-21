package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
// 액티비티 만들때마다 인텐트 쓰려면 manifest에 추가해야 함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);

        ImageView goback = findViewById(R.id.goback); // 뒤로가기

        ImageView savedRoute = findViewById(R.id.savedRoute);

        ImageView middle = findViewById(R.id.middle);

        goback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });

        savedRoute.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SavedRouteActivity.class);
                startActivity(intent);
            }
        });
    }
}