package com.example.bokjirock;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class likeDBHelper extends SQLiteOpenHelper {
    public likeDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Likes (_id INTEGER PRIMARY KEY AUTOINCREMENT, num TEXT, title TEXT, contents TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(String num, String title, String contents) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Likes VALUES(null,'" + num + "','" + title +"','"+contents+"');");
        Log.e("확인",num);
        db.close();
    }

    public void delete(String snum) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        db.execSQL("DELETE FROM Likes WHERE num='"+snum+"';");
        db.close();
    }

    public void alldelete() {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        db.execSQL("delete from Likes");
        db.close();
    }

    public boolean isExist(String sid) {
        SQLiteDatabase db = getReadableDatabase();
        boolean exist = false;
        Cursor cursor = db.rawQuery("SELECT * FROM Likes WHERE num='"+sid+"';", null);
        if(cursor.getCount() > 0){
            exist=true;
        }
        cursor.close();
        db.close();
        return  exist;
    }

    public String getResult(String snum) {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT num, title, contents FROM Likes Where num="+"'"+snum+"'", null);

        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    +"&"+
                    cursor.getString(1)
                    + "&"
                    + cursor.getString(2)
                    +";";
        }
        return result;
    }

    public String getallResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT num, title, contents FROM Likes", null);

        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    +"&"+
                    cursor.getString(1)
                    + "&"
                    + cursor.getString(2)
                    +";";
        }
        return result;
    }
}
