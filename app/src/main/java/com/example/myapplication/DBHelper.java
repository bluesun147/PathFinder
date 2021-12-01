package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //DB파일 생성
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE history (_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"path TEXT);");//DB처음 만들 때 한번만 생성, 구글링해보니 반드시 필요한 메소드라고 합니다
    }

    //버전 업데이트 시 DB 새로 생성, 요것도 반드시 필요한 기능이라고 하네요
    @Override
    public void onUpgrade(SQLiteDatabase db, int oidVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS history");
        onCreate(db);
    }
}
