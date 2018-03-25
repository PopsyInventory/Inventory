package com.example.lenpvo.popsyinventory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.IOException;
import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {

    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        myDb = new DatabaseHelper(this);

        Intent i = getIntent();

        populateListView();
    //    ArrayList<String> newBottlesList = i.getStringArrayListExtra("list2");

        /*try{

        }
        catch (Exception e){
            e.printStackTrace();
        }*/
                /*if(res.getCount() == 0)
        {
            //show message
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("bname : "+res.getString(0) + "\n");
        }*/
    /*    else{
            int nameIndex = c.getColumnIndex("name");
            int countIndex = c.getColumnIndex("count");

            c.moveToFirst();
            while(c!=null){
                Log.i("bname",c.getString(nameIndex));
                Log.i("bcount",c.getString(countIndex));
                c.moveToNext();
            }
        }
    */
        /*final SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lenpvo.popsyinventory", Context.MODE_PRIVATE);

        try {
            newBottlesList = (ArrayList) ObjectSerializer.deserialize(sharedPreferences.getString("bottleslist",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        //ArrayList<String> newBottlesList = i.getStringArrayListExtra("list2");
        //ArrayList<String> examplist = new ArrayList<>();
        //String[] lsit = {"i1","i2","i3","i4"};
       /* ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, newBottlesList);
        try {
            ListView lv = (ListView) findViewById(R.id.lItem);
            lv.setAdapter(itemsAdapter);
        }catch (Exception e)
        {
            Log.i("infom",e.toString());
        }
       */
    }

    private void populateListView(){
        Cursor res = myDb.getAllData();
        String[] fromFieldNames = new String[] {DatabaseHelper.dbColumns.BTNAME,DatabaseHelper.dbColumns.BTCOUNT};
        int[] toViewIDs = new int[] {R.id.textViewBottleName,R.id.textViewBottleCount};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.item_layout,res,fromFieldNames,toViewIDs,0);
        ListView myList = (ListView) findViewById(R.id.lvId);
        myList.setAdapter(myCursorAdapter);

        //int[] toViewIDs = new int[] {R.id.textViewItemNumber,}
    /*    ArrayList<String> listData = new ArrayList<>();
        while(res.moveToNext()){
            listData.add(res.getString(0));
        }
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData);
        try {
            ListView lv = (ListView) findViewById(R.id.lvId);
            lv.setAdapter(itemsAdapter);
        }catch (Exception e)
        {
            Log.i("infom",e.toString());
        }
    */
    }
}
