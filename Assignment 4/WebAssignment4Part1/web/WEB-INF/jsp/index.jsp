<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSV Reader</title>
    </head>

    <body>
        <c:if test="${requestScope.salesOrderList==null}">
        <form method = "post" action="csvReader.htm">
            
            Enter the name of the CSV file<input type = "text" name = "fileName">
            <input type ="submit" name="submit" >
            <input type ="hidden" name="action" value ="enterFileName">
       
       </form>     
        </c:if>
        <c:if test="${requestScope.salesOrderList!=null}">
        
            
        <form action="insertIntoDatabase.htm" method="Post">
             <table border="1" align="center" >
              <tr>
              <th>Sales Order ID</th>
              <th>Revision Number</th>
              <th>OrderDate</th>
              <th>DueDate</th>
              <th>ShipDate</th>
              <th>Status</th>
              <th>Online Order Flag</th>
             </tr>
           
            <c:forEach items="${requestScope.salesOrderList}" var="salesOrderList">
            <tr>
               <td><input type ="text" name="salesOrderID" value="${salesOrderList.salesOrderID}"></td>
               <td><input type ="text" name = "revisionNumber" value="${salesOrderList.revisionNumber}"></td>
               <td><input type ="text" name = "orderDate" value="${salesOrderList.orderDate}"></td>
               <td><input type="text" name="dueDate" value="${salesOrderList.dueDate}"></td>
               <td><input type="text" name="shipDate" value="${salesOrderList.shipDate}"></td>
               <td><input type="text" name="status" value="${salesOrderList.status}"></td>
               <td><input type="text" name="onlineOrderFlag" value="${salesOrderList.onlineOrderFlag}"></td>
               <td><input type="text" name="salesOrderNumber" value="${salesOrderList.salesOrderNumber}"></td>
               <td><input type="text" name="purchaseOrderNumber" value="${salesOrderList.purchaseOrderNumber}"></td>
               <td><input type="text" name="accountNumber" value="${salesOrderList.accountNumber}"></td>
               <td><input type="text" name="customerID" value="${salesOrderList.customerID}"></td>
               <td><input type="text" name="salesPersonID" value="${salesOrderList.salesPersonID}"></td>
               <td><input type="text" name="territoryID" value="${salesOrderList.territoryID}"></td>
               <td><input type="text" name="billToAddressID" value="${salesOrderList.billToAddressID}"></td>
               <td><input type="text" name="shipToAddressID" value="${salesOrderList.shipToAddressID}"></td>
               <td><input type="text" name="shipMethodID" value="${salesOrderList.shipMethodID}"></td>
               <td><input type="text" name="creditCardID" value="${salesOrderList.creditCardID}"></td>
               <td><input type="text" name="creditCardApprovalCode" value="${salesOrderList.creditCardApprovalCode}"></td>
               <td><input type="text" name="currencyRateID" value="${salesOrderList.currencyRateID}"></td>
               <td><input type="text" name="subTotal" value="${salesOrderList.subTotal}"></td>
               <td><input type="text" name="taxAmt" value="${salesOrderList.taxAmt}"></td>
               <td><input type="text" name="freight" value="${salesOrderList.freight}"></td>
               <td><input type="text" name="totalDue" value="${salesOrderList.totalDue}"></td>
               <td><input type="text" name="comment" value="${salesOrderList.comment}"></td>
               <td><input type="text" name="modifiedDate" value="${salesOrderList.modifiedDate}"></td>
               
            </tr>
                
                
            </c:forEach>
            </br>
            <input type = "submit" name="Add to Database" value="Add to Database">
            <input type ="hidden" name="action" value="insertIntoDatabase">
            </form>
        </c:if>
        
        <c:if test="${requestScope.addedToDatabase==true}">
            <h1>${requestScope.numberOfRecords}Records added successfully</h1>
            
        </c:if>
      
    </body>
</html>
