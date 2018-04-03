package com.example.lenpvo.popsyinventory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lenpvo.popsyinventory.InventoryActivity;
import com.example.lenpvo.popsyinventory.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;

    //public static ArrayList<String> bottles = new ArrayList<>();
    //SQLiteDatabase db;
    public static ArrayList<String> newbottles = new ArrayList<>();

    public void toTransactionsActivity(View view){
        Intent intent = new Intent(getApplicationContext(),TransactionsActivity.class);
        startActivity(intent);
    }

    public void toUpdateActivity(View view){
        Intent intent = new Intent(getApplicationContext(),UpdateActivity.class);
        startActivity(intent);
    }

    public void toInventoryActivity(View view){
        Intent intent = new Intent(getApplicationContext(),InventoryActivity.class);
    //    intent.putStringArrayListExtra("list1", bottles);
    //    intent.putStringArrayListExtra("list2", newbottles);
        startActivity(intent);
    }

    public void toNewBottleActivity(View view){
        Intent intent = new Intent(getApplicationContext(),NewBottleActivity.class);
    //    intent.putStringArrayListExtra("list1", bottles);
    //    intent.putStringArrayListExtra("list2", newbottles);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

    /*    try{
            db = ((MyApplication)getApplication()).mDB;
            db = this.openOrCreateDatabase("Bottles",MODE_PRIVATE,null);
            String createtable = "CREATE TABLE IF NOT EXISTS bottles (bname VARCHAR PRIMARY KEY, bcount INT(7))";
            db.execSQL(createtable);
            //db.execSQL("INSERT INTO bottles (name,count) VALUES ('chorus',500)");
            //db.execSQL("INSERT INTO bottles (name,count) VALUES ('gol',1000)");

            Cursor c = db.rawQuery("SELECT * FROM bottles", null);

            int nameIndex = c.getColumnIndex("name");
            int countIndex = c.getColumnIndex("count");

            c.moveToFirst();
            while(c!=null){
                Log.i("bname",c.getString(nameIndex));
                Log.i("bcount",c.getString(countIndex));
                c.moveToNext();
            }

            //db.execSQL("DROP TABLE bottles");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            boolean isInserted = myDb.insertData("chorus", 500);
            if (isInserted)
                Log.i("INFOMATA", "yes");
            else
                Log.i("INFOMATA", "no");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    */
    }

}
