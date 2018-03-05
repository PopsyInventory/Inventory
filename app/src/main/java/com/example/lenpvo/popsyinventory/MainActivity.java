package com.example.lenpvo.popsyinventory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lenpvo.popsyinventory.InventoryActivity;
import com.example.lenpvo.popsyinventory.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> bottles = new ArrayList<>();

    public void toInventoryActivity(View view){
        Intent intent = new Intent(getApplicationContext(),InventoryActivity.class);
        startActivity(intent);
    }

    public void toNewBottleActivity(View view){
        Intent intent = new Intent(getApplicationContext(),NewBottleActivity.class);
        intent.putStringArrayListExtra("list1", bottles);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
