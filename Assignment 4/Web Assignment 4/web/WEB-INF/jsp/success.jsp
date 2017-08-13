<%-- 
    Document   : success
    Created on : Feb 20, 2016, 6:10:54 PM
    Author     : aksha
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <c:out value="${count}"></c:out>  books added successfully.<br>
        <a href="index.htm">Click Here to go back to Homepage</a>
    </body>
</html>
