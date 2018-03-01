package com.example.lenpvo.popsyinventory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class NewBottleActivity extends AppCompatActivity {

    public void AddNewBottle(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bottle);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lenpvo.popsyinventory", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("newBottle","chorus500ml");
        String bottle = sharedPreferences.getString("newBottle","");
        Log.i("newBottle",bottle);
    }
}
