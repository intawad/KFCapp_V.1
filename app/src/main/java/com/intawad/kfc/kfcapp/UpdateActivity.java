package com.intawad.kfc.kfcapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends Activity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        // Read var from Intent
        Intent intent= getIntent();
        final String DisID = intent.getStringExtra("DisID");

        // Show Data
        ShowData(DisID);

        // btnSave (Save)
        final Button save = (Button) findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // If Save Complete
                if(UpdateData(DisID))
                {
                    // Open Form ListUpdate
                    Intent newActivity = new Intent(UpdateActivity.this,ListUpdateActivity.class);
                    startActivity(newActivity);
                }
            }
        });

        // btnCancel (Cancel)
        final Button cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Open Form ListUpdate
                Intent newActivity = new Intent(UpdateActivity.this,ListUpdateActivity.class);
                startActivity(newActivity);
            }
        });

    }

    public void ShowData(String DisID)
    {

        final TextView tUpdateDistanceID = (TextView) findViewById(R.id.txtUpdateDistanceID);
        final EditText tUpdateYear = (EditText) findViewById(R.id.txtUpdateYear);
        final EditText tUpdateNew = (EditText) findViewById(R.id.txtUpdateNew);
        final EditText tUpdateRoot1 = (EditText) findViewById(R.id.txtUpdateRoot1);
        final EditText tUpdateRoot2 = (EditText) findViewById(R.id.txtUpdateRoot2);
        final EditText tUpdateCare1 = (EditText) findViewById(R.id.txtUpdateCare1);
        final EditText tUpdateCare2 = (EditText) findViewById(R.id.txtUpdateCare2);
        final EditText tUpdateReady = (EditText) findViewById(R.id.txtUpdateReady);
        final EditText tUpdateGas1 = (EditText) findViewById(R.id.txtUpdateGas1);
        final EditText tUpdateGas2 = (EditText) findViewById(R.id.txtUpdateGas2);
        final EditText tUpdateDay35 = (EditText) findViewById(R.id.txtUpdateDay35);
        final EditText tUpdateDay45 = (EditText) findViewById(R.id.txtUpdateDay45);
        final EditText tUpdateDay60 = (EditText) findViewById(R.id.txtUpdateDay60);
        final EditText tUpdateDay75 = (EditText) findViewById(R.id.txtUpdateDay75);
        final EditText tUpdateDay85 = (EditText) findViewById(R.id.txtUpdateDay85);
        final EditText tUpdateDay100 = (EditText) findViewById(R.id.txtUpdateDay100);
        final EditText tUpdateDay120 = (EditText) findViewById(R.id.txtUpdateDay120);
        final EditText tUpdateDay135 = (EditText) findViewById(R.id.txtUpdateDay135);
        final EditText tUpdateDay150 = (EditText) findViewById(R.id.txtUpdateDay150);
        final EditText tUpdateDie = (EditText) findViewById(R.id.txtUpdateDie);

        // new Class DB
        final myDBClass myDb = new myDBClass(this);

        // Show Data
        String arrData[] = myDb.SelectData(DisID);
        if(arrData != null)
        {
            tUpdateDistanceID.setText(arrData[0]);
            tUpdateYear.setText(arrData[1]);
            tUpdateNew.setText(arrData[2]);
            tUpdateRoot1.setText(arrData[3]);
            tUpdateRoot2.setText(arrData[4]);
            tUpdateCare1.setText(arrData[5]);
            tUpdateCare2.setText(arrData[6]);
            tUpdateReady.setText(arrData[7]);
            tUpdateGas1.setText(arrData[8]);
            tUpdateGas2.setText(arrData[9]);
            tUpdateDay35.setText(arrData[10]);
            tUpdateDay45.setText(arrData[11]);
            tUpdateDay60.setText(arrData[12]);
            tUpdateDay75.setText(arrData[13]);
            tUpdateDay85.setText(arrData[14]);
            tUpdateDay100.setText(arrData[15]);
            tUpdateDay120.setText(arrData[16]);
            tUpdateDay135.setText(arrData[17]);
            tUpdateDay150.setText(arrData[18]);
            tUpdateDie.setText(arrData[19]);

        }

    }

    public boolean UpdateData(String DisID)
    {


        final EditText tUpdateYear = (EditText) findViewById(R.id.txtUpdateYear);
        final EditText tUpdateNew = (EditText) findViewById(R.id.txtUpdateNew);
        final EditText tUpdateRoot1 = (EditText) findViewById(R.id.txtUpdateRoot1);
        final EditText tUpdateRoot2 = (EditText) findViewById(R.id.txtUpdateRoot2);
        final EditText tUpdateCare1 = (EditText) findViewById(R.id.txtUpdateCare1);
        final EditText tUpdateCare2 = (EditText) findViewById(R.id.txtUpdateCare2);
        final EditText tUpdateReady = (EditText) findViewById(R.id.txtUpdateReady);
        final EditText tUpdateGas1 = (EditText) findViewById(R.id.txtUpdateGas1);
        final EditText tUpdateGas2 = (EditText) findViewById(R.id.txtUpdateGas2);
        final EditText tUpdateDay35 = (EditText) findViewById(R.id.txtUpdateDay35);
        final EditText tUpdateDay45 = (EditText) findViewById(R.id.txtUpdateDay45);
        final EditText tUpdateDay60 = (EditText) findViewById(R.id.txtUpdateDay60);
        final EditText tUpdateDay75 = (EditText) findViewById(R.id.txtUpdateDay75);
        final EditText tUpdateDay85 = (EditText) findViewById(R.id.txtUpdateDay85);
        final EditText tUpdateDay100 = (EditText) findViewById(R.id.txtUpdateDay100);
        final EditText tUpdateDay120 = (EditText) findViewById(R.id.txtUpdateDay120);
        final EditText tUpdateDay135 = (EditText) findViewById(R.id.txtUpdateDay135);
        final EditText tUpdateDay150 = (EditText) findViewById(R.id.txtUpdateDay150);
        final EditText tUpdateDie = (EditText) findViewById(R.id.txtUpdateDie);

        // Dialog
        final AlertDialog.Builder adb = new AlertDialog.Builder(this);
        AlertDialog ad = adb.create();

//        // Check Year
//        if(tUpdateYear.getText().length() == 0)
//        {
//            ad.setMessage("Please input [Year] ");
//            ad.show();
//            tUpdateYear.requestFocus();
//            return false;
//        }
//
//        // Check New
//        if(tUpdateNew.getText().length() == 0)
//        {
//            ad.setMessage("Please input [New] ");
//            ad.show();
//            tUpdateNew.requestFocus();
//            return false;
//        }

        // new Class DB
        final myDBClass myDb = new myDBClass(this);

        // Save Data
        long saveStatus = myDb.UpdateData(DisID,
                tUpdateYear.getText().toString(),
                tUpdateNew.getText().toString(),
                tUpdateRoot1.getText().toString(),
                tUpdateRoot2.getText().toString(),
                tUpdateCare1.getText().toString(),
                tUpdateCare2.getText().toString(),
                tUpdateReady.getText().toString(),
                tUpdateGas1.getText().toString(),
                tUpdateGas2.getText().toString(),
                tUpdateDay35.getText().toString(),
                tUpdateDay45.getText().toString(),
                tUpdateDay60.getText().toString(),
                tUpdateDay75.getText().toString(),
                tUpdateDay85.getText().toString(),
                tUpdateDay100.getText().toString(),
                tUpdateDay120.getText().toString(),
                tUpdateDay135.getText().toString(),
                tUpdateDay150.getText().toString(),
                tUpdateDie.getText().toString());
        if(saveStatus <=  0)
        {
            ad.setMessage("Error!! ");
            ad.show();
            return false;
        }

        Toast.makeText(UpdateActivity.this,"Update Data Successfully. ",
                Toast.LENGTH_SHORT).show();

        return true;

    }

}
