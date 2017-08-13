<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body bgcolor="#4CB96B">
        <form action="read.htm?action=Query&page=1" method="post">
            <c:choose>
                <c:when test="${empty requestScope.salesOrderList}">
                    <!--<input type="file" name="fileToUpload" id="fileToUpload" accept="/*" >-->
                    <c:if test="${!empty requestScope.total}">
                        </br>Total Record Updated = <c:out  value="${requestScope.total}"></c:out>
                    </c:if>
                    <c:if test="${empty requestScope.total}">
                        <input type="submit" value="Read Csv"/>
                    </c:if>

                </c:when>
                <c:otherwise>
                    <table border="1">
                        <tr>
                            <th>btn</th>
                            <th>salesOrderID</th>
                            <th>revisionNumber</th>
                            <th>orderDate</th>
                            <th>dueDate</th>
                            <th>shipDate</th>
                            <th>status</th>
                            <th>onlineOrderFlag</th>
                            <th>salesOrderNumber</th>
                            <th>purchaseOrderNumber</th>
                            <th>accountNumber</th>
                            <th>customerID</th>
                            <th>salesPersonID</th>
                            <th>territoryID</th>
                            <th>billToAddressID</th>
                            <th>shipToAddressID</th>
                            <th>shipMethodID</th>
                            <th>creditCardID</th>
                            <th>creditCardApprovalCode</th>
                            <th>currencyRateID</th>
                            <th>subTotal</th>
                            <th>taxAmt</th>
                            <th>freight</th>
                            <th>totalDue</th>
                            <th>comment</th>
                            <th>modifiedDate</th>
                        </tr>
                        <c:forEach var="salesOrder" items="${requestScope.salesOrderList}" varStatus="i">
                            <tr id="tr${i.index}">
                                <td>
                                    <input type="button" value="Save" id="btnSave${i.index}" onclick="return Save(${i.index})"/>
                                    <input type="button" value="Delete" onclick="Delete(${i.index})"/>
                                </td>
                                <td><input type="text" id="salesOrder${i.index}" value=${salesOrder.salesOrderID}></input></td>
                                <td><input type="text" id="revisionNumber${i.index}" value=${salesOrder.revisionNumber}></input></td>
                                <td><input type="text" id="orderDate${i.index}" value=${salesOrder.orderDate}></input></td>
                                <td><input type="text" id="dueDate${i.index}" value=${salesOrder.dueDate}></input></td>
                                <td id><input type="text" id="shipDate${i.index}" value=${salesOrder.shipDate}></input></td>
                                <td><input type="text" id="status${i.index}" value=${salesOrder.status}></input></td>
                                <td><input type="text" id="onlineOrderFlag${i.index}" value=${salesOrder.onlineOrderFlag}></input></td>
                                <td><input type="text" id="salesOrderNumber${i.index}" value=${salesOrder.salesOrderNumber}></input></td>
                                <td><input type="text" id="purchaseOrderNumber${i.index}" value=${salesOrder.purchaseOrderNumber}></input></td>
                                <td><input type="text" id="accountNumber${i.index}" value=${salesOrder.accountNumber}></input></td>
                                <td><input type="text" id="customerID${i.index}" value=${salesOrder.customerID}></input></td>
                                <td><input type="text" id="salesPersonID${i.index}" value=${salesOrder.salesPersonID}></input></td>
                                <td><input type="text" id="territoryID${i.index}" value=${salesOrder.territoryID}></input></td>
                                <td><input type="text" id="billToAddressID${i.index}" value=${salesOrder.billToAddressID}></input></td>
                                <td><input type="text" id="shipToAddressID${i.index}" value=${salesOrder.shipToAddressID}></input></td>
                                <td><input type="text" id="shipMethodID${i.index}" value=${salesOrder.shipMethodID}></input></td>
                                <td><input type="text" id="creditCardID${i.index}" value=${salesOrder.creditCardID}></input></td>
                                <td><input type="text" id="creditCardApprovalCode${i.index}" value=${salesOrder.creditCardApprovalCode}></input></td>
                                <td><input type="text" id="currencyRateID${i.index}" value=${salesOrder.currencyRateID}></input></td>
                                <td><input type="text" id="subTotal${i.index}" value=${salesOrder.subTotal}></input></td>
                                <td><input type="text" id="taxAmt${i.index}" value=${salesOrder.taxAmt}></input></td>
                                <td><input type="text" id="freight${i.index}" value=${salesOrder.freight}></input></td>
                                <td><input type="text" id="totalDue${i.index}" value=${salesOrder.totalDue}></input></td>
                                <td><input type="text" id="comment${i.index}" value=${salesOrder.comment}></input></td>
                                <td><input type="text" id="modifiedDate${i.index}" value=${salesOrder.modifiedDate}></input></td>
                            </tr>
                        </c:forEach>
                    </table>      
                    <%--For displaying Previous link except for the 1st page --%>
                    <c:if test="${currentPage != 1}">
                        <td><a href="read.htm?action=Query&page=${currentPage - 1}">Previous</a></td>
                    </c:if>

                    <%--For displaying Page numbers. 
                    The when condition does not display a link for the current page--%>
                    <table border="1" cellpadding="5" cellspacing="5">
                        <tr>
                            <c:forEach begin="1" end="${noOfPages}" var="i">
                                <c:choose>
                                    <c:when test="${currentPage eq i}">
                                        <td>${i}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><a href="read.htm?action=Query&page=${i}">${i}</a></td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </tr>
                    </table>

                    <%--For displaying Next link --%>
                    <c:if test="${currentPage lt noOfPages}">
                        <td><a href="read.htm?action=Query&page=${currentPage + 1}">Next</a></td>
                    </c:if>



                </c:otherwise>   

            </c:choose> 
        </form>

        <script>
            function GetXmlHttpObject()
            {
                var xmlHttp = null;
                try
                {
                    // Firefox, Opera 8.0+, Safari
                    xmlHttp = new XMLHttpRequest();
                } catch (e)
                {
                    // Internet Explorer
                    try
                    {
                        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e)
                    {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                }
                return xmlHttp;
            }
            function Save(index) {
                var salesOrder = document.getElementById("salesOrder" + index).value;
                var revisionNumber = document.getElementById("revisionNumber" + index).value;
                var orderDate = document.getElementById("orderDate" + index).value;
                var dueDate = document.getElementById("dueDate" + index).value;
                var shipDate = document.getElementById("shipDate" + index).value;
                var status = document.getElementById("status" + index).value;
                var onlineOrderFlag = document.getElementById("onlineOrderFlag" + index).value;
                var salesOrderNumber = document.getElementById("salesOrderNumber" + index).value;
                var purchaseOrderNumber = document.getElementById("purchaseOrderNumber" + index).value;
                var accountNumber = document.getElementById("accountNumber" + index).value;
                var customerID = document.getElementById("customerID" + index).value;
                var salesPersonID = document.getElementById("salesPersonID" + index).value;
                var territoryID = document.getElementById("territoryID" + index).value;
                var billToAddressID = document.getElementById("billToAddressID" + index).value;
                var shipToAddressID = document.getElementById("shipToAddressID" + index).value;
                var shipMethodID = document.getElementById("shipMethodID" + index).value;
                var creditCardID = document.getElementById("creditCardID" + index).value;
                var creditCardApprovalCode = document.getElementById("creditCardApprovalCode" + index).value;
                var currencyRateID = document.getElementById("currencyRateID" + index).value;
                var subTotal = document.getElementById("subTotal" + index).value;
                var taxAmt = document.getElementById("taxAmt" + index).value;
                var freight = document.getElementById("freight" + index).value;
                var totalDue = document.getElementById("totalDue" + index).value;
                var comment = document.getElementById("comment" + index).value;
                var modifiedDate = document.getElementById("modifiedDate" + index).value;

                var xmlHttp;
                xmlHttp = GetXmlHttpObject();
                var query = "action=Save&salesOrder=" + salesOrder + "&revisionNumber=" + revisionNumber + "&orderDate=" + orderDate + "&dueDate=" + dueDate + "&shipDate=" + shipDate + "&status=" + status
                        + "&onlineOrderFlag=" + onlineOrderFlag + "&salesOrderNumber=" + salesOrderNumber +"&purchaseOrderNumber="+purchaseOrderNumber+"&accountNumber="+accountNumber+
                        "&customerID="+customerID+"&salesPersonID="+salesPersonID+"&territoryID="+territoryID+"&billToAddressID="+billToAddressID+
                        "&shipToAddressID="+shipToAddressID+"&shipMethodID="+shipMethodID+"&creditCardID="+creditCardID+"&creditCardApprovalCode="+creditCardApprovalCode+
                        "&currencyRateID="+currencyRateID+"&subTotal="+subTotal+"&taxAmt="+taxAmt+"&freight="+freight+"&totalDue="+totalDue+"&comment="+comment+"&modifiedDate="+modifiedDate;


                if (xmlHttp == null)
                {
                    alert("Your browser does not support AJAX!");
                    return;
                }
                xmlHttp.onreadystatechange = function stateChanged()
                {
                    if (xmlHttp.readyState == 4)
                    {
                        alert(salesOrder+" has been saved to database");
                        var button = document.getElementById("btnSave"+index);
                        var row = document.getElementById("tr"+index);
                        
                        row.setAttribute("bgcolor","red");
                        
                        button.disabled=true;
                        
                    }
                };

                xmlHttp.open("POST", "read.htm", true);
                xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlHttp.send(query);
                return false;



            }
            function Delete(index)
            {
                var test = document.getElementById("tr"+index);

                var c = test.childNodes;


                test.hidden = true;
            }


        </script>

    </body>
</html>
