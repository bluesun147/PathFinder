package com.example.myapplication;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ResultMapActivity extends AppCompatActivity {
    // 결과 경로 3개 보여주는 화면. 노선 보여주기 이전 화면
    String channelID = "channelID";
    NotificationManager mNotificationManager;
    NotificationChannel channel;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_map_page);



        // 알람 관련
        Bitmap mLargeIconForNoti = BitmapFactory.decodeResource(getResources(), R.drawable.bell);
        PendingIntent mPendingIntent  = PendingIntent.getActivity(ResultMapActivity.this,0,new Intent(getApplicationContext(), ResultMapActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        ImageView goback = findViewById(R.id.goback); // 뒤로가기 버튼
        ImageView save = findViewById(R.id.save); // 경로 저장 버튼
        ImageView bell = findViewById(R.id.bell); // 알람 버튼

        TextView start = findViewById(R.id.start); // 출발역 :
        TextView end = findViewById(R.id.end); // 도착역 :

        TextView route = findViewById(R.id.printRecommRoute); // 역 > 역 > 역 > 역
        TextView cost = findViewById(R.id.recommCosts); // 소요 시간, 비용

        Intent intent = getIntent(); // ResultActiity에서 출발역, 도착역 받아옴

        String startStation = intent.getExtras().getString("start"); // 입력한 출발 역
        start.setText("출발역: " + startStation);

        String endStation = intent.getExtras().getString("end"); // 입력한 도착 역
        end.setText("도착역: " + endStation);

        String routeqq = intent.getExtras().getString("route");
        String costqq = intent.getExtras().getString("cost");

        int lengthqq = intent.getExtras().getInt("routeLength");

        String alarmqq = intent.getExtras().getString("alarmTime"); // 알람 시간 스트링. split으로 배열로 만들어서
        String[] alarmArr = alarmqq.split("@"); // for(Integer.parseInt(arr[i])) 마다 알람 울리게.

        Handler handler = new Handler();

        try {
            List<ArrayList<Graph.Node>> graph = Graph.graph();
            Dijkstra d = new Dijkstra(111, 139, graph);
            // 입력한 출발역과 도착역으로
            route.setText(routeqq);
            // 소요 시간, 비용
            cost.setText(costqq);


            if (lengthqq <= 1500) // 거리가 1.5km 이하일 때 토스트 보여주고 3초 후에 이동
            {
                Toast.makeText(getApplicationContext(), "짧은 거리는 따릉이를 이용하세요!", Toast.LENGTH_LONG).show();

                // 알람 동작 구현



                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
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
                }, 3000); //딜레이 타임 조절 3초
            }
            else { } // 거리 1.5km 보다 클때
        }
        catch (IOException e) {
            route.setText(e.toString());
            Toast.makeText(getApplicationContext(), "경로오류", Toast.LENGTH_LONG).show();
        }

        save.setOnClickListener(new View.OnClickListener() { // 경로 저장 버튼 누르면
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "경로가 저장되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SavedRouteActivity.class);
                intent.putExtra("route", routeqq);
                startActivity(intent);
            }
        });

        bell.setOnClickListener(new View.OnClickListener()
        { // 알람 버튼 누르면
            // 벨 누를때 마다 alarmArr의 원소 하나씩 빼와서 그 시간지난뒤에 알람. count로 세기
            // 한번 더 누르면 count++되서 2분째 원소 시간지난뒤에 알람.
            int count = 0;
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(), "알람이 설정되었습니다.", Toast.LENGTH_SHORT).show();
                //NotificationCompat.Builder mbuilder;




                for (int i=0; i<alarmArr.length; i++) {

                    Timer timer = new Timer();
                    TimerTask func = new TimerTask() {
                        NotificationCompat.Builder mbuilder;
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 26)
                            {
                                channel = new NotificationChannel(channelID, "채널 이름", NotificationManager.IMPORTANCE_DEFAULT);
                                ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(channel);
                                mbuilder = new NotificationCompat.Builder(ResultMapActivity.this, channelID);
                            } else {
                                mbuilder = new NotificationCompat.Builder(ResultMapActivity.this);
                            }

                            // notification 설정
                            mbuilder.setSmallIcon(R.drawable.bell)
                                    // 메소드 체인
                                    .setContentTitle("1분후에 내려야합니다!!")
                                    //.setContentText(" 알림 내용!! ")
                                    .setDefaults(Notification.DEFAULT_SOUND)
                                    .setLargeIcon(mLargeIconForNoti)
                                    // 우선순위
                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                    .setContentIntent(mPendingIntent)
                                    .setAutoCancel(true);


                            mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            mNotificationManager.notify(0, mbuilder.build());
                        }
                    };
                    timer.schedule(func, 0, Integer.parseInt(alarmArr[i])*1000 - 6000); // 내려야 할 시간 1분 전에 알림
                }




                /*// 빌드 API 버전이 26이상이면 알림채널을 부여하는 메소드
                if (Build.VERSION.SDK_INT >= 26)
                {
                    channel = new NotificationChannel(channelID, "채널 이름", NotificationManager.IMPORTANCE_DEFAULT);
                    ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(channel);
                    mbuilder = new NotificationCompat.Builder(ResultMapActivity.this, channelID);
                } else {
                    mbuilder = new NotificationCompat.Builder(ResultMapActivity.this);
                }

                // notification 설정
                mbuilder.setSmallIcon(R.drawable.bell)
                        // 메소드 체인
                        .setContentTitle("1분후에 내려야합니다!!")
                        //.setContentText(" 알림 내용!! ")
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setLargeIcon(mLargeIconForNoti)
                        // 우선순위
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(mPendingIntent)
                        .setAutoCancel(true);


                mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotificationManager.notify(0, mbuilder.build());*/

            }
        });

        goback.setOnClickListener(new View.OnClickListener() { // 뒤로가기 누르면 메인 화면으로
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });

    }
}
