package com.example.lenpvo.popsyinventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;
import android.util.Log;

/**
 * Created by lenpvo on 3/22/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "DatabaseHelper";

    public static final String Database_Name = "Bottles.db";

    public static final String Table_Name = "btltable";
    public static final String COL_0 = "_id";
    public static final String COL_1 = "btlname";
    public static final String COL_2 = "btlcount";

    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 2);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public class dbColumns{
        public static final String BTID = "_id";
        public static final String BTNAME = "btlname";
        public static final String BTCOUNT = "btlcount";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = " CREATE TABLE "+Table_Name+" ("+COL_0+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_1+" VARCHAR, "+COL_2+" INTEGER)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }


    public boolean insertData(String bname,int bcount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,bname);
        contentValues.put(COL_2,bcount);
        long result = db.insert(Table_Name,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+Table_Name,null);
        return c;
    }

    /*public String getCount(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        String count = db.rawQuery("SELECT count FROM "+Table_Name+"WHERE _id = id");
        return count;
    }*/

    public void dropTable(String tablename){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+tablename);
        Log.i("infomata","table deleted");
    }

    public boolean updateData(String id,String name, String count){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0,id);
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,count);
        db.update(Table_Name,contentValues,"_id = ?", new String[]{ id });
        return true;
    }

    public void updateCount(Long id, int value){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE "+Table_Name+" SET "+COL_2+" = "+COL_2+" + "+value+" WHERE _id = "+id);
    }

    public void updateCountSubtract(Long id,int value){

        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.execSQL("UPDATE " + Table_Name + " SET " + COL_2 + " = " + COL_2 + " - " + value + " WHERE _id = " + id);

            }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
