<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <script>
            function createHiddenTable() {
                var table1 = document.getElementById("booksTable");
                var value = document.getElementById("num");
                var noOfcount = document.getElementById("noOfBooks").value;
                value.value = noOfcount;
                var header = table1.createTHead();
                var row = header.insertRow(0);
                var tc1 = row.insertCell(0);
                var tc2 = row.insertCell(1);
                var tc3 = row.insertCell(2);
                var tc4 = row.insertCell(3);
                tc1.innerHTML = "<b>ISBN</b>";
                tc2.innerHTML = "<b>BOOK TITLE</b>";
                tc3.innerHTML = "<b>AUTHORS</b>";
                tc4.innerHTML = "<b>PRICE</b>";
                for (var i = 0; i < noOfcount; i++)
                {
                    var row = table1.insertRow(i + 1);
                    for (var j = 0; j < 4; j++) {
                        var cellTab = row.insertCell(j);
                        var to = document.createElement("input");
                        to.name = "column" + i + j;
                        cellTab.appendChild(to);

                    }
                }
                var input = document.createElement("INPUT");
                input.setAttribute("type", "submit");
                document.getElementById('addBooksForm').appendChild(input);

                document.getElementById("btn").style.visibility = "hidden";
                document.getElementById("header").style.visibility = "hidden";
                document.getElementById("noOfBooks").style.visibility = "hidden";
            }
        </script>
    </head>

    <body bgcolor="#E5F906">
        <h1><i><strong>How many books do you want to add?</strong></i></h1>
        <form action='AddBooks.htm?action=add' method='post' id='addBooksForm'>
            <h4 id='header'>No of Books:</h4><input type='text' id='noOfBooks' name='noOfBooks'/>
            <input type='hidden' name='num' id='num' value="${param['noOfBooks']}"/>
            <input type="button" id='btn' value='Submit' onclick="createHiddenTable()"/>
            <table id='booksTable'>

            </table>
        </form>
    </body>
</html>
