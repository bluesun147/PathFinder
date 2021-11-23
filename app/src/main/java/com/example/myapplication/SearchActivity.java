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

public class SearchActivity extends AppCompatActivity
{
    EditText enterStart;
    EditText enterEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);

        ImageView goback = findViewById(R.id.goback); // 뒤로가기


        enterStart = findViewById(R.id.enterStart); // 출발 역 입력 창
        enterEnd = findViewById(R.id.enterEnd); // 도착 역 입력 창

        /*TextView flagText = findViewById(R.id.flagText); // 어디서 온 지 표시 텍스트
        Intent intent2 = getIntent();
        // https://acholyte.tistory.com/entry/%EC%9D%B8%ED%85%90%ED%8A%B8%EB%A1%9C-%EB%8B%A4%EB%A5%B8-%EC%95%A1%ED%8B%B0%EB%B9%84%ED%8B%B0%EC%97%90-%EA%B0%92-%EC%A0%84%EB%8B%AC
        // 중간역에서 온 것 표시
        flagText.setText(intent2.getStringExtra("flagText")); // search_page에서 입력한 역 출력 */

        /*Intent intent2 = getIntent();
        enterStart.setHint(intent2.getStringExtra("myStation"));
        enterEnd.setHint(intent2.getStringExtra("yourStation"));*/


        // 출발역, 도착역 입력받은 후 그값 가지고 결과 페이지로 이동
        enterStart.setOnEditorActionListener(new TextView.OnEditorActionListener() { // 입력창 리스너
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {  // 입력 후 돋보기 누르면
                    String start = enterStart.getText().toString(); // start에 출발 역 저장

                    Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                    intent.putExtra("start", start); // ResultActivity에 출발역 값 저장

                    // 먼저 출발 역 입력하고 도착 역 입력해야 결과 화면으로 넘어감
                    enterEnd.setOnEditorActionListener(new TextView.OnEditorActionListener() { // 입력창 리스너
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                            if (actionId == EditorInfo.IME_ACTION_SEARCH) {  // 입력 후 돋보기 누르면 search_page_start로 넘어감. 누르면 searchStationActivity 바뀜
                                String end = enterEnd.getText().toString(); // end에 도착 역 저장

                                //Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                                intent.putExtra("end", end); // 다른 액티비티에서 사용. https://itsaessak.tistory.com/342
                                startActivity(intent); // ResultActivity로 이동
                            }
                            return true;
                        }
                    });
                }
                return true;
            }
        });

        // 중간역에서 넘어왔을 시 출발역, 도착역 대신 "나, 상대의 역을 입력하세요" 로 바꿔야 함?


        goback.setOnClickListener(new View.OnClickListener() { // 뒤로가기
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "뒤로가기!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class); // 지도 화면으로
                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data); // requestCode가 1000인 경우
        if (requestCode == 1000) {
            // OK 이벤트
            if (resultCode == RESULT_OK)
            {
                enterStart.setHint(data.getStringExtra("myStation"));
                enterEnd.setHint(data.getStringExtra("yourStation"));
            }
        }
    }
}
