package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

// 맨 처음 시작 페이지
// https://ukebox.tistory.com/42 깃허브
public class FrontActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        ImageButton button = findViewById(R.id.button);

        Button toast = findViewById(R.id.toast);

        toast.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼이 눌렸습니다!", Toast.LENGTH_LONG).show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });

    }
}