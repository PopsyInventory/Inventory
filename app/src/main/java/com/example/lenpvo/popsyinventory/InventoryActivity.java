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
    }

    private void populateListView(){
        Cursor res = myDb.getAllData();
        String[] fromFieldNames = new String[] {DatabaseHelper.dbColumns.BTNAME,DatabaseHelper.dbColumns.BTCOUNT};
        int[] toViewIDs = new int[] {R.id.textViewBottleName,R.id.textViewBottleCount};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.item_layout,res,fromFieldNames,toViewIDs,0);
        ListView myList = (ListView) findViewById(R.id.lvId);
        myList.setAdapter(myCursorAdapter);
    }
}
