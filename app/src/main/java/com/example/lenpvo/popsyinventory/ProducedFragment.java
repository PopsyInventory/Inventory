package com.example.lenpvo.popsyinventory;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ProducedFragment extends Fragment {

    DatabaseHelper myDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_produced, container, false);

        myDb = new DatabaseHelper(getActivity().getBaseContext());
        populateListView(view);

        return view;
    }

    private void populateListView(View v){
        Cursor res = myDb.getAllData2();
        String[] fromFieldNames = new String[] {DatabaseHelper.dbColumns.TRPRNAME,DatabaseHelper.dbColumns.TRPRCOUNT,DatabaseHelper.dbColumns.TRPRDT};
        int[] toViewIDs = new int[] {R.id.trnameproduced,R.id.trcountproduced,R.id.trdtproduced};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getActivity().getBaseContext(),R.layout.item_layout_produced,res,fromFieldNames,toViewIDs,0);
        ListView myList = (ListView) v.findViewById(R.id.listId_produced);
        myList.setAdapter(myCursorAdapter);
    }
}
