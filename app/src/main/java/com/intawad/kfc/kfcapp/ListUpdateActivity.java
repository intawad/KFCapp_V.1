package com.intawad.kfc.kfcapp;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListUpdateActivity extends Activity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_update);

        final myDBClass myDb = new myDBClass(this);
        final ArrayList<HashMap<String, String>> MebmerList = myDb.SelectAllData();

        // listView1
        ListView lisView1 = (ListView)findViewById(R.id.listView1);

        SimpleAdapter sAdap;
        sAdap = new SimpleAdapter(ListUpdateActivity.this, MebmerList, R.layout.activity_column,
                new String[] {"DistanceID", "Year", "New", "Root1", "Root2", "Care1", "Care2", "Ready", "Gas1", "Gas2"
                        , "Day35", "Day45", "Day60", "Day75", "Day85", "Day100", "Day120", "Day135", "Day105", "Die"}
                , new int[] {R.id.ColDistanceID, R.id.ColYear});
                /*--, R.id.ColNew, R.id.ColRoot1, R.id.ColRoot2, R.id.ColCare1
                , R.id.ColCare2, R.id.ColReady, R.id.ColGas1, R.id.ColGas2, R.id.ColDay35, R.id.ColDay45, R.id.ColDay60
                , R.id.ColDay75, R.id.ColDay85, R.id.ColDay100, R.id.ColDay120, R.id.ColDay135, R.id.ColDay150, R.id.ColDie
                --*/
        lisView1.setAdapter(sAdap);

        lisView1.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int position, long mylng) {

                // Show on new activity
                Intent newActivity = new Intent(ListUpdateActivity.this,UpdateActivity.class);
                newActivity.putExtra("DisID", MebmerList.get(position).get("DistanceID").toString());
                startActivity(newActivity);

            }
        });


        // btnCancel (Cancel)
        final Button cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Open Form Main
                Intent newActivity = new Intent(ListUpdateActivity.this,MainActivity.class);
                startActivity(newActivity);
            }
        });

    }


}
