<%-- 
    Document   : AddMovies
    Created on : Feb 9, 2016, 7:40:04 PM
    Author     : aksha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movies</title>
    </head>
    <body>
        <form action="success.htm" method="post">
        <h1>Please Enter the Details Below:</h1>
        Movie Title<input type ="text" name="movietitle" value=""/><br>
        Lead Actor<input type ="text" name="leadactor" value=""/><br>
        Lead Actress<input type ="text" name="leadactress" value=""/><br>
        Genre<input type ="text" name="genre" value=""/><br>
        Year<input type ="text" name="year" value=""/><br>
        <input type="submit" value="Submit"/>
        <input type="hidden" name="page" value="page2"/>
        </form>
    </body>
</html>
