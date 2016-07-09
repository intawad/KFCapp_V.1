package com.intawad.kfc.kfcapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class myDBClass extends SQLiteOpenHelper {


    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "mydatabase.db";

    // Table Name
    private static final String TABLE_MEMBER = "kfcdata";

    public myDBClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        // Create Table Name
        db.execSQL("CREATE TABLE " + TABLE_MEMBER +
                "(DistanceID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Year TEXT(10)," +
                " New TEXT(10)," +
                " Root1 TEXT(10)," +
                " Root2 TEXT(10)," +
                " Care1 TEXT(10)," +
                " Care2 TEXT(10)," +
                " Ready TEXT(10)," +
                " Gas1 TEXT(10)," +
                " Gas2 TEXT(10)," +
                " Day35 TEXT(10)," +
                " Day45 TEXT(10)," +
                " Day60 TEXT(10)," +
                " Day75 TEXT(10)," +
                " Day85 TEXT(10)," +
                " Day100 TEXT(10)," +
                " Day120 TEXT(10)," +
                " Day135 TEXT(10)," +
                " Day150 TEXT(10)," +
                " Die TEXT(10));");

        Log.d("CREATE TABLE","Create Table Successfully.");
    }

    // Insert Data
    public long InsertData(String strDistanceID, String strYear, String strNew, String strRoot1, String strRoot2, String strCare1
                            , String strCare2, String strReady, String strGas1, String strGas2, String strDay35, String strDay45
                            , String strDay60, String strDay75, String strDay85, String strDay100, String strDay120, String strDay135
                            , String strDay150, String strDie) {
        // TODO Auto-generated method stub

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            ContentValues Val = new ContentValues();
            Val.put("DistanceID", strDistanceID);
            Val.put("Year", strYear);
            Val.put("New", strNew);
            Val.put("Root1", strRoot1);
            Val.put("Root2", strRoot2);
            Val.put("Care1", strCare1);
            Val.put("Care2", strCare2);
            Val.put("Ready", strReady);
            Val.put("Gas1", strGas1);
            Val.put("Gas2", strGas2);
            Val.put("Day35", strDay35);
            Val.put("Day45", strDay45);
            Val.put("Day60", strDay60);
            Val.put("Day75", strDay75);
            Val.put("Day85", strDay85);
            Val.put("Day100", strDay100);
            Val.put("Day120", strDay120);
            Val.put("Day135", strDay135);
            Val.put("Day150", strDay150);
            Val.put("Die", strDie);


            long rows = db.insert(TABLE_MEMBER, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }


    // Delete Data
    public long DeleteData(String strDistanceID) {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            long rows = db.delete(TABLE_MEMBER, "DistanceID = ?",
                    new String[] { String.valueOf(strDistanceID) });

            db.close();
            return rows; // return rows deleted.

        } catch (Exception e) {
            return -1;
        }

    }

    // Select Data
    public String[] SelectData(String strDistanceID) {
        // TODO Auto-generated method stub

        try {
            String arrData[] = null;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(TABLE_MEMBER, new String[] { "*" },
                    "DistanceID=?",
                    new String[] { String.valueOf(strDistanceID) }, null, null, null, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getColumnCount()];
                    /***
                     *  0 = MemberID
                     *  1 = Name
                     *  2 = Tel
                     */
                    arrData[0] = cursor.getString(0);
                    arrData[1] = cursor.getString(1);
                    arrData[2] = cursor.getString(2);
                    arrData[3] = cursor.getString(3);
                    arrData[4] = cursor.getString(4);
                    arrData[5] = cursor.getString(5);
                    arrData[6] = cursor.getString(6);
                    arrData[7] = cursor.getString(7);
                    arrData[8] = cursor.getString(8);
                    arrData[9] = cursor.getString(9);
                    arrData[10] = cursor.getString(10);
                    arrData[11] = cursor.getString(11);
                    arrData[12] = cursor.getString(12);
                    arrData[13] = cursor.getString(13);
                    arrData[14] = cursor.getString(14);
                    arrData[15] = cursor.getString(15);
                    arrData[16] = cursor.getString(16);
                    arrData[17] = cursor.getString(17);
                    arrData[18] = cursor.getString(18);
                    arrData[19] = cursor.getString(19);
                }
            }
            cursor.close();
            db.close();
            return arrData;

        } catch (Exception e) {
            return null;
        }

    }



    // Show All Data
    public ArrayList<HashMap<String, String>> SelectAllData() {
        // TODO Auto-generated method stub

        try {

            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  * FROM " + TABLE_MEMBER;
            Cursor cursor = db.rawQuery(strSQL, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {
                    do {
                        map = new HashMap<String, String>();
                        map.put("DistanceID", cursor.getString(0));
                        map.put("Year", cursor.getString(1));
                        map.put("New", cursor.getString(2));
                        map.put("Root1", cursor.getString(3));
                        map.put("Root2", cursor.getString(4));
                        map.put("Care1", cursor.getString(5));
                        map.put("Care2", cursor.getString(6));
                        map.put("Ready", cursor.getString(7));
                        map.put("Gas1", cursor.getString(8));
                        map.put("Gas2", cursor.getString(9));
                        map.put("Day35", cursor.getString(10));
                        map.put("Day45", cursor.getString(11));
                        map.put("Day60", cursor.getString(12));
                        map.put("Day75", cursor.getString(13));
                        map.put("Day85", cursor.getString(14));
                        map.put("Day100", cursor.getString(15));
                        map.put("Day120", cursor.getString(16));
                        map.put("Day135", cursor.getString(17));
                        map.put("Day150", cursor.getString(18));
                        map.put("Die", cursor.getString(19));
                        MyArrList.add(map);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;

        } catch (Exception e) {
            return null;
        }

    }

    // Update Data
    public long UpdateData(String strDistanceID, String strYear, String strNew, String strRoot1, String strRoot2, String strCare1
            , String strCare2, String strReady, String strGas1, String strGas2, String strDay35, String strDay45
            , String strDay60, String strDay75, String strDay85, String strDay100, String strDay120, String strDay135
            , String strDay150, String strDie) {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            ContentValues Val = new ContentValues();
            Val.put("DistanceID", strDistanceID);
            Val.put("Year", strYear);
            Val.put("New", strNew);
            Val.put("Root1", strRoot1);
            Val.put("Root2", strRoot2);
            Val.put("Care1", strCare1);
            Val.put("Care2", strCare2);
            Val.put("Ready", strReady);
            Val.put("Gas1", strGas1);
            Val.put("Gas2", strGas2);
            Val.put("Day35", strDay35);
            Val.put("Day45", strDay45);
            Val.put("Day60", strDay60);
            Val.put("Day75", strDay75);
            Val.put("Day85", strDay85);
            Val.put("Day100", strDay100);
            Val.put("Day120", strDay120);
            Val.put("Day135", strDay135);
            Val.put("Day150", strDay150);
            Val.put("Die", strDie);

            long rows = db.update(TABLE_MEMBER, Val, " DistanceID = ?",
                    new String[] { String.valueOf(strDistanceID) });

            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);

        // Re Create on method  onCreate
        onCreate(db);
    }

}
