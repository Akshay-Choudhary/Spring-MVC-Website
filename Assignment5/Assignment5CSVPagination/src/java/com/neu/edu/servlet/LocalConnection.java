/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AMULYA
 */
public class LocalConnection {
    
    public  static Connection myConnection()
    {
        java.sql.Connection com =null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Where is Mysql");
            e.printStackTrace();
        }
        try{
            //connection = DriverManager.getConnection("jdbc:mysql://LOCALHOST:PORT/DBNAME","USERID","PASSWORD");
            com = DriverManager.getConnection("jdbc:mysql://localhost/ordersdb","root","root");
        }
        catch(Exception e){
            System.out.println("Connection Failed");
        }
        
        if(com!=null)
        {
            System.out.println("Connected");
        }
        return com;
    }
}
