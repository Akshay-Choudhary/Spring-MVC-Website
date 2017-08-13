/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.bean.Books;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author gupta.abhi
 */
public class BooksDao {

    private Books books;

    public BooksDao() {
    }
    
    public BooksDao(Books books) {
        this.books = books;
    }

    
    
    Configuration cfg = new Configuration();
    SessionFactory sf = cfg.configure().buildSessionFactory();
    
    
    public Books setBooks(String isbn,String title,String author, float price)
    {
        
        this.books.setIsbn(isbn);
        this.books.setTitle(title);
        this.books.setAuthor(author);
        this.books.setPrice(price);
        return books;
    }
    public void saveBook(Books book){
        
        
        
        Session hibSession = sf.openSession();
        Transaction tx=null;
        
        tx = hibSession.beginTransaction();
        hibSession.save(book);
        tx.commit();
        hibSession.close();
        
        
        
    }
    
}
