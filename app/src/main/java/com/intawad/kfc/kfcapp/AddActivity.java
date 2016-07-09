package com.intawad.kfc.kfcapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        // btnSave (Save)
        final Button save = (Button) findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // If Save Complete
                if(SaveData())
                {
                    // Open Form Main
                    Intent newActivity = new Intent(AddActivity.this,MainActivity.class);
                    startActivity(newActivity);
                }
            }
        });


        // btnCancel (Cancel)
        final Button cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Open Form Main
                Intent newActivity = new Intent(AddActivity.this,MainActivity.class);
                startActivity(newActivity);
            }
        });

    }

    public boolean SaveData()
    {
        // กดหนดตัวแปลจะเก็บลงฐานข้อมูล
        final EditText tDistanceID = (EditText) findViewById(R.id.txtDistanceID);
        final EditText tYear = (EditText) findViewById(R.id.txtYear);
        final EditText tNew = (EditText) findViewById(R.id.txtNew);
        final EditText tRoot1 = (EditText) findViewById(R.id.txtRoot1);
        final EditText tRoot2 = (EditText) findViewById(R.id.txtRoot2);
        final EditText tCare1 = (EditText) findViewById(R.id.txtCare1);
        final EditText tCare2 = (EditText) findViewById(R.id.txtCare2);
        final EditText tReady = (EditText) findViewById(R.id.txtReady);
        final EditText tGas1 = (EditText) findViewById(R.id.txtGas1);
        final EditText tGas2 = (EditText) findViewById(R.id.txtGas2);
        final EditText tDay35 = (EditText) findViewById(R.id.txtDay35);
        final EditText tDay45 = (EditText) findViewById(R.id.txtDay45);
        final EditText tDay60 = (EditText) findViewById(R.id.txtDay60);
        final EditText tDay75 = (EditText) findViewById(R.id.txtDay75);
        final EditText tDay85 = (EditText) findViewById(R.id.txtDay85);
        final EditText tDay100 = (EditText) findViewById(R.id.txtDay100);
        final EditText tDay120 = (EditText) findViewById(R.id.txtDay120);
        final EditText tDay135 = (EditText) findViewById(R.id.txtDay135);
        final EditText tDay150 = (EditText) findViewById(R.id.txtDay150);
        final EditText tDie = (EditText) findViewById(R.id.txtDie);




        // Dialog
        final AlertDialog.Builder adb = new AlertDialog.Builder(this);
        AlertDialog ad = adb.create();

        // Check MemberID
        if(tDistanceID.getText().length() == 0)
        {
            ad.setMessage("กรุณาใส่จุดและข้อมูลระยะสับปะรด !!! ");
            ad.show();
            tDistanceID.requestFocus();
            return false;
        }

        // new Class DB
        final myDBClass myDb = new myDBClass(this);

        // Check Data DistanceID already exits!
        String arrData[] = myDb.SelectData(tDistanceID.getText().toString());
        if(arrData != null)
        {
            ad.setMessage("จุดนี้ซ้ำกับในฐานข้อมูล!  ");
            ad.show();
            tDistanceID.requestFocus();
            return false;
        }

        // Save Data
        long saveStatus = myDb.InsertData(tDistanceID.getText().toString(),
                tYear.getText().toString(),
                tNew.getText().toString(),
                tRoot1.getText().toString(),
                tRoot2.getText().toString(),
                tCare1.getText().toString(),
                tCare2.getText().toString(),
                tReady.getText().toString(),
                tGas1.getText().toString(),
                tGas2.getText().toString(),
                tDay35.getText().toString(),
                tDay45.getText().toString(),
                tDay60.getText().toString(),
                tDay75.getText().toString(),
                tDay85.getText().toString(),
                tDay100.getText().toString(),
                tDay120.getText().toString(),
                tDay135.getText().toString(),
                tDay150.getText().toString(),
                tDie.getText().toString());

        if(saveStatus <=  0)
        {
            ad.setMessage("Error!! ");
            ad.show();
            return false;
        }

        Toast.makeText(AddActivity.this,"Add Data Successfully. ",
                Toast.LENGTH_SHORT).show();

        return true;
    }

}
