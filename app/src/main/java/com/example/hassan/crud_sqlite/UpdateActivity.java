package com.example.hassan.crud_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText t1, t2, t3, t4;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        t1 = findViewById(R.id.editText6);
        t2 = findViewById(R.id.editText7);
        t3 = findViewById(R.id.editText8);
        t4 = findViewById(R.id.editText9);

        db = new DatabaseHelper(this);
    }

    public void update(View view) {
        String roll = t1.getText().toString();
        String name = t2.getText().toString();
        String sec = t3.getText().toString();
        String dep = t4.getText().toString();
        if (!(roll.isEmpty() && name.isEmpty() && sec.isEmpty() && dep.isEmpty())) {
            int result = db.updateData(name, roll, sec, dep);
            if (result == 1) {
                Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Not Updated", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Enter Data", Toast.LENGTH_SHORT).show();
        }

    }
}
