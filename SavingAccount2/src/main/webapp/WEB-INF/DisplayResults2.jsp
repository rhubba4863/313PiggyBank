<%-- 
    Document   : DisplayResults
    Created on : Jun 21, 2016, 10:40:17 AM
    Author     : robert
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World88!</h1>

        <ul>
            <c:forEach var="movie" items="${results}">
                <li>${movie.Title} (${movie.Year})</li>
            </c:forEach>
        </ul>
 
        
    </body>
</html>
