package com.intawad.kfc.kfcapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button1 (Add)
        final Button btn1 = (Button) findViewById(R.id.button1);
        // Perform action on click
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form Add
                Intent newActivity = new Intent(MainActivity.this,AddActivity.class);
                startActivity(newActivity);

            }
        });

        // Button2 (Delete)
        final Button btn2 = (Button) findViewById(R.id.btndelete);
        // Perform action on click
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form ListDelete
                Intent newActivity = new Intent(MainActivity.this,ListDeleteActivity.class);
                startActivity(newActivity);

            }
        });

//        // Button3 (Update)
        final Button btn3 = (Button) findViewById(R.id.btnedit);
        // Perform action on click
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form ListUpdate
                Intent newActivity = new Intent(MainActivity.this,ListUpdateActivity.class);
                startActivity(newActivity);

            }
        });

        // Button4 (Show)
        final Button btn4 = (Button) findViewById(R.id.btnshow);
        // Perform action on click
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form Show
                Intent newActivity = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(newActivity);

            }
        });

        // Button5 (Result)
        final Button btn5 = (Button) findViewById(R.id.btnresult);
        // Perform action on click
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form Show
                Intent newActivity = new Intent(MainActivity.this,ResultActivity.class);
                startActivity(newActivity);

            }
        });

    }


}
