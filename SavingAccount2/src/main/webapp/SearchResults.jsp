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
        
        <style>
	 body {
		background-color: blue;
		filter: alpha(opacity=40);
		background-size:cover
	 } 	  
	</style>
    </head>
    <body>
        <div id="mainBox" style="background-color: lightgray; margin: 18%; margin-top: 8%; padding: 1%">
            <!-- main title position -->
            <div></div> 
            <div style="background-color: red; margin:1%; text-align: center; padding: 0.1%">            
                <h1>Search Results!</h1>
            </div>
        
            <div style="background-color: white; margin:1%; text-align: center">
                <br>
                <form action="addItemsServlet" method="POST">
                <!--<ul>-->
                <c:forEach var="item" items="${results}">
                    <!--<li>-->
                    <div>
                        ${item.name}</br>$${item.salePrice}<br>
                        <img src="${item.mediumImage}" border="5" /><br>
                        Rated ${item.customerRating} (${item.numReviews} reviews)</br>
                        <input type="checkbox" name="addItems" value="${item.itemId}"/>Add to Wishlist
                        <hr>
                    </div>
                    <!--<li>-->
                </c:forEach>
                <!--<li>-->
                    <input type="hidden" name="userId" value="${userId}"/>
                    <input type="submit" value="Add Items" />
                </form>
                <form action="searchPage" method="POST">
                    <input type="submit" name="page" value="Previous"/>
                    <input type="submit" name="page" value="Next"/>
                    <input type="hidden" name="nextResult" value="${start}" />
                    <input type="hidden" name="search" value="${search}" />
                    <input type="hidden" name="userId" value="${userId}" />
                </form>
                </br>
                <input type="button" onclick="location.href='LoginPage.jsp';" value="Back to Login Page" />
                <!--<input type="button" onclick="location.href='MainUserPage.jsp';" value="Back to Main Page" />-->
                <br>
            </div>
        </div>
    </body>
</html>
