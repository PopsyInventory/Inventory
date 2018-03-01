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

public class MainActivity extends AppCompatActivity {

    public void toInventoryActivity(View view){
        Intent intent = new Intent(getApplicationContext(),InventoryActivity.class);
        startActivity(intent);
    }

    public void toNewBottleActivity(View view){
        Intent intent = new Intent(getApplicationContext(),NewBottleActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
