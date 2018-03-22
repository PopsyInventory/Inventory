package com.example.lenpvo.popsyinventory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        Intent i = getIntent();
        ArrayList<String> newBottlesList = i.getStringArrayListExtra("list2");

        final SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lenpvo.popsyinventory", Context.MODE_PRIVATE);

        try {
            newBottlesList = (ArrayList) ObjectSerializer.deserialize(sharedPreferences.getString("bottleslist",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ArrayList<String> newBottlesList = i.getStringArrayListExtra("list2");
        //ArrayList<String> examplist = new ArrayList<>();
        //String[] lsit = {"i1","i2","i3","i4"};
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, newBottlesList);
        try {
            ListView lv = (ListView) findViewById(R.id.lItem);
            lv.setAdapter(itemsAdapter);
        }catch (Exception e)
        {
            Log.i("infom",e.toString());
        }
    }
}
