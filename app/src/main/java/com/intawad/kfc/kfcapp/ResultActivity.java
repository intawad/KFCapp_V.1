package com.intawad.kfc.kfcapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by intawad-NB on 9/7/2559.
 */
public class ResultActivity extends Activity {
    public static SQLiteDatabase db;
//    Cursor c;
    float amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        SQLiteDatabase db = openOrCreateDatabase(myDBClass.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("SELECT sum(New)*100/2500 FROM kfcdata", null);
        cursor.moveToFirst();
        amount = cursor.getFloat(0);
        cursor.close();
        TextView ltxt = (TextView) findViewById(R.id.txtResultNew);
        ltxt.setText(amount + "%"  );

        Cursor cursor1 = db.rawQuery("SELECT sum(Root1)*100/2500 FROM kfcdata", null);
        cursor1.moveToFirst();
        amount = cursor1.getFloat(0);
        cursor1.close();
        TextView ltxt1 = (TextView) findViewById(R.id.txtResultRoot1);
        ltxt1.setText(amount + "%"  );

        Cursor cursor2 = db.rawQuery("SELECT sum(Root2)*100/2500 FROM kfcdata", null);
        cursor2.moveToFirst();
        amount = cursor2.getFloat(0);
        cursor2.close();
        TextView ltxt2 = (TextView) findViewById(R.id.txtResultRoot2);
        ltxt2.setText(amount + "%"  );

        Cursor cursor3 = db.rawQuery("SELECT sum(Care1)*100/2500 FROM kfcdata", null);
        cursor3.moveToFirst();
        amount = cursor3.getFloat(0);
        cursor3.close();
        TextView ltxt3 = (TextView) findViewById(R.id.txtResultCare1);
        ltxt3.setText(amount + "%"  );

        Cursor cursor4 = db.rawQuery("SELECT sum(Care2)*100/2500 FROM kfcdata", null);
        cursor4.moveToFirst();
        amount = cursor4.getFloat(0);
        cursor4.close();
        TextView ltxt4 = (TextView) findViewById(R.id.txtResultCare2);
        ltxt4.setText(amount + "%"  );

        Cursor cursor5 = db.rawQuery("SELECT sum(Ready)*100/2500 FROM kfcdata", null);
        cursor5.moveToFirst();
        amount = cursor5.getFloat(0);
        cursor5.close();
        TextView ltxt5 = (TextView) findViewById(R.id.txtResultReady);
        ltxt5.setText(amount + "%"  );


        Cursor cursor6 = db.rawQuery("SELECT sum(Gas1)*100/2500 FROM kfcdata", null);
        cursor6.moveToFirst();
        amount = cursor6.getFloat(0);
        cursor6.close();
        TextView ltxt6 = (TextView) findViewById(R.id.txtResultGas1);
        ltxt6.setText(amount + "%"  );

        Cursor cursor7 = db.rawQuery("SELECT sum(Gas2)*100/2500 FROM kfcdata", null);
        cursor7.moveToFirst();
        amount = cursor7.getFloat(0);
        cursor7.close();
        TextView ltxt7 = (TextView) findViewById(R.id.txtResultGas2);
        ltxt7.setText(amount + "%"  );

        Cursor cursor8 = db.rawQuery("SELECT sum(Day35)*100/2500 FROM kfcdata", null);
        cursor8.moveToFirst();
        amount = cursor8.getFloat(0);
        cursor8.close();
        TextView ltxt8 = (TextView) findViewById(R.id.txtResultDay35);
        ltxt8.setText(amount + "%"  );

        Cursor cursor9 = db.rawQuery("SELECT sum(Day45)*100/2500 FROM kfcdata", null);
        cursor9.moveToFirst();
        amount = cursor9.getFloat(0);
        cursor9.close();
        TextView ltxt9 = (TextView) findViewById(R.id.txtResultDay45);
        ltxt9.setText(amount + "%"  );

        Cursor cursor10 = db.rawQuery("SELECT sum(Day60)*100/2500 FROM kfcdata", null);
        cursor10.moveToFirst();
        amount = cursor10.getFloat(0);
        cursor10.close();
        TextView ltxt10 = (TextView) findViewById(R.id.txtResultDay60);
        ltxt10.setText(amount + "%"  );

        Cursor cursor11 = db.rawQuery("SELECT sum(Day75)*100/2500 FROM kfcdata", null);
        cursor11.moveToFirst();
        amount = cursor11.getFloat(0);
        cursor11.close();
        TextView ltxt11 = (TextView) findViewById(R.id.txtResultDay75);
        ltxt11.setText(amount + "%"  );

        Cursor cursor12 = db.rawQuery("SELECT sum(Day85)*100/2500 FROM kfcdata", null);
        cursor12.moveToFirst();
        amount = cursor12.getFloat(0);
        cursor12.close();
        TextView ltxt12 = (TextView) findViewById(R.id.txtResultDay85);
        ltxt12.setText(amount + "%"  );

        Cursor cursor13 = db.rawQuery("SELECT sum(Day100)*100/2500 FROM kfcdata", null);
        cursor13.moveToFirst();
        amount = cursor13.getFloat(0);
        cursor13.close();
        TextView ltxt13 = (TextView) findViewById(R.id.txtResultDay100);
        ltxt13.setText(amount + "%"  );

        Cursor cursor14 = db.rawQuery("SELECT sum(Day120)*100/2500 FROM kfcdata", null);
        cursor14.moveToFirst();
        amount = cursor14.getFloat(0);
        cursor14.close();
        TextView ltxt14 = (TextView) findViewById(R.id.txtResultDay120);
        ltxt14.setText(amount + "%"  );

        Cursor cursor15 = db.rawQuery("SELECT sum(Day135)*100/2500 FROM kfcdata", null);
        cursor15.moveToFirst();
        amount = cursor15.getFloat(0);
        cursor15.close();
        TextView ltxt15 = (TextView) findViewById(R.id.txtResultDay135);
        ltxt15.setText(amount + "%"  );

        Cursor cursor16 = db.rawQuery("SELECT sum(Day150)*100/2500 FROM kfcdata", null);
        cursor16.moveToFirst();
        amount = cursor16.getFloat(0);
        cursor16.close();
        TextView ltxt16 = (TextView) findViewById(R.id.txtResultDay150);
        ltxt16.setText(amount + "%"  );

        Cursor cursor17 = db.rawQuery("SELECT sum(Die)*100/2500 FROM kfcdata", null);
        cursor17.moveToFirst();
        amount = cursor17.getFloat(0);
        cursor17.close();
        TextView ltxt17 = (TextView) findViewById(R.id.txtResultDie);
        ltxt17.setText(amount + "%"  );


        // btnCancel (Cancel)
        final Button cancel = (Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Open Form Main
                Intent newActivity = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(newActivity);
            }
        });

    }
}


