package com.example.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class view_catalog extends AppCompatActivity {
    private ListView book_catalog;
    private bookAdapter book_lister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_catalog);
        book_catalog = findViewById(R.id.book_catalog);
        final ArrayList<Book> book_list = new ArrayList<>();
        build_library(book_list);
        book_lister = new bookAdapter(this,book_list);
        book_catalog.setAdapter(book_lister);
        book_catalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book clicked_book = book_list.get(position);
                Intent intent = new Intent(view_catalog.this,view_book.class);
                intent.putExtra("selected_book",clicked_book);
                startActivity(intent);
            }
        });
    }
    public void build_library(List<Book> book_list) {
        // gets stored books
        SharedPreferences book_library = getSharedPreferences("library", Context.MODE_PRIVATE);
        // finds library size
        SharedPreferences library_size = getSharedPreferences("library_size", Context.MODE_PRIVATE);
        int size = library_size.getInt("library_size",0);
        // converter instance
        Gson gson = new Gson();
        // appends all books to list using a book placeholder
        for (int x = 1;x <= size;x++) {
            String entry = book_library.getString("book" + Integer.toString(x),"");
            if ( !entry.equals("") ) {
                Book book = gson.fromJson(entry, Book.class);
                book_list.add(book);
            }
        }
    }
    public void view_book(View View) {
        Intent startnewactivity = new Intent(this, view_book.class);
        startActivity(startnewactivity);
    }
}
