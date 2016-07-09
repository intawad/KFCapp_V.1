package com.intawad.kfc.kfcapp;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by intawad-NB on 9/7/2559.
 */
public class ResultActivity extends Activity {
    public static SQLiteDatabase db;
//    Cursor c;
    int amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        SQLiteDatabase db = openOrCreateDatabase(myDBClass.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("SELECT sum(New)*100/2500 FROM kfcdata", null);;
        cursor.moveToFirst();
        amount = cursor.getInt(0);
        cursor.close();
        TextView ltxt = (TextView) findViewById(R.id.txtResultNew);
        ltxt.setText(amount + "%"  );



    }
}


