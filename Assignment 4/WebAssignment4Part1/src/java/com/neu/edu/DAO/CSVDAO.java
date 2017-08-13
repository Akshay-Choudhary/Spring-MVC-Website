/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.DAO;

import com.neu.edu.pojo.SalesOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aksha
 */
public class CSVDAO extends DAO {
      Connection conn;
     PreparedStatement ps;
     
     public int insertData(ArrayList<SalesOrder> salesOrderList) throws SQLException
     {
         
         conn = getConnection();
           String queryInsert = "INSERT INTO csvtable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement addstmt = conn.prepareStatement(queryInsert);
           for(SalesOrder salesOrder: salesOrderList){
                       
                        addstmt.setLong(1, salesOrder.getSalesOrderID());
                        addstmt.setInt(2, salesOrder.getRevisionNumber());
                        addstmt.setString(3, salesOrder.getOrderDate());
                        addstmt.setString(4, salesOrder.getDueDate());
                        addstmt.setString(5, salesOrder.getShipDate());
                        addstmt.setInt(6, salesOrder.getStatus());
                        addstmt.setInt(7, salesOrder.getOnlineOrderFlag());
                        addstmt.setString(8, salesOrder.getSalesOrderNumber());
                        addstmt.setString(9, salesOrder.getPurchaseOrderNumber());
                        addstmt.setString(10, salesOrder.getAccountNumber());
                        addstmt.setInt(11, salesOrder.getCustomerID());
                        addstmt.setInt(12, salesOrder.getSalesPersonID());
                        addstmt.setInt(13, salesOrder.getTerritoryID());
                        addstmt.setInt(14, salesOrder.getBillToAddressID());
                        addstmt.setInt(15, salesOrder.getShipToAddressID());
                        addstmt.setInt(16, salesOrder.getShipMethodID());
                        addstmt.setInt(17, salesOrder.getCreditCardID());
                        addstmt.setString(18, salesOrder.getCreditCardApprovalCode());
                        addstmt.setString(19, salesOrder.getCurrencyRateID());
                        addstmt.setFloat(20, salesOrder.getSubTotal());
                        addstmt.setFloat(21, salesOrder.getTaxAmt());
                        addstmt.setFloat(22, salesOrder.getFreight());
                        addstmt.setFloat(23, salesOrder.getTotalDue());
                        addstmt.setString(24, salesOrder.getComment());
                        addstmt.setString(25, salesOrder.getModifiedDate());
                        
                        addstmt.addBatch();
                    }
                    int[] count = addstmt.executeBatch();
         
                     return count.length;
         
     }
    
    
}
