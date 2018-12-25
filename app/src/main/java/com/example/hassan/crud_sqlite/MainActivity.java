package com.example.hassan.crud_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View view) {
        startActivity(new Intent(this, InsertActivity.class));
    }

    public void delete(View view) {
        startActivity(new Intent(this, DeleteActivity.class));
    }

    public void update(View view) {
        startActivity(new Intent(this, UpdateActivity.class));

    }

    public void show(View view) {
        startActivity(new Intent(this, ShowDataActivity.class));
    }
}
