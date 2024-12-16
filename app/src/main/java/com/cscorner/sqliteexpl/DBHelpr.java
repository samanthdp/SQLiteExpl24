package com.cscorner.sqliteexpl;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    @SuppressLint("Range")
    public String getloc (String name){
        Cursor c = sq.query(
                "Rocket",
                null,
                "Name=?",
                new String[]{name},
                null,
                null,
                null);
        c.moveToFirst();



        return c.getString(c.getColumnIndex("Location"));
    }

    public int updateval(String name, String newloc) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("Location",newloc);

        return sq.update("Rocket",contentValues,"Name = '"+name+"'",null);

        //  update table Rocket set Location='newloc' where Name =  name

    }
}
