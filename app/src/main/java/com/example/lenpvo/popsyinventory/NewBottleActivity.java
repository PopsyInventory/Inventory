package com.example.lenpvo.popsyinventory;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NewBottleActivity extends AppCompatActivity {

    public void clickFunc(View view){

        EditText myTF;
        myTF = (EditText) findViewById(R.id.newtf);
        Log.i("info",myTF.getText().toString());
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lenpvo.popsyinventory", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("newBottle","chorus500ml");
        String bottle = sharedPreferences.getString("newBottle","");
        Log.i("newBottle",bottle);
        Log.i("info","something");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bottle);
        /*SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lenpvo.popsyinventory", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("newBottle","chorus500ml");
        String bottle = sharedPreferences.getString("newBottle","");
        Log.i("newBottle",bottle);*/
    }
}
