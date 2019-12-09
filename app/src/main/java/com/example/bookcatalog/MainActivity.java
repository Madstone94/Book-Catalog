package com.example.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void add_book(View View) {
        Intent startnewactivity = new Intent(this, add_book.class);
        startActivity(startnewactivity);
    }
    public void view_catalog(View View) {
        Intent startnewactivity = new Intent(this, view_catalog.class);
        startActivity(startnewactivity);
    }
    public void exit_app(View View) {
        System.exit(0);
    }
}
