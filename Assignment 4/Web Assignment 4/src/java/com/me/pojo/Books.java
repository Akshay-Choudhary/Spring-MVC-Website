/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import java.util.ArrayList;

/**
 *
 * @author aksha
 */
public class Books {
   private String ISBN;
   private String bookTitle;
   private String authors;
   private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Books> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Books> bookList) {
        this.bookList = bookList;
    }
   private ArrayList<Books> bookList;
   
   public Books()
   {
       bookList = new ArrayList<>();
   }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    
    public void addBooks(Books book)
    {
        bookList.add(book);
    }
   
    
}
