/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author gupta.abhi
 */
public class CSVDAO extends DAO {

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    DataSource dataSource;

    public CSVDAO() {
    }

    public boolean DeleteRecord(String salesOrderID) {

        conn = getConnection();
        String query = "delete from csvorderdetail where salesOrderID=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, salesOrderID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return true;
    }

}
