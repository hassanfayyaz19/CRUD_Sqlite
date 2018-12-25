package com.example.hassan.crud_sqlite;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText t1, t2, t3, t4;
    DatabaseHelper db;
    String name,roll,section,dep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        t1 = findViewById(R.id.editText);
        t2 = findViewById(R.id.editText2);
        t3 = findViewById(R.id.editText3);
        t4 = findViewById(R.id.editText4);

        db = new DatabaseHelper(this);


    }

    public void insert(View view) {
        name = t1.getText().toString();
        roll = t2.getText().toString().trim();
        section = t3.getText().toString();
        dep = t4.getText().toString();
         if (name.isEmpty() && roll.isEmpty() && section.isEmpty() && dep.isEmpty()) {
            Toast.makeText(this, "Enter Data First", Toast.LENGTH_SHORT).show();
        } else {

            boolean result= db.insertData(name,roll,section,dep);
            if(result==true)
            {
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
            }else
                {
                    Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
                }

        }
    }
}
