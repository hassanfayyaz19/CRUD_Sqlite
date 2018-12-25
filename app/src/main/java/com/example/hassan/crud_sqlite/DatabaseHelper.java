package com.example.hassan.crud_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String Database = "School.db";
    private static final String Table = "Student";

    //constructor
    public DatabaseHelper(Context context) {
        super(context, Database, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Table + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,RollNO TEXT UNIQUE,Section TEXT,Department TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Table + "");
        onCreate(db);

    }


    //Insertion Function
    public boolean insertData(String name, String rollNO, String section, String department) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("RollNO", rollNO);
        values.put("Section", section);
        values.put("Department", department);

        long result = db.insert(Table, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    //View All Data
    public Cursor AllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String q = "SELECT * FROM " + Table + "";
        Cursor cursor = db.rawQuery(q, null);
        return cursor;
    }

    public int Delete(String rollNO) {
        SQLiteDatabase db = this.getWritableDatabase();

        int re = db.delete(Table, "RollNo ='" + rollNO + "'", null);
        Log.i("Delete", String.valueOf(re));
        if (re == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int updateData(String name, String roll, String section, String dep) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Section", section);
        values.put("Department", dep);
        int re=db.update(Table, values, "RollNO ='" + roll + "'", null);
        if (re == 1) {
            return 1;
        } else {
            return 0;
        }
    }


}
