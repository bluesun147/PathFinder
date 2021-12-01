package com.example.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.List;

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

        Button otherApp = findViewById(R.id.otherApp); // 다른 앱 테스트

        otherApp.setOnClickListener(new View.OnClickListener()
        { // 다른 앱 열기 클릭 시

            public boolean getPackageList() { // 앱 설치 되어있는지 확인하는 메서드
                boolean isExist = false;

                PackageManager pkgMgr = getPackageManager();
                List<ResolveInfo> mApps;
                Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
                mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                mApps = pkgMgr.queryIntentActivities(mainIntent, 0);

                try {
                    for (int i = 0; i < mApps.size(); i++) {
                        if(mApps.get(i).activityInfo.packageName.startsWith("com.dki.spb_android")){ // 따릉이 앱
                            isExist = true;
                            break;
                        }
                    }
                }
                catch (Exception e) {
                    isExist = false;
                }
                return isExist;
            }

            public void onClick(View view)
            {
                if (getPackageList() == true) 
                { // 설치 되어 있으면 앱 열기
                // https://www.fun25.co.kr/blog/android-execute-3rdparty-app/?category=003
                //Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.dki.spb_android");
                // com.android.chrome
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                }
                
                else { // 설치 안 되어 있다면 플레이 스토어로
                    String url = "market://details?id=" + "com.dki.spb_android";
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(i);
                }
            }
        });

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