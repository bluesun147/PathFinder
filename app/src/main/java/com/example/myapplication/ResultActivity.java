package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
// PathFinder.java 임포트
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.myapplication.Graph.Node;


public class ResultActivity extends AppCompatActivity {
    // 결과 경로 3개 보여주는 화면. 노선 보여주기 이전 화면

    ImageButton button;

    String recommRoute; // 추천 경로-경로-경로
    String recommRouteCost; // 시간, 비용

    String timeRoute; // 최단시간 경로
    String timeRouteCost; // 시간, 비용

    String moneyRoute; // 최소비용 경로
    String moneyRouteCost; // 시간, 비용


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);

        button = findViewById(R.id.button); // 경로확인 버튼

        TextView start = findViewById(R.id.start); // 출발역 :
        TextView end = findViewById(R.id.end); // 도착역 :

        TextView printRecommRoute = findViewById(R.id.printRecommRoute); // 역 > 역 > 역 > 역
        TextView recommCosts = findViewById(R.id.recommCosts); // 소요 시간, 비용
        TextView recomm_route = findViewById(R.id.recommending_route); // 추천 경로

        TextView printTimeRoute = findViewById(R.id.printTimeRoute); // 역 > 역 > 역 > 역
        TextView timeCosts = findViewById(R.id.timeCosts); // 소요 시간, 비용
        TextView time_route = findViewById(R.id.time_route); // 추천 경로

        TextView printMoneyRoute = findViewById(R.id.printMoneyRoute); // 역 > 역 > 역 > 역
        TextView moneyCosts = findViewById(R.id.moneyCosts); // 소요 시간, 비용
        TextView money_route = findViewById(R.id.money_route); // 추천 경로
        

        Intent intent = getIntent(); // SearchActiity에서 출발역, 도착역 받아옴 

        String startStation = intent.getExtras().getString("start"); // 입력한 출발 역
        start.setText("출발역: " + startStation); 

        String endStation = intent.getExtras().getString("end"); // 입력한 도착 역
        end.setText("도착역: " + endStation);

        try {
            List<ArrayList<Node>> graph = Graph.graph();
            Dijkstra d = new Dijkstra(111, 139, graph);
            // 입력한 출발역과 도착역으로 (문자열이기 때문에 정수로 변환)
            // 그에 맞는 경로 보여줌

            // 추천경로는 인덱스[0]
            int startstation = DataChange.stnToNum(Integer.parseInt(startStation));
            int endstation = DataChange.stnToNum(Integer.parseInt(endStation));

            recommRoute = d.DijkstraAlgorithmFull(startstation, endstation)[0];
            printRecommRoute.setText(recommRoute);

            recommRouteCost = "소요 시간 "+d.DijkstraAlgorithmFull2(startstation, endstation)[0][0] + "분, 소요 비용 "+d.DijkstraAlgorithmFull2(startstation, endstation)[0][2] + "원";
            // 소요 시간, 비용
            recommCosts.setText(recommRouteCost);

            // 최단시간은 인덱스[1]
            timeRoute = d.DijkstraAlgorithmFull(startstation, endstation)[1];
            printTimeRoute.setText(timeRoute);

            timeRouteCost = "소요 시간 "+d.DijkstraAlgorithmFull2(startstation, endstation)[1][0] + "분, 소요 비용 "+d.DijkstraAlgorithmFull2(startstation, endstation)[1][2] + "원";
            // 소요 시간, 비용
            timeCosts.setText(timeRouteCost);

            // 최소비용은 인덱스[2]
            moneyRoute = d.DijkstraAlgorithmFull(startstation, endstation)[0];
            printMoneyRoute.setText(moneyRoute);

            moneyRouteCost = "소요 시간 "+d.DijkstraAlgorithmFull2(startstation, endstation)[2][0] + "분, 소요 비용 "+d.DijkstraAlgorithmFull2(startstation, endstation)[2][2] + "원";
            // 소요 시간, 비용
            moneyCosts.setText(moneyRouteCost);
        }
        catch (IOException e) { // 오류
            printRecommRoute.setText(e.toString());
            Toast.makeText(getApplicationContext(), "경로오류", Toast.LENGTH_LONG).show();
        }

        // 여기서 추천 경로, 최단 시간, 최소 비용 세개 중 누른 것에 해당하는 결과 갖고 가야 함.

        /*recomm_route.setOnClickListener(new View.OnClickListener() { // 추천 경로 선택할 시
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                intent.putExtra("route", recommRoute);
                intent.putExtra("cost", recommRouteCost);

                button.setOnClickListener(new View.OnClickListener() { // 경로 선택하고 경로 확인 누르면 경로 보여줌
                    public void onClick(View view) {

                        intent.putExtra("start", startStation);
                        intent.putExtra("end", endStation);
                        startActivity(intent);
                    }
                });
            }
        });*/

        TextView.OnClickListener onClickListener = new TextView.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                switch (v.getId()) {
                    case R.id.recommending_route:
                        //intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                        intent.putExtra("route", recommRoute);
                        intent.putExtra("cost", recommRouteCost);
                        Toast.makeText(getApplicationContext(), "추천 경로 선택", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.time_route:
                        //intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                        intent.putExtra("route", timeRoute);
                        intent.putExtra("cost", timeRouteCost);
                        Toast.makeText(getApplicationContext(), "최소 시간 경로 선택", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.money_route:
                        //intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                        intent.putExtra("route", moneyRoute);
                        intent.putExtra("cost", moneyRouteCost);
                        Toast.makeText(getApplicationContext(), "최소 비용 경로 선택", Toast.LENGTH_SHORT).show();
                        break;
                }
                button.setOnClickListener(new View.OnClickListener() { // 경로 선택하고 경로 확인 누르면 경로 보여줌
                    public void onClick(View view) {

                        intent.putExtra("start", startStation);
                        intent.putExtra("end", endStation);
                        startActivity(intent);
                    }
                });
            }
        };
        recomm_route.setOnClickListener(onClickListener);
        time_route.setOnClickListener(onClickListener);
        money_route.setOnClickListener(onClickListener);




    }
}
