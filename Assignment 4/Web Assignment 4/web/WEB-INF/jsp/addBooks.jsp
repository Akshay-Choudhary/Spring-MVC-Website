<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="success.htm" method="get">
            <table>
            <tr>
                <td>ISBN</td>
                <td>Book Title</td>
                <td>Authors</td>
                <td>Price</td>
            </tr>
            <tr>
                <td>
                    <c:forEach var="i" begin="1" end="${n}">
            <input type="text" name="isbn" value=""/><br><br>

        </c:forEach></td>
                 <td>
                     <c:forEach var="i" begin="1" end="${n}">
            <input type="text" name="booktitle" value=""/><br><br>

        </c:forEach></td>
                  <td>
                      <c:forEach var="i" begin="1" end="${n}">
            <input type="text" name="authors" value=""/><br><br>

        </c:forEach></td>
                  <td>
                      <c:forEach var="i" begin="1" end="${n}">
            <input type="text" name="price" value=""/><br><br>

        </c:forEach></td>
            </tr>

        </table>
        <h3><input type="submit" value="Add Books"/></h3>
        <input type="hidden" name="page" value="page2"/>
        <input type="hidden" name="bookerror" value="${n}">
        </form>
    </body>
</html>
