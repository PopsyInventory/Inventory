package com.example.lenpvo.popsyinventory;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class NewBottleActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText myTF;

    public void insertInDatabase(String str){
        int i = 0;
        boolean isInserted = myDb.insertData(str,i);
        if(isInserted)
            Toast.makeText(this,str+" added",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Could not be added",Toast.LENGTH_SHORT).show();
    }

    public void clickFunc(View view){

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        myTF = (EditText) findViewById(R.id.newtf);
                        insertInDatabase(myTF.getText().toString());
                        myTF.setText("");
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bottle);
        myDb = new DatabaseHelper(this);

        myTF = (EditText) findViewById(R.id.newtf);
        final Button button = (Button) findViewById(R.id.button);
        button.setEnabled(false);

        myTF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

    }
}
