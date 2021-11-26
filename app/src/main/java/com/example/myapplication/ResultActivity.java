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
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import com.example.myapplication.Graph.Node;


public class ResultActivity extends AppCompatActivity {
    // 결과 경로 3개 보여주는 화면. 노선 보여주기 이전 화면 
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);

        ImageButton button = findViewById(R.id.button); // 경로확인 버튼

        TextView start = findViewById(R.id.start); // 출발역 :
        TextView end = findViewById(R.id.end); // 도착역 :

        TextView route = findViewById(R.id.route); // 역 > 역 > 역 > 역

        Intent intent = getIntent(); // SearchActiity에서 출발역, 도착역 받아옴 

        String startStation = intent.getExtras().getString("start"); // 입력한 출발 역
        start.setText("출발역: " + startStation); 

        String endStation = intent.getExtras().getString("end"); // 입력한 도착 역
        end.setText("도착역: " + endStation);

    // =====================================================
        /*class pathFinder
        {
            public void main() throws IOException
            {
                List<ArrayList<Node>> graph = Graph.graph();

                Dijkstra d = new Dijkstra(111, 139, graph);

                route.setText(d.DijkstraAlgorithmFull(1,90)); // 101이런식으로 원래 역 입력하도록 바꿔야 함

            }
        }

        pathFinder pp = new pathFinder();*/

        try {
            //pp.main();
            Toast.makeText(getApplicationContext(), "11111", Toast.LENGTH_LONG).show();
            List<ArrayList<Node>> graph = Graph.graph();
            Toast.makeText(getApplicationContext(), "222222", Toast.LENGTH_LONG).show();
            Dijkstra d = new Dijkstra(111, 139, graph);
            route.setText(d.DijkstraAlgorithmFull(1,90));
        }
        catch (IOException e) {
            route.setText("경로오류");
            Toast.makeText(getApplicationContext(), "경로오류", Toast.LENGTH_LONG).show();
        }


        //route.setText(PathFinder의 결과);
        /*List<ArrayList<Node>> graph = null;
        try {
            graph = Graph.graph();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Dijkstra d = new Dijkstra(111, 139, graph);



        try {
            route.setText(d.DijkstraAlgorithmFull(1,90)); // 101이런식으로 뭥래 역 입력하도록 바꿔야 함
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "오류오류", Toast.LENGTH_LONG).show();
        }*/

        // ==========================================================

        button.setOnClickListener(new View.OnClickListener() { // 경로 확인 누르면 경로 보여줌
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ResultMapActivity.class);
                startActivity(intent);
            }
        });

    }
}
