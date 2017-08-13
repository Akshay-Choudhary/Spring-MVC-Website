/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.Dao;

import com.me.pojo.Books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aksha
 */
public class BooksDao extends Dao {
   Connection conn;
    PreparedStatement ps;
    
    
    public void addBooks(Books b) throws SQLException
    {
        
        try{
             conn = getConnection();
            String query ="INSERT INTO books (isbn,title,authors,price)\n"
                            + "                        values (?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, b.getISBN());
            ps.setString(2, b.getBookTitle());
            ps.setString(3, b.getAuthors());
            ps.setFloat(4, b.getPrice());
            ps.executeUpdate();
           
        }catch(SQLException e){
            Logger.getLogger(BooksDao.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            close(conn);
            
            
        }
    }
}
