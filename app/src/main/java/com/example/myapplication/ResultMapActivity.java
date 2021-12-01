package com.example.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultMapActivity extends AppCompatActivity {
    // 결과 경로 3개 보여주는 화면. 노선 보여주기 이전 화면

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_map_page);

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




        try {
            List<ArrayList<Graph.Node>> graph = Graph.graph();
            Dijkstra d = new Dijkstra(111, 139, graph);
            // 입력한 출발역과 도착역으로
            route.setText(routeqq);
            // 소요 시간, 비용
            cost.setText(costqq);

            if (lengthqq < 1500) /////////////
            {
                Toast.makeText(getApplicationContext(), "짧은 거리는 따릉이를 이용하세요!", Toast.LENGTH_SHORT).show();

                Handler handler = new Handler();
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
                }, 3000); //딜레이 타임 조절

                /*if (getPackageList() == true)
                { // 설치 되어 있으면 앱 열기
                    // https://www.fun25.co.kr/blog/android-execute-3rdparty-app/?category=003
                    //Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
                    intent = getPackageManager().getLaunchIntentForPackage("com.dki.spb_android");
                    // com.android.chrome
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

                else { // 설치 안 되어 있다면 플레이 스토어로
                    String url = "market://details?id=" + "com.dki.spb_android";
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(i);
                }*/
            }
            else
            {

            }
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

        bell.setOnClickListener(new View.OnClickListener() { // 알람 버튼 누르면
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "알람이 설정되었습니다.", Toast.LENGTH_SHORT).show();
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
