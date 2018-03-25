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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class NewBottleActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    public void insertInDatabase(String str){

        int i = 0;
        boolean isInserted = myDb.insertData(str,i);
        if(isInserted)
            Log.i("infomata","Data inserted");
        else
            Log.i("infomata","Data not inserted");

    }

    public void clickFunc(View view){

        //final SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lenpvo.popsyinventory", Context.MODE_PRIVATE);

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        EditText myTF;
                        myTF = (EditText) findViewById(R.id.newtf);

                        //db.execSQL("INSERT INTO bottles (name,count) VALUES ('chorus',500)");
                        insertInDatabase(myTF.getText().toString());

                        //Log.i("info",myTF.getText().toString());
        /*                Intent i = getIntent();
                        ArrayList<String> newBottlesList = i.getStringArrayListExtra("list2");
                        Log.i("newBottlesList1",newBottlesList.toString());
                        try {
                            newBottlesList = (ArrayList) ObjectSerializer.deserialize(sharedPreferences.getString("bottleslist",ObjectSerializer.serialize(new ArrayList<String>())));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //ArrayList<String> BottlesList = i.getStringArrayListExtra("list1");
                        newBottlesList.add(myTF.getText().toString());
                        //static ArrayList<String> exlist = new ArrayList<>();
                        //exlist.add("monica");
                        //exlist.add("chandler");
                        try {
                            sharedPreferences.edit().putString("bottleslist",ObjectSerializer.serialize(newBottlesList)).apply();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //Intent intent = new Intent(getApplicationContext(),InventoryActivity.class);
                        //intent.putStringArrayListExtra("list2", newBottlesList);
                        Log.i("newBottlesList2",newBottlesList.toString());
        */
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
        myDb = new DatabaseHelper(this);
        //ArrayList newBottlesList = MainActivity.bottles;
        /*SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lenpvo.popsyinventory", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("newBottle","chorus500ml").apply();
        String bottle = sharedPreferences.getString("newBottle","");
        Log.i("newBottle",bottle);*/
    }
}
