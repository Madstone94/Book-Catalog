package com.example.bookcatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

class bookAdapter extends ArrayAdapter {
    // context check to stop crashing
    private Context current_context;
    // requires a new array since it cant be passed in directly
    private ArrayList<Book> book_list;
    // constructor
    public bookAdapter(Context context, ArrayList<Book> book_library) {
        super(context, 0 , book_library);
        current_context = context;
        book_list = book_library;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View current_view = convertView;
        // this stops it from crashing.
        if(current_view == null) {
            current_view = LayoutInflater.from(current_context).inflate(R.layout.book_layout,parent,false);
        }
        // grabs a book from the library to render
        Book book = book_list.get(position);
        TextView book_title = (TextView) current_view.findViewById(R.id.book_title);
        book_title.setText(book.get_title());
        TextView book_author = (TextView) current_view.findViewById(R.id.book_author);
        book_author.setText(book.get_author());
        TextView book_year = (TextView) current_view.findViewById(R.id.book_year);
        // year is string and must be parsed to int
        book_year.setText(Integer.toString(book.get_year()));
        return current_view;
    }
}
