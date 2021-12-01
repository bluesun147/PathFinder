package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Timer;
import java.util.TimerTask;

// 맨 처음 시작 페이지
// https://ukebox.tistory.com/42 깃허브
public class FrontActivity extends AppCompatActivity {

    int seconds = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        ImageButton button = findViewById(R.id.button);

        TextView test = findViewById(R.id.test);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });
        Handler handler = new Handler() {
            public void handleMessage (Message msg) {
                seconds += 1;
                test.setText("시간: " + seconds);
            }
        };

        Timer timer = new Timer();
        TimerTask func = new TimerTask() {
            public void run() {
                Message msg = handler.obtainMessage();
                handler.sendMessage(msg);
            }
        };

        timer.schedule(func, 0, 1000);

    }
}