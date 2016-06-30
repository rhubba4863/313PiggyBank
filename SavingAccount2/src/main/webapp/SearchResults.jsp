<%-- 
    Document   : SearchResults
    Created on : Jun 29, 2016, 9:41:49 PM
    Author     : Braden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Search Results!</h1>
        
        <ul>
        <c:forEach var="movie" items="${results}">
            <li>${movie.name} ($ ${movie.salePrice})</li>
        </c:forEach>
        </ul>
        
    </body>
</html>
