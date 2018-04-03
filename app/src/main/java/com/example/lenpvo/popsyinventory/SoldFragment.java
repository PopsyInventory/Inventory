package com.example.lenpvo.popsyinventory;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SoldFragment extends Fragment {

    DatabaseHelper myDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_sold, container, false);

        myDb = new DatabaseHelper(getActivity().getBaseContext());
        populateListView(view);

        return view;
    }

    private void populateListView(View v){
        Cursor res = myDb.getAllData1();
        String[] fromFieldNames = new String[] {DatabaseHelper.dbColumns.TRNAME,DatabaseHelper.dbColumns.TRCOUNT,DatabaseHelper.dbColumns.TRDT};
        int[] toViewIDs = new int[] {R.id.trnamesold,R.id.trcountsold,R.id.trdtsold};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getActivity().getBaseContext(),R.layout.item_layout_sold,res,fromFieldNames,toViewIDs,0);
        ListView myList = (ListView) v.findViewById(R.id.listId_sold);
        myList.setAdapter(myCursorAdapter);
    }

}
