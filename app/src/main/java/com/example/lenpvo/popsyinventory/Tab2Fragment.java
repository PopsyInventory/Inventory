package com.example.lenpvo.popsyinventory;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class Tab2Fragment extends Fragment {

    DatabaseHelper myDb;
    private Spinner spinner;
    private EditText ntobesubtracted;
    private ArrayAdapter<CharSequence> sadapter;

    private Button btnTEST;

    public void onClicksubtractItems(View view){

        myDb = new DatabaseHelper(getActivity().getBaseContext());
        Cursor rescursor = myDb.getAllData();
        spinner = (Spinner) view.findViewById(R.id.spinnersubtract);
        rescursor.moveToPosition(spinner.getSelectedItemPosition());
        String resid = rescursor.getString(0);
        ntobesubtracted = (EditText)view.findViewById(R.id.countbtbsubtracted);
        int value=Integer.parseInt(ntobesubtracted.getText().toString());
        //myDb.updateCount(resid,value);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        //btnTEST = (Button)view.findViewById(R.id.btbsubtracted);

        myDb = new DatabaseHelper(getActivity().getBaseContext());

        Cursor res = myDb.getAllData();
        String[] fromFieldNames = new String[]{DatabaseHelper.dbColumns.BTNAME,DatabaseHelper.dbColumns.BTCOUNT};
        int[] toViewIDs = new int[]{R.id.textViewBottleName,R.id.textViewBottleCount};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getActivity().getBaseContext(), R.layout.item_layout, res, fromFieldNames, toViewIDs, 0);
        spinner = (Spinner) view.findViewById(R.id.spinnersubtract);
        spinner.setAdapter(myCursorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("infomata", adapterView.getItemAtPosition(i).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final Button button = (Button) view.findViewById(R.id.subtractbuttonid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor rescursor = myDb.getAllData();
                rescursor.moveToPosition(spinner.getSelectedItemPosition());
                Long resid = rescursor.getLong(rescursor.getColumnIndex("_id"));
                ntobesubtracted = (EditText)view.findViewById(R.id.countbtbsubtracted);
                int value=Integer.parseInt(ntobesubtracted.getText().toString());
                myDb.updateCountSubtract(resid,value);
                Toast.makeText(getActivity(),"Updated",Toast.LENGTH_LONG).show();
                ntobesubtracted.setText("");
                InputMethodManager inputManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(v.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });



        return view;
    }

}
