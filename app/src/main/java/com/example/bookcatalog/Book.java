package com.example.bookcatalog;

import java.io.Serializable;

public class Book implements Serializable{
    // attributes
    private String title;
    private String author;
    private String description;
    private int year;
    private String isbn;
    private boolean etext = false;
    public Book(String title, String author, int year, String description, String isbn, boolean etext) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.isbn = isbn;
        this.etext = etext;
    }
    // getters and setters
    public String get_title() {
        return this.title;
    }
    public void set_title(String title) { this.title = title; }
    public String get_author() {
        return this.author;
    }
    public void set_author(String author) {
        this.author = author;
    }
    public int get_year() {
        return this.year;
    }
    public void set_year(int year) {
        this.year = year;
    }
    public String get_description() {return this.description;}
    public void set_description(String description) {this.description = description;}
    public String get_isbn() {
        return this.isbn;
    }
    public void set_isbn(String isbn) {
        this.isbn = isbn;
    }
    public boolean get_etext() { return this.etext; }
    public void set_etext(boolean etext) {
        this.etext = etext;
    }
}