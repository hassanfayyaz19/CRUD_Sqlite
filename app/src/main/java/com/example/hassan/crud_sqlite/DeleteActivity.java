package com.example.hassan.crud_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText text;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        text = findViewById(R.id.editText5);
        db = new DatabaseHelper(this);
    }


    public void delete(View view) {
        String roll = text.getText().toString();
        if (roll.isEmpty()) {
            Toast.makeText(this, "Enter Data", Toast.LENGTH_SHORT).show();
        } else {
            int result = db.Delete(roll);
            if (result == 1) {
                Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Data not Deleted", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
