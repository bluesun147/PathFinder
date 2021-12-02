package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MiddleResultActivity extends AppCompatActivity {
    // 결과 경로 3개 보여주는 화면. 노선 보여주기 이전 화면
    String myRoute; // 나의 경로-경로-경로
    int myRoutelength; // 나의 경로 시간
    String myRouteCost; // 나의 시간, 비용
    String myAlarmTime; // 알람 시간

    String yourRoute; // 상대의 경로-경로-경로
    int yourRoutelength; // 상대 경로 시간
    String yourRouteCost; // 상대의 시간, 비용
    String yourAlarmTime; // 알람 시간

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.middle_result_page);

        ImageButton button = findViewById(R.id.button); // 경로확인 버튼

        TextView me = findViewById(R.id.me); // 나의 역 :
        TextView you = findViewById(R.id.you); // 상대 역 :

        TextView middleStation = findViewById(R.id.middleStation); // 증간 역 999

        TextView printMyRoute = findViewById(R.id.printMyRoute); // 나의 역 > 역 > 역 > 역
        TextView myCosts = findViewById(R.id.myCosts); // 나의 소요 시간, 비용
        TextView my_route = findViewById(R.id.my_route); // 나의 경로

        TextView printYourRoute = findViewById(R.id.printYourRoute); // 상대 역 > 역 > 역 > 역
        TextView yourCosts = findViewById(R.id.yourCosts); // 상대 소요 시간, 비용
        TextView your_route = findViewById(R.id.your_route); // 나의 경로

        Intent intent = getIntent(); // MiddleSearchActiity에서 출발역, 도착역 받아옴

        String myStation = intent.getExtras().getString("me"); // 나의 역
        me.setText("나의 역: " + myStation);

        String yourStation = intent.getExtras().getString("you"); // 상대 역
        you.setText("상대 역: " + yourStation);

        String[] myRouteArr = null;
        String[] yourRouteArr = null;

        try
        {
            List<ArrayList<Graph.Node>> graph = Graph.graph();
            Dijkstra d = new Dijkstra(111, 139, graph);
            // 입력한 출발역과 도착역으로 (문자열이기 때문에 정수로 변환)
            // 그에 맞는 경로 보여줌

            // 나의 경로
            int mystation = DataChange.stnToNum(Integer.parseInt(myStation));
            int yourstation = DataChange.stnToNum(Integer.parseInt(yourStation));

            myRoute = d.DijkstraMeetUpMyStr(mystation, yourstation)[2];
            myRoutelength = d.DijkstraMeetUpMyData(mystation, yourstation)[2][1];
            printMyRoute.setText(myRoute);

            myRouteArr = myRoute.split(">");
            middleStation.setText(myRouteArr[myRouteArr.length-1]); // 증간역(999) 값 설정

            myAlarmTime = d.DijkstraAlgorithmFull3(mystation, yourstation)[2]; // ==> 이상해
            //myAlarmTime = d.DijkstraAlgorithmFull3(mystation, Integer.parseInt(myRouteArr[myRouteArr.length-1]))[2];

            //myRouteCost = "소요 시간 "+d.DijkstraMeetUpMyData(mystation, yourstation)[2][0] + "초, 소요 비용 "+d.DijkstraMeetUpMyData(mystation, yourstation)[2][2] + "원";
            myRouteCost = "소요 시간 "+d.DijkstraMeetUpMyData(mystation, yourstation)[2][0] / 60 + "분" + d.DijkstraMeetUpMyData(mystation, yourstation)[2][0] % 60 + "초, "+ "소요 비용 "+d.DijkstraMeetUpMyData(mystation, yourstation)[2][2] + "원";

            // 소요 시간, 비용
            //myCosts.setText(myRouteCost);


            //나//////////////////////////////////////////////////상대//

            yourRoute = d.DijkstraMeetUpYourStr(mystation, yourstation)[2];
            yourRoutelength = d.DijkstraMeetUpYourData(mystation, yourstation)[2][1];
            printYourRoute.setText(yourRoute);

            yourRouteArr = yourRoute.split(">");
            //middleStation.setText(yourRouteArr[0]); // 증간역(999) 값 설정

            //yourAlarmTime = d.DijkstraAlgorithmFull3(mystation, Integer.parseInt(yourRouteArr[0]))[2]; //==> 이게 문제.
            yourAlarmTime = d.DijkstraAlgorithmFull3(mystation, yourstation)[2]; //==> 이게 문제.

            //yourRouteCost = "소요 시간 "+d.DijkstraMeetUpYourData(mystation, yourstation)[2][0] + "초, 소요 비용 "+d.DijkstraMeetUpYourData(mystation,yourstation)[2][2] + "원";
            yourRouteCost = "소요 시간 "+d.DijkstraMeetUpYourData(mystation, yourstation)[2][0] / 60 + "분" + d.DijkstraMeetUpYourData(mystation, yourstation)[2][0] % 60 + "초, "+ "소요 비용 "+d.DijkstraMeetUpYourData(mystation, yourstation)[2][2] + "원";
            myCosts.setText(yourRouteCost);
            // 소요 시간, 비용
            //yourCosts.setText(yourRouteCost);
            yourCosts.setText(myRouteCost);
        }
        catch (IOException e) { // 오류
            Toast.makeText(getApplicationContext(), "오류", Toast.LENGTH_LONG).show();
        }

        /*my_route.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                intent.putExtra("route", myRoute);
                intent.putExtra("routeLength", myRoutelength);
                intent.putExtra("cost", myRouteCost);
                intent.putExtra("alarmTime", myAlarmTime);
                Toast.makeText(getApplicationContext(), "나의 경로 선택", Toast.LENGTH_SHORT).show();
            }
        });

        your_route.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                intent.putExtra("route", yourRoute);
                intent.putExtra("routeLength", yourRoutelength);
                intent.putExtra("cost", yourRouteCost);
                intent.putExtra("alarmTime", yourAlarmTime);
                Toast.makeText(getApplicationContext(), "상대 경로 선택", Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() { // 경로 선택하고 경로 확인 누르면 경로 보여줌
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                intent.putExtra("start", myStation);
                intent.putExtra("end", printMyRoute.getText());
                startActivity(intent);
            }
        });*/

        TextView.OnClickListener onClickListener = new TextView.OnClickListener() {
            int flag = 0;
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultMapActivity.class);

                switch (v.getId()) {
                    case R.id.my_route:
                        intent.putExtra("route", myRoute);
                        intent.putExtra("routeLength", myRoutelength);
                        intent.putExtra("cost", yourRouteCost);
                        intent.putExtra("alarmTime", myAlarmTime);
                        Toast.makeText(getApplicationContext(), "나의 경로 선택", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.your_route:
                        flag = 1;
                        intent.putExtra("route", yourRoute);
                        intent.putExtra("routeLength", yourRoutelength);
                        intent.putExtra("cost", myRouteCost);
                        intent.putExtra("alarmTime", yourAlarmTime);
                        Toast.makeText(getApplicationContext(), "상대 경로 선택", Toast.LENGTH_SHORT).show();
                        break;
                }
                button.setOnClickListener(new View.OnClickListener() { // 경로 선택하고 경로 확인 누르면 경로 보여줌
                    public void onClick(View view) {

                        if (flag == 0)
                            intent.putExtra("start", myStation);
                        if (flag == 1)
                            intent.putExtra("start", yourStation);
                        intent.putExtra("end", middleStation.getText());
                        startActivity(intent);
                    }
                });
            }
        };
        my_route.setOnClickListener(onClickListener);
        your_route.setOnClickListener(onClickListener);

    }
}
