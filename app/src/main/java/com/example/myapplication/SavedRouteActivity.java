package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

// 저장 노선
public class SavedRouteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savedroute_page);

        /*ImageView goback = findViewById(R.id.goback);

        goback.setOnClickListener(new View.OnClickListener() { // 뒤로가기 누르면 메뉴로
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });*/

        Intent intent = getIntent();
        String route = intent.getExtras().getString("route");

        final ArrayList<String> items = new ArrayList<String>() ;
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items) ;

        final ListView listview = (ListView) findViewById(R.id.listview1) ;
        listview.setAdapter(adapter) ;

        Button addButton = (Button)findViewById(R.id.add) ;
        addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count;
                count = adapter.getCount();

                // 아이템 추가.
                items.add(route + Integer.toString(count + 1));

                // listview 갱신
                adapter.notifyDataSetChanged();
            }
        }) ;

        Button modifyButton = (Button)findViewById(R.id.modify) ;
        modifyButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count, checked ;
                count = adapter.getCount() ;

                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = listview.getCheckedItemPosition();
                    if (checked > -1 && checked < count) {
                        // 아이템 수정
                        items.set(checked, Integer.toString(checked+1) + "번 아이템 수정") ;

                        // listview 갱신
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }) ;

        Button deleteButton = (Button)findViewById(R.id.delete) ;
        deleteButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count, checked ;
                count = adapter.getCount() ;

                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = listview.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        // 아이템 삭제
                        items.remove(checked) ;

                        // listview 선택 초기화.
                        listview.clearChoices();

                        // listview 갱신.
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }) ;
    }
}