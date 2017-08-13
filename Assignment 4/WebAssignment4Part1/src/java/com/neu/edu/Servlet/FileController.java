/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.Servlet;

import com.neu.edu.DAO.CSVDAO;
import com.neu.edu.pojo.SalesOrder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.relique.jdbc.csv.CsvDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;



/**
 *
 * @author aksha
 */
@WebServlet(name = "FileController", urlPatterns = {"/FileController"})
public class FileController implements Controller{

    
    CSVDAO csvDAO;
    public FileController(CSVDAO csvDAO)
    {
        this.csvDAO = csvDAO;
        
        
    }
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
      HttpSession session = hsr.getSession();
     String action = hsr.getParameter("action");
     String csvFile ="C:\\Users\\aksha\\Documents\\NetBeansProjects\\Assignment4Part4\\CsvFile\\";
     String lineInput = "";
     
      ModelAndView mv = new ModelAndView();
     
     if(action.equals("enterFileName"))
     {
         
         List<SalesOrder> salesOrderList = new ArrayList<>();
         ResultSet results;
         
         try{
             
              Class.forName("org.relique.jdbc.csv.CsvDriver");
              Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + csvFile);
             //  QueryRunner runner = new QueryRunner();
            //ResultSetHandler<List<SalesOrder>> resultSetHandler = new BeanListHandler<>(SalesOrder.class);
            String q = "select * from SalesOrder";
            //salesOrderList = runner.query(conn, q,resultSetHandler);
            Statement stmt = conn.createStatement();
            
             results =stmt.executeQuery(q);
             while(results.next())
             {
                
                SalesOrder s = new SalesOrder();
                s.setSalesOrderID(results.getLong("SalesOrderID"));
                s.setRevisionNumber(results.getInt("RevisionNumber"));
                s.setOrderDate(results.getString("OrderDate"));
                s.setDueDate(results.getString("DueDate"));
                s.setShipDate(results.getString("ShipDate"));
                s.setStatus(results.getInt("Status"));
                s.setOnlineOrderFlag(results.getInt("OnlineOrderFlag"));
                s.setSalesOrderNumber(results.getString("SalesOrderNumber"));
                s.setPurchaseOrderNumber(results.getString("PurchaseOrderNumber"));
                s.setAccountNumber(results.getString("AccountNumber"));
                s.setCustomerID(results.getInt("CustomerID"));
                s.setSalesPersonID(results.getInt("SalesPersonID"));
                s.setTerritoryID( results.getInt("TerritoryID"));
                s.setBillToAddressID(results.getInt("BillToAddressID"));
                s.setShipToAddressID(results.getInt("ShipToAddressID"));
                s.setShipMethodID(results.getInt("ShipMethodID"));
                s.setCreditCardID(results.getInt("CreditCardID"));
                s.setCreditCardApprovalCode(results.getString("CreditCardApprovalCode"));
                s.setCurrencyRateID(results.getString("CurrencyRateID"));
                s.setSubTotal(results.getFloat("SubTotal"));
                s.setTaxAmt(results.getFloat("TaxAmt"));
                s.setFreight(results.getFloat("Freight"));
                s.setTotalDue(results.getFloat("TotalDue"));
                s.setComment(results.getString("Comment"));
                s.setModifiedDate(results.getString("ModifiedDate"));
                salesOrderList.add(s);
                
           
                 
             }
            
            
            mv.addObject("salesOrderList",salesOrderList);
            mv.setViewName("index");
            
  
         }
         
        
         catch(Exception e)
         {
             e.printStackTrace();
         }
         
     }
      else if(action.equals("insertIntoDatabase"))
      {
          
          
            String[] salesOrderID = hsr.getParameterValues("salesOrderID");
            String[] revisionNumber = hsr.getParameterValues("revisionNumber");
            String[] orderDate = hsr.getParameterValues("orderDate");
            String[] dueDate = hsr.getParameterValues("dueDate");
            String[] shipDate = hsr.getParameterValues("shipDate");
            String[] status = hsr.getParameterValues("status");
            String[] onlineOrderFlag = hsr.getParameterValues("onlineOrderFlag");
            String[] salesOrderNumber = hsr.getParameterValues("salesOrderNumber");
            String[] purchaseOrderNumber = hsr.getParameterValues("purchaseOrderNumber");
            String[] accountNumber = hsr.getParameterValues("accountNumber");
            String[] customerID = hsr.getParameterValues("customerID");
            String[] salesPersonID = hsr.getParameterValues("salesPersonID");
            String[] territoryID = hsr.getParameterValues("territoryID");
            String[] billToAddressID = hsr.getParameterValues("billToAddressID");
            String[] shipToAddressID = hsr.getParameterValues("shipToAddressID");
            String[] shipMethodID = hsr.getParameterValues("shipMethodID");
            String[] creditCardID = hsr.getParameterValues("creditCardID");
            String[] creditCardApprovalCode = hsr.getParameterValues("creditCardApprovalCode");
            String[] currencyRateID = hsr.getParameterValues("currencyRateID");
            String[] subTotal = hsr.getParameterValues("subTotal");
            String[] taxAmt = hsr.getParameterValues("taxAmt");
            String[] freight = hsr.getParameterValues("freight");
            String[] totalDue = hsr.getParameterValues("totalDue");
            String[] comment = hsr.getParameterValues("comment");
            String[] modifiedDate = hsr.getParameterValues("modifiedDate");
            
            
           ArrayList<SalesOrder> salesOrderList1 = new ArrayList<>();
            
            for(int i=0;i<salesOrderID.length;i++){
                  SalesOrder salesOrder = new SalesOrder();
                  salesOrder.setSalesOrderID((Long.parseLong(salesOrderID[i])));
                  salesOrder.setRevisionNumber(Integer.parseInt(revisionNumber[i]));
                  salesOrder.setOrderDate(orderDate[i]);
                  salesOrder.setDueDate(dueDate[i]);
                  salesOrder.setShipDate(shipDate[i]);
                  salesOrder.setStatus(Integer.parseInt(status[i]));
                  salesOrder.setOnlineOrderFlag(Integer.parseInt(onlineOrderFlag[i]));
                  salesOrder.setSalesOrderNumber(salesOrderNumber[i]);
                  salesOrder.setPurchaseOrderNumber(purchaseOrderNumber[i]);
                  salesOrder.setAccountNumber(accountNumber[i]);
                  salesOrder.setCustomerID(Integer.parseInt(customerID[i]));
                  salesOrder.setSalesPersonID(Integer.parseInt(salesPersonID[i]));
                  salesOrder.setTerritoryID(Integer.parseInt(territoryID[i]));
                  salesOrder.setBillToAddressID(Integer.parseInt(billToAddressID[i]));
                  salesOrder.setShipToAddressID(Integer.parseInt(shipToAddressID[i]));
                  salesOrder.setShipMethodID(Integer.parseInt(shipMethodID[i]));
                  salesOrder.setCreditCardID(Integer.parseInt(creditCardID[i]));
                  salesOrder.setCreditCardApprovalCode(creditCardApprovalCode[i]);
                  salesOrder.setCurrencyRateID(currencyRateID[i]);
                  salesOrder.setSubTotal(Float.parseFloat(subTotal[i]));
                  salesOrder.setTaxAmt(Float.parseFloat(taxAmt[i]));
                  salesOrder.setFreight(Float.parseFloat(freight[i]));
                  salesOrder.setTotalDue(Float.parseFloat(totalDue[i]));
                  salesOrder.setComment(comment[i]);
                  salesOrder.setModifiedDate(modifiedDate[i]);
    
                  salesOrderList1.add(salesOrder);
                } 
                
            
                 int count = csvDAO.insertData(salesOrderList1);
                 mv.addObject("numberOfRecords",count);
                 mv.addObject("addedToDatabase","true");
                 mv.setViewName("index");
                
          
          
          
      }
     
   
         //BufferedReader bufferReader = new BufferedReader(new FileReader(csvFile));
          //try {
              /*  while((lineInput = bufferReader.readLine())!= null)
              {
                    String token[]= lineInput.split(",");
                    SalesOrder salesOrder = new SalesOrder();
                    salesOrder.setSalesOrderId(Integer.parseInt(token[0]));
                    salesOrder.setRevisionNumber(Integer.parseInt(token[1]));
                    salesOrder.setOrderDate(Date.valueOf(token[2]));
                    salesOrder.setDueDate(Date.valueOf(token[3]));
                    salesOrder.setShipDate(Date.valueOf(token[4]));
                    salesOrder.setStatus(Integer.parseInt(token[6]));
                    salesOrder.setOnlineOrderFlag(Integer.parseInt(token[7]));
                    
                    
                    salesOrderList.add(salesOrder);
                    
                }
                
                mv.addObject("salesOrderList",salesOrderList);
                mv.setViewName("displayFileContent");
                
                
          }
         catch (IOException ex) {
                Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
            } 
     }*/
              return mv;
     }
    

        
    

 

}
