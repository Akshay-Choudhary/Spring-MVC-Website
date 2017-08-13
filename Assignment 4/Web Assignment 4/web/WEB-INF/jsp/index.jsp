<%-- 
    Document   : index
    Created on : Feb 20, 2016, 8:41:33 PM
    Author     : aksha
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Part 2</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <form action="addBooks.htm" method="post">
        <h1>How many books do you want to add?</h1><br>
        <input type="text" name="noofbooks" value=""/> <input type="submit" value="Submit"/>
        <input type="hidden" name="page" value="page1"/>
        </form>
    </body>
</html>