package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MiddleSearchActivity extends AppCompatActivity
{
    EditText enterMe;
    EditText enterYou;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.middle_search_page);

        ImageView goback = findViewById(R.id.goback); // 뒤로가기


        enterMe = findViewById(R.id.enterMe); // 출발 역 입력 창
        enterYou = findViewById(R.id.enterYou); // 도착 역 입력 창



        // 출발역, 도착역 입력받은 후 그값 가지고 결과 페이지로 이동
        enterMe.setOnEditorActionListener(new TextView.OnEditorActionListener() { // 입력창 리스너
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {  // 입력 후 돋보기 누르면
                    Toast.makeText(getApplicationContext(), "나의 역 입력됨.", Toast.LENGTH_SHORT).show();
                    String me = enterMe.getText().toString(); // enterMe에 나의 역 저장
                    Intent intent = new Intent(getBaseContext(), MiddleResultActivity.class);
                    intent.putExtra("me", me); // MiddleResultActivity에 출발역 값 저장

                    // 먼저 나의 역 입력하고 상대 역 입력해야 결과 화면으로 넘어감
                    enterYou.setOnEditorActionListener(new TextView.OnEditorActionListener() { // 입력창 리스너
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                            if (actionId == EditorInfo.IME_ACTION_SEARCH) {  // 입력 후 돋보기 누르면 search_page_start로 넘어감. 누르면 searchStationActivity 바뀜
                                Toast.makeText(getApplicationContext(), "상대 역 입력됨.", Toast.LENGTH_SHORT).show();
                                String you = enterYou.getText().toString(); // end에 도착 역 저장

                                intent.putExtra("you", you);
                                startActivity(intent); // MiddleResultActivity로 이동
                            }
                            return true;
                        }
                    });
                }
                return true;
            }
        });

        goback.setOnClickListener(new View.OnClickListener() { // 뒤로가기
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "뒤로가기!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class); // 지도 화면으로
                startActivity(intent);
            }
        });
    }
}
