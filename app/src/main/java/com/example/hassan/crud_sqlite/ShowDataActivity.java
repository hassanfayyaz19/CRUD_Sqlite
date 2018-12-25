package com.example.hassan.crud_sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDataActivity extends AppCompatActivity {

    DatabaseHelper db;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        db=new DatabaseHelper(this);
        textView=findViewById(R.id.textView3);
        ViewData();
    }

    public void ViewData() {
        Cursor cursor = db.AllData();
        if (cursor.getCount() != 0) {
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()) {

                buffer.append("Name : " + cursor.getString(1) + "\n");
                buffer.append("Roll NO : " + cursor.getString(2) + "\n");
                buffer.append("Section : " + cursor.getString(3) + "\n");
                buffer.append("Department : " + cursor.getString(4) + "\n");
                buffer.append("------------------------------------------"+"\n")
                ;
            }
            textView.setText(buffer.toString());
        }
    }

}
