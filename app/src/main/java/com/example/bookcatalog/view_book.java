package com.example.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class view_book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);
        Book selected_book = (Book) getIntent().getSerializableExtra("selected_book");
        TextView book_title = (TextView) findViewById(R.id.display_title);
        book_title.setText(selected_book.get_title());
        TextView book_author = (TextView) findViewById(R.id.display_author);
        book_author.setText(selected_book.get_author());
        TextView book_year = (TextView) findViewById(R.id.display_year);
        // year is string and must be parsed to int
        book_year.setText(Integer.toString(selected_book.get_year()));
        TextView book_description = (TextView) findViewById(R.id.display_description);
        book_description.setText(selected_book.get_description());
        TextView book_isbn = (TextView) findViewById(R.id.display_isbn);
        book_isbn.setText(selected_book.get_isbn());
        TextView book_etext = (TextView) findViewById(R.id.display_etext);
        if (selected_book.get_etext() == true) {
            book_etext.setText("Yes");
        }
        else {
            book_etext.setText("No");
        }
    }

}
