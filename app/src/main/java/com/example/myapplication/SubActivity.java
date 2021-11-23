package com.example.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

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

        //Button push = findViewById(R.id.push); // 푸쉬 알림 테스트

        //Button otherApp = findViewById(R.id.otherApp); // 다른 앱 테스트

        /*otherApp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                //startActivity(launchIntent);
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    Toast.makeText(SubActivity.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                }

            }
        });

        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap mLargeIcon =
                        BitmapFactory.decodeResource(getResources(), R.drawable.mb4);

                PendingIntent mPendingIntent = PendingIntent.getActivity(SubActivity.this, 0,
                        new Intent(getApplicationContext(), SubActivity.class),
                        PendingIntent.FLAG_CANCEL_CURRENT
                );

                NotificationCompat.Builder NBuilder =
                        new NotificationCompat.Builder(SubActivity.this)
                        .setSmallIcon(R.drawable.mb4)
                        .setContentTitle("알림 제목!!")
                        .setContentText("알림 내용!!")
                        .setLargeIcon(mLargeIcon)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true)
                        .setContentIntent(mPendingIntent);

                NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotificationManager.notify(0, NBuilder.build());

            }
        });*/

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