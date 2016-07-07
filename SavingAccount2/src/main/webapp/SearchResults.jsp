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
        <h1>Search Results!</h1>
        
        <form action="" method="POST">
        <ul>
        <c:forEach var="item" items="${results}">
            <li>
                ${item.name}</br>$${item.salePrice}</br>
                <input type="checkbox" name="addItem[]" value="${item.itemId}"/>Add to Wishlist</br>
                <img src="${item.mediumImage}" />
                </br></br></br>
            </li>
        </c:forEach>
        </ul>
            <input type="submit" value="Add Items" />
        </form>
        <form action="searchPage" method="POST">
            <input type="submit" name="page" value="Previous"/>
            <input type="submit" name="page" value="Next"/>
        </form>
    </body>
</html>
