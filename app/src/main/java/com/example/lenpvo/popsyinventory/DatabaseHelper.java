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

    public static final String Table1_Name = "trtable";
    public static final String COL1_0 = "_id";
    public static final String COL1_1 = "trname";
    public static final String COL1_2 = "trcount";
    public static final String COL1_3 = "trdt";

    public static final String Table2_Name = "trprtable";
    public static final String COL2_0 = "_id";
    public static final String COL2_1 = "trprname";
    public static final String COL2_2 = "trprcount";
    public static final String COL2_3 = "trprdt";

    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 7);
    }

    public class dbColumns{
        public static final String BTID = "_id";
        public static final String BTNAME = "btlname";
        public static final String BTCOUNT = "btlcount";
        public static final String TRNAME = "trname";
        public static final String TRCOUNT = "trcount";
        public static final String TRDT = "trdt";
        public static final String TRPRNAME = "trprname";
        public static final String TRPRCOUNT = "trprcount";
        public static final String TRPRDT = "trprdt";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = " CREATE TABLE "+Table_Name+" ("+COL_0+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_1+" VARCHAR UNIQUE, "+COL_2+" INTEGER);";
        String createTable1 = " CREATE TABLE " +Table1_Name+" ("+COL1_0+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL1_1+" VARCHAR, "+COL1_2+" INT, "+COL1_3+" DATETIME DEFAULT CURRENT_TIMESTAMP);";
        String createTable2 = " CREATE TABLE " +Table2_Name+" ("+COL2_0+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL2_1+" VARCHAR, "+COL2_2+" INT, "+COL2_3+" DATETIME DEFAULT CURRENT_TIMESTAMP);";
        db.execSQL(createTable);
        db.execSQL(createTable1);
        db.execSQL(createTable2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        db.execSQL("DROP TABLE IF EXISTS "+Table1_Name);
        db.execSQL("DROP TABLE IF EXISTS "+Table2_Name);
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

    public boolean insertData1(String trname,int trcount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1_1,trname);
        contentValues.put(COL1_2,trcount);

        long result = db.insert(Table1_Name,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData2(String trname,int trcount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2_1,trname);
        contentValues.put(COL2_2,trcount);

        long result = db.insert(Table2_Name,null,contentValues);
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

    public Cursor getAllData1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Table1_Name+ " ORDER BY "+COL1_3+" DESC", null);
        return c;
    }

    public Cursor getAllData2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Table2_Name+ " ORDER BY "+COL2_3+" DESC", null);
        return c;
    }

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
