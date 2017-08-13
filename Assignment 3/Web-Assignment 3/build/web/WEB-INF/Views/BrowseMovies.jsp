<%-- 
    Document   : BrowseMovies
    Created on : Feb 10, 2016, 1:10:15 AM
    Author     : aksha
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies Search</title>
    </head>
    <body>
        <c:if test="${!empty param.error}">
            <p style="color:red;"> No Results For Requested Search. </p>
        </c:if>
        <form action="SearchController" method="POST">
        <h1>Searching Movies</h1><br>
        <h3>Keyword<input type="text" name="keyword" value=""/></h3><br>
        <input type="radio" name="keywordSearch" value="searchtitle"/>Search by Title.<br>
        <input type="radio" name="keywordSearch" value="searchActor"/>Search by Actor.<br>
        <input type="radio" name="keywordSearch" value="searchActress"/>Search by Actress<br><br>
        <input type="submit" value="Search Movies"/>
        </form>
    </body>
</html>
