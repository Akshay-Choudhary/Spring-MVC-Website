<%-- 
    Document   : Results
    Created on : Feb 10, 2016, 8:40:26 PM
    Author     : aksha
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results Page</title>
    </head>
    <body>
        
        
        <h1>You Searched for<c:out value="${sessionScope.keyword}"></c:out></h1><br>



            <h2><u>Here are the search Results</u></h2><br>
                <c:forEach var="movie" items="${sessionScope.movielist}">
            <ul>
                <li>Movie Title : <c:out value="${movie.movieTitle}"></c:out></li>
                <li>Lead Actor : <c:out value="${movie.leadActor}"></c:out></li>
                <li>Lead Actress : <c:out value="${movie.leadActress}"></c:out></li>
                <li>Genre : <c:out value="${movie.genre}"></c:out></li>
                <li>Year : <c:out value="${movie.year}"></c:out></li>
                </ul>
        </c:forEach>
        
    </body>
</html>
