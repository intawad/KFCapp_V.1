package com.intawad.kfc.kfcapp;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class ShowActivity extends Activity  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        final myDBClass myDb = new myDBClass(this);
        final ArrayList<HashMap<String, String>> MebmerList = myDb.SelectAllData();

        // listView1
        ListView lisView1 = (ListView)findViewById(R.id.listView1);

        SimpleAdapter sAdap;
        sAdap = new SimpleAdapter(ShowActivity.this, MebmerList, R.layout.activity_column,
                new String[] {"DistanceID", "Year"}, new int[] {R.id.ColDistanceID, R.id.ColYear});
        lisView1.setAdapter(sAdap);

        lisView1.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int position, long mylng) {

                // Show on new activity
                Intent newActivity = new Intent(ShowActivity.this,DetailActivity.class);
                newActivity.putExtra("DisID", MebmerList.get(position).get("DistanceID").toString());
                startActivity(newActivity);

            }
        });

        // btnCancel (Cancel)
        final Button cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Open Form Main
                Intent newActivity = new Intent(ShowActivity.this,MainActivity.class);
                startActivity(newActivity);
            }
        });

    }


}
