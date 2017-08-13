/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.servlet;

import com.neu.edu.pojo.SalesOrderPojo;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
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
        String first = (String) session.getAttribute("First");
        String action = hsr.getParameter("action");
        int offset;
        if (first == null) {
            offset = 0;

        } else {
            offset = (Integer) (session.getAttribute("Limit")) + 5;

        }

        ModelAndView mv = new ModelAndView();

        if (action.equalsIgnoreCase("Query")) {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            String name = "C:\\Users\\gupta.abhi\\Documents\\NetBeansProjects\\Assignment4CSV\\";
            int count = 0;
            try {
                Class.forName("org.relique.jdbc.csv.CsvDriver");
                conn = DriverManager.getConnection("jdbc:relique:csv:" + name);
                String query = "select * from  SalesOrder1 limit " + 5 + " Offset " + offset;
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
                while (rs.next()) {
                    SalesOrderPojo salesOrder = new SalesOrderPojo();
                    salesOrder.setSalesOrderID((rs.getString("SalesOrderID")));
                    salesOrder.setRevisionNumber((rs.getString("RevisionNumber")));
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
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            session.setAttribute("Limit", offset);
            session.setAttribute("First", "first");
            JSONObject obj = new JSONObject();
            obj.put("users", salesOrderList);
            PrintWriter out = hsr1.getWriter();
            out.println(obj);
            return null;
        } else if (action.equalsIgnoreCase("Save")) {

        }
        return mv;
    }

}
