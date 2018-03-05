package com.example.lenpvo.popsyinventory;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

public class NewBottleActivity extends AppCompatActivity {

    public void clickFunc(View view){

        final SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lenpvo.popsyinventory", Context.MODE_PRIVATE);

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        EditText myTF;
                        myTF = (EditText) findViewById(R.id.newtf);
                        //Log.i("info",myTF.getText().toString());
                        Intent i = getIntent();
                        ArrayList<String> BottlesList = i.getStringArrayListExtra("list1");
                        BottlesList.add(myTF.getText().toString());
                        try {
                            sharedPreferences.edit().putString("bottleslist",ObjectSerializer.serialize(BottlesList)).apply();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ArrayList<String> newBottlesList = new ArrayList<>();
                        try {
                            newBottlesList = (ArrayList) ObjectSerializer.deserialize(sharedPreferences.getString("bottleslist",ObjectSerializer.serialize(new ArrayList<String>())));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Log.i("newBottlesList",newBottlesList.toString());
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        dialog.cancel();
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to add a new bottle?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();


        //sharedPreferences.edit().putString("newBottle",myTF.getText().toString()).apply();
        //String bottle = sharedPreferences.getString("newBottle","");
        //Log.i("newBottle",bottle);
        //Log.i("info","something");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bottle);
        ArrayList newBottlesList = MainActivity.bottles;
        /*SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lenpvo.popsyinventory", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("newBottle","chorus500ml").apply();
        String bottle = sharedPreferences.getString("newBottle","");
        Log.i("newBottle",bottle);*/
    }
}
