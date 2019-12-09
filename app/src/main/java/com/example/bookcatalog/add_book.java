package com.example.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;
import java.time.Year;
public class add_book extends AppCompatActivity {
    // widget declarations
    private EditText title_input;
    private EditText author_input;
    private EditText year_input;
    private EditText isbn_input;
    private EditText description_input;
    private RadioGroup etext_input;
    private RadioButton etext_yes;
    private RadioButton etext_no;
    private boolean choice;
    Button append_book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        title_input = (EditText) findViewById(R.id.title_input);
        author_input = (EditText) findViewById(R.id.author_input);
        year_input = (EditText) findViewById(R.id.year_input);
        isbn_input = (EditText) findViewById(R.id.isbn_input);
        description_input = (EditText) findViewById(R.id.description_input);
        // emergency edit to fix this bug before power cuts off in less than an hour
        etext_input = (RadioGroup) findViewById(R.id.etextRadioGroup);
        etext_yes = (RadioButton) findViewById(R.id.etext_yes);
        etext_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = true;
            }
        });
        etext_no = (RadioButton) findViewById(R.id.etext_no);
        etext_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = false;
            }
        });
        append_book = (Button) findViewById(R.id.add_book);
        append_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                // variable declarations
                String title, author, description,isbn;
                int year;
                boolean etext;
                try {
                    year = Integer.parseInt(year_input.getText().toString());
                    // checks if the book was released in the past or present. Future is not accepted.
                    if ( year <= Year.now().getValue() ) {
                        title = title_input.getText().toString();
                        author = author_input.getText().toString();
                        description = description_input.getText().toString();
                        isbn = isbn_input.getText().toString();
                        etext = choice;
                        // Model creation
                        Book new_book = new Book(title,author,year,isbn,description,etext);
                        store_book(new_book);
                    }
                    else {
                        Toast.makeText(add_book.this, "Year not valid.", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e) {
                    Toast.makeText(add_book.this, "Please fill all information correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void store_book(Book new_book) {
        // first updates library size so we can differentiate the keys later
        SharedPreferences library_size = getSharedPreferences("library_size", Context.MODE_PRIVATE);
        int size = library_size.getInt("library_size",0);
        size++;
        SharedPreferences.Editor size_editor = library_size.edit();
        size_editor.putInt("library_size",size);
        size_editor.commit();
        // uses updated size to create custom key
        SharedPreferences book_library = getSharedPreferences("library", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String book = gson.toJson(new_book);
        SharedPreferences.Editor library_editor = book_library.edit();
        library_editor.putString("book" + Integer.toString(size), book);
        library_editor.commit();
    }
}

