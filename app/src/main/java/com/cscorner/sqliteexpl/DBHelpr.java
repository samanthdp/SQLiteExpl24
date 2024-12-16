package com.cscorner.sqliteexpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelpr extends SQLiteOpenHelper {
    SQLiteDatabase sq;
    public DBHelpr(Context context) {

        super(context, "Elon.db", null, 1);
        sq=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Rocket (Name text, Location text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void  savedata(String name, String Location){
        ContentValues cv = new ContentValues();
        cv.put("Name",name);
        cv.put("Location",Location);
        sq.insert("Rocket",null,cv);
    }
}
