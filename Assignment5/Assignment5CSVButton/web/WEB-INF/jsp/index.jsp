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
                        <input type="button" value="Read Csv" onclick="return Save(${salesOrder.salesOrderID})"/>
                    </c:if>

                </c:when>
                <c:otherwise>
                    <table border="1" id="displayTable">
                        <tr>
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
                    <input type="button" value="Show More Record" onclick="return Save(${salesOrder.salesOrderID})">

                </c:otherwise>   

            </c:choose> 

            <table id="test">
            </table>
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
            function Save(salesOrderID) {

                
                var xmlHttp;
                xmlHttp = GetXmlHttpObject();
                var query = "action=Query";
                
                if (xmlHttp == null)
                {
                    alert("Your browser does not support AJAX!");
                    return;
                }
                xmlHttp.onreadystatechange = function stateChanged()
                {
                    if (xmlHttp.readyState == 4)
                    {
                        
                        var json = JSON.parse(xmlHttp.responseText);
                        if (json.users.length > 0) {
                            console.log(json.users.length);
                            var table = document.getElementById("test");
                            for (var count = 0; count < (json.users.length); count++) {
                                var tr = document.createElement("TR");
                                tr.setAttribute("id", "row" + count);
                                table.appendChild(tr);

                                var td1 = document.createElement("TD");
                                var text1 = document.createElement("input");
                                text1.type = "text";

                                text1.setAttribute("name", "c0" + count);
                                text1.value = json.users[count].salesOrderID;

                                td1.appendChild(text1);
                                tr.appendChild(td1);


                                var td2 = document.createElement("TD");
                                var text2 = document.createElement("input");
                                text2.type = "text";

                                text2.setAttribute("name", "c1" + count);
                                text2.value = json.users[count].revisionNumber;

                                td2.appendChild(text2);
                                tr.appendChild(td2);

                                var td3 = document.createElement("TD");
                                var text3 = document.createElement("input");
                                text3.type = "text";

                                text3.setAttribute("name", "c2" + count);
                                text3.value = json.users[count].orderDate;

                                td3.appendChild(text3);
                                tr.appendChild(td3);

                                var td4 = document.createElement("TD");
                                var text4 = document.createElement("input");
                                text4.type = "text";

                                text4.setAttribute("name", "c3" + count);
                                text4.value = json.users[count].dueDate;

                                td4.appendChild(text4);
                                tr.appendChild(td4);

                                var td5 = document.createElement("TD");
                                var text5 = document.createElement("input");
                                text5.type = "text";

                                text5.setAttribute("name", "c4" + count);
                                text5.value = json.users[count].shipDate;

                                td5.appendChild(text5);
                                tr.appendChild(td5);

                                var td6 = document.createElement("TD");
                                var text6 = document.createElement("input");
                                text6.type = "text";

                                text6.setAttribute("name", "c5" + count);
                                text6.value = json.users[count].status;

                                td6.appendChild(text6);
                                tr.appendChild(td6);

                                var td7 = document.createElement("TD");
                                var text7 = document.createElement("input");
                                text7.type = "text";

                                text7.setAttribute("name", "c6" + count);
                                text7.value = json.users[count].onlineOrderFlag;

                                td7.appendChild(text7);
                                tr.appendChild(td7);

                                var td8 = document.createElement("TD");
                                var text8 = document.createElement("input");
                                text8.type = "text";

                                text8.setAttribute("name", "c7" + count);
                                text8.value = json.users[count].salesOrderNumber;

                                td8.appendChild(text8);
                                tr.appendChild(td8);

                                var td9 = document.createElement("TD");
                                var text9 = document.createElement("input");
                                text9.type = "text";

                                text9.setAttribute("name", "c8" + count);
                                text9.value = json.users[count].purchaseOrderNumber;

                                td9.appendChild(text9);
                                tr.appendChild(td9);

                                var td10 = document.createElement("TD");
                                var text10 = document.createElement("input");
                                text10.type = "text";

                                text10.setAttribute("name", "c9" + count);
                                text10.value = json.users[count].accountNumber;

                                td10.appendChild(text10);
                                tr.appendChild(td10);

                                var td11 = document.createElement("TD");
                                var text11 = document.createElement("input");
                                text11.type = "text";

                                text11.setAttribute("name", "c10" + count);
                                text11.value = json.users[count].customerID;

                                td11.appendChild(text11);
                                tr.appendChild(td11);

                                var td12 = document.createElement("TD");
                                var text12 = document.createElement("input");
                                text12.type = "text";

                                text12.setAttribute("name", "c11" + count);
                                text12.value = json.users[count].salesPersonID;

                                td12.appendChild(text12);
                                tr.appendChild(td12);

                                var td13 = document.createElement("TD");
                                var text13 = document.createElement("input");
                                text13.type = "text";

                                text13.setAttribute("name", "c12" + count);
                                text13.value = json.users[count].territoryID;

                                td13.appendChild(text13);
                                tr.appendChild(td13);

                                var td14 = document.createElement("TD");
                                var text14 = document.createElement("input");
                                text14.type = "text";

                                text14.setAttribute("name", "c13" + count);
                                text14.value = json.users[count].billToAddressID;

                                td14.appendChild(text14);
                                tr.appendChild(td14);

                                var td15 = document.createElement("TD");
                                var text15 = document.createElement("input");
                                text15.type = "text";

                                text15.setAttribute("name", "c14" + count);
                                text15.value = json.users[count].shipToAddressID;

                                td15.appendChild(text15);
                                tr.appendChild(td15);

                                var td16 = document.createElement("TD");
                                var text16 = document.createElement("input");
                                text16.type = "text";

                                text16.setAttribute("name", "c15" + count);
                                text16.value = json.users[count].shipMethodID;

                                td16.appendChild(text16);
                                tr.appendChild(td16);

                                var td17 = document.createElement("TD");
                                var text17 = document.createElement("input");
                                text17.type = "text";

                                text17.setAttribute("name", "c16" + count);
                                text17.value = json.users[count].creditCardID;

                                td17.appendChild(text17);
                                tr.appendChild(td17);

                                var td18 = document.createElement("TD");
                                var text18 = document.createElement("input");
                                text18.type = "text";

                                text18.setAttribute("name", "c17" + count);
                                text18.value = json.users[count].creditCardApprovalCode;

                                td18.appendChild(text18);
                                tr.appendChild(td18);

                                var td19 = document.createElement("TD");
                                var text19 = document.createElement("input");
                                text19.type = "text";

                                text19.setAttribute("name", "c18" + count);
                                text19.value = json.users[count].currencyRateID;

                                td19.appendChild(text19);
                                tr.appendChild(td19);

                                var td20 = document.createElement("TD");
                                var text20 = document.createElement("input");
                                text20.type = "text";

                                text20.setAttribute("name", "c19" + count);
                                text20.value = json.users[count].subTotal;

                                td20.appendChild(text20);
                                tr.appendChild(td20);

                                var td21 = document.createElement("TD");
                                var text21 = document.createElement("input");
                                text21.type = "text";

                                text21.setAttribute("name", "c20" + count);
                                text21.value = json.users[count].taxAmt;

                                td21.appendChild(text21);
                                tr.appendChild(td21);

                                var td22 = document.createElement("TD");
                                var text22 = document.createElement("input");
                                text22.type = "text";

                                text22.setAttribute("name", "c21" + count);
                                text22.value = json.users[count].freight;

                                td22.appendChild(text22);
                                tr.appendChild(td22);

                                var td23 = document.createElement("TD");
                                var text23 = document.createElement("input");
                                text23.type = "text";

                                text23.setAttribute("name", "c22" + count);
                                text23.value = json.users[count].totalDue;

                                td23.appendChild(text23);
                                tr.appendChild(td23);

                                var td24 = document.createElement("TD");
                                var text24 = document.createElement("input");
                                text24.type = "text";

                                text24.setAttribute("name", "c23" + count);
                                text24.value = json.users[count].comment;

                                td24.appendChild(text24);
                                tr.appendChild(td24);

                                var td25 = document.createElement("TD");
                                var text25 = document.createElement("input");
                                text25.type = "text";

                                text25.setAttribute("name", "c24" + count);
                                text25.value = json.users[count].modifiedDate;

                                td25.appendChild(text25);
                                tr.appendChild(td25);
                            }
                        } else {
                            console.log("no data");
                        }



                    }
                };


                xmlHttp.open("POST", "read.htm", true);
                xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlHttp.send(query);
                return false;
            }



        </script>

    </body>
</html>
