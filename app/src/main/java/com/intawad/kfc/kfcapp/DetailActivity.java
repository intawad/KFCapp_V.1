package com.intawad.kfc.kfcapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends Activity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Read var from Intent
        Intent intent= getIntent();
        String DisID = intent.getStringExtra("DisID");

        // Show Data
        ShowData(DisID);

        // btnCancel (Cancel)
        final Button cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Open Form Show
                Intent newActivity = new Intent(DetailActivity.this,ShowActivity.class);
                startActivity(newActivity);
            }
        });

    }

    public void ShowData(String DisID)
    {

        final TextView tDistanceID = (TextView) findViewById(R.id.txtShowDistanceID);
        final TextView tYear = (TextView) findViewById(R.id.txtShowYear);
        final TextView tNew = (TextView) findViewById(R.id.txtShowNew);
        final TextView tRoot1 = (TextView) findViewById(R.id.txtShowRoot1);
        final TextView tRoot2 = (TextView) findViewById(R.id.txtShowRoot2);
        final TextView tCare1 = (TextView) findViewById(R.id.txtShowCare1);
        final TextView tCare2 = (TextView) findViewById(R.id.txtShowCare2);
        final TextView tReady = (TextView) findViewById(R.id.txtShowReady);
        final TextView tGas1 = (TextView) findViewById(R.id.txtShowGas1);
        final TextView tGas2 = (TextView) findViewById(R.id.txtShowGas2);
        final TextView tDay35 = (TextView) findViewById(R.id.txtShowDay35);
        final TextView tDay45 = (TextView) findViewById(R.id.txtShowDay45);
        final TextView tDay60 = (TextView) findViewById(R.id.txtShowDay60);
        final TextView tDay75 = (TextView) findViewById(R.id.txtShowDay75);
        final TextView tDay85 = (TextView) findViewById(R.id.txtShowDay85);
        final TextView tDay100 = (TextView) findViewById(R.id.txtShowDay100);
        final TextView tDay120 = (TextView) findViewById(R.id.txtShowDay120);
        final TextView tDay135 = (TextView) findViewById(R.id.txtShowDay135);
        final TextView tDay150 = (TextView) findViewById(R.id.txtShowDay150);
        final TextView tDie = (TextView) findViewById(R.id.txtShowDie);




        // new Class DB
        final myDBClass myDb = new myDBClass(this);

        // Show Data
        String arrData[] = myDb.SelectData(DisID);
        if(arrData != null)
        {
            tDistanceID.setText(arrData[0]);
            tYear.setText(arrData[1]);
            tNew.setText(arrData[2]);
            tRoot1.setText(arrData[3]);
            tRoot2.setText(arrData[4]);
            tCare1.setText(arrData[5]);
            tCare2.setText(arrData[6]);
            tReady.setText(arrData[7]);
            tGas1.setText(arrData[8]);
            tGas2.setText(arrData[9]);
            tDay35.setText(arrData[10]);
            tDay45.setText(arrData[11]);
            tDay60.setText(arrData[12]);
            tDay75.setText(arrData[13]);
            tDay85.setText(arrData[14]);
            tDay100.setText(arrData[15]);
            tDay120.setText(arrData[16]);
            tDay135.setText(arrData[17]);
            tDay150.setText(arrData[18]);
            tDie.setText(arrData[19]);

        }

    }

}

