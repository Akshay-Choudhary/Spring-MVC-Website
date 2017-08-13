/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.servlet;

import com.neu.edu.DAO.CSVDAO;
import com.neu.edu.pojo.SalesOrder;
import com.neu.edu.pojo.SalesOrderPojo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Amulya
 */
public class HomeController implements Controller {

    public HomeController() {

    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        List<SalesOrderPojo> salesOrderList = new ArrayList<>();
        HttpSession session = hsr.getSession();
        //String fileName = hsr.getParameter("FileName");
        String action = hsr.getParameter("action");
        ModelAndView mv = new ModelAndView();

        if (action.equalsIgnoreCase("Query")) {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            int pageNum = Integer.parseInt(hsr.getParameter("page"));
            String val = hsr.getParameter("fileToUpload");
            String name = "C:\\Users\\gupta.abhi\\Documents\\NetBeansProjects\\Assignment4CSV\\";
            int count = 0;
            try {
                Class.forName("org.relique.jdbc.csv.CsvDriver");
                conn = DriverManager.getConnection("jdbc:relique:csv:" + name);
                String query = "select * from  SalesOrder1 limit " + 10 + " Offset " + (pageNum - 1) * 10;
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
                while (rs.next()) {
                    SalesOrderPojo salesOrder = new SalesOrderPojo();
                    salesOrder.setSalesOrderID((rs.getString("SalesOrderID")));
                    salesOrder.setRevisionNumber((rs.getString("RevisionNumber")));
                    //Date date = new SimpleDateFormat("mm/dd/yyyy").parse(rs.getString("OrderDate"));
                    salesOrder.setOrderDate(rs.getString("OrderDate"));
                    salesOrder.setDueDate((rs.getString("OrderDate")));
                    salesOrder.setShipDate((rs.getString("ShipDate")));
                    salesOrder.setStatus((rs.getString("Status")));
                    salesOrder.setOnlineOrderFlag((rs.getString("OnlineOrderFlag")));
                    salesOrder.setSalesOrderNumber((rs.getString("SalesOrderNumber")));
                    salesOrder.setPurchaseOrderNumber((rs.getString("PurchaseOrderNumber")));
                    salesOrder.setAccountNumber((rs.getString("AccountNumber")));
                    salesOrder.setCustomerID((rs.getString("CustomerID")));
                    salesOrder.setSalesPersonID((rs.getString("SalesPersonID")));
                    salesOrder.setTerritoryID((rs.getString("TerritoryID")));
                    salesOrder.setBillToAddressID((rs.getString("BillToAddressID")));
                    salesOrder.setShipToAddressID((rs.getString("ShipToAddressID")));
                    salesOrder.setShipMethodID((rs.getString("ShipMethodID")));
                    salesOrder.setCreditCardID((rs.getString("CreditCardID")));
                    salesOrder.setCreditCardApprovalCode((rs.getString("CreditCardApprovalCode")));
                    salesOrder.setSubTotal((rs.getString("SubTotal")));
                    salesOrder.setCurrencyRateID((rs.getString("CurrencyRateID")));
                    salesOrder.setTaxAmt((rs.getString("TaxAmt")));
                    salesOrder.setFreight((rs.getString("Freight")));
                    salesOrder.setTotalDue((rs.getString("TotalDue")));
                    salesOrder.setComment(rs.getString("Comment"));
                    salesOrder.setModifiedDate((rs.getString("ModifiedDate")));
                    salesOrderList.add(salesOrder);
                    System.out.println(salesOrder.getOrderDate());
                    count++;
                }
                hsr.setAttribute("noOfPages", 20);
                hsr.setAttribute("currentPage", pageNum);
                session.setAttribute("TotalRecord", salesOrderList.size());
                System.out.println(count);
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            mv.addObject("salesOrderList", salesOrderList);
            mv.setViewName("index");
        } else if (action.equalsIgnoreCase("Save")) {

            String salesOrder = hsr.getParameter("salesOrder");
            String revisionNumber = hsr.getParameter("revisionNumber");
            String orderDate = hsr.getParameter("orderDate");
            String dueDate = hsr.getParameter("dueDate");
            String shipDate = hsr.getParameter("shipDate");
            String status = hsr.getParameter("status");
            String onlineOrderFlag = hsr.getParameter("onlineOrderFlag");
            String salesOrderNumber = hsr.getParameter("salesOrderNumber");
            String purchaseOrderNumber = hsr.getParameter("purchaseOrderNumber");
            String accountNumber = hsr.getParameter("accountNumber");
            String customerID = hsr.getParameter("customerID");
            String salesPersonID = hsr.getParameter("salesPersonID");
            String territoryID = hsr.getParameter("territoryID");
            String billToAddressID = hsr.getParameter("billToAddressID");
            String shipToAddressID = hsr.getParameter("shipToAddressID");
            String shipMethodID = hsr.getParameter("shipMethodID");
            String creditCardID = hsr.getParameter("creditCardID");
            String creditCardApprovalCode = hsr.getParameter("creditCardApprovalCode");
            String currencyRateID = hsr.getParameter("currencyRateID");
            String subTotal = hsr.getParameter("subTotal");
            String taxAmt = hsr.getParameter("taxAmt");
            String freight = hsr.getParameter("freight");
            String totalDue = hsr.getParameter("totalDue");
            String comment = hsr.getParameter("comment");
            String modifiedDate = hsr.getParameter("modifiedDate");
           
           java.sql.Connection con1 = LocalConnection.myConnection();
            PreparedStatement ps1 = null;
            
            String query22 = "insert into csvorderdetail (salesOrderID, revisionNumber, orderDate,dueDate,shipDate,status,onlineOrderFlag,salesOrderNumber,"
                    + "purchaseOrderNumber,accountNumber,customerID,salesPersonID,territoryID,billToAddressID,shipToAddressID,shipMethodID,"
                    + "creditCardID,creditCardApprovalCode,currencyRateID,subTotal,taxAmt,freight,totalDue,comment,modifiedDate) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps1 = con1.prepareStatement(query22);
           

                ps1.setString(1, salesOrder);
                ps1.setString(2, revisionNumber);
                ps1.setString(3, orderDate);
                ps1.setString(4, dueDate);
                ps1.setString(5, shipDate);
                ps1.setString(6, status);
                ps1.setString(7, onlineOrderFlag);
                ps1.setString(8, salesOrderNumber);
                ps1.setString(9, purchaseOrderNumber);
                ps1.setString(10, accountNumber);
                ps1.setString(11, customerID);
                ps1.setString(12, salesPersonID);
                ps1.setString(13, territoryID);
                ps1.setString(14, billToAddressID);
                ps1.setString(15, shipToAddressID);
                ps1.setString(16, shipMethodID);
                ps1.setString(17, creditCardID);
                ps1.setString(18, creditCardApprovalCode);
                ps1.setString(19, currencyRateID);
                ps1.setString(20, subTotal);
                ps1.setString(21, taxAmt);
                ps1.setString(22, freight);
                ps1.setString(23, totalDue);
                ps1.setString(24, comment);
                ps1.setString(25, modifiedDate);
                ps1.executeUpdate();
        }
        return mv;
    }

}
