<%-- 
    Document   : MainUserPage
    Created on : Jun 24, 2016, 3:32:38 PM
    Author     : robert
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
		<h1>Home Page</h1>
            </div>
            <div style="background-color: white; margin:1%; text-align: center">
		
		<!-- begin displaying the users details and list -->
                <div style="margin:0%; padding:1%; text-align: center"> 
                    <h1>Welcome ${userName}</h1>
                    <h3>Budget: $${budget}</h3>
                </div>
               
                
                <form action="WebRead" method="POST">
                    <div style="text-align: left; margin-left: 2%">
                        Search for other products, your current desires <br>
                        will be listed below...<br>
                        <input type="text" name="search"/>
                        <input type="hidden" name="userId" value="${userId}"/>
                        <input type="submit" name="page" value="Search"/>            
                    </div>
		</form>	
                        <br>
               <!-- display each desired product-->
                <div>        
                    <hr>
                    <c:forEach var="item" items="${items}">
                        <div>
                            ${item.name}</br>$${item.salePrice}</br>
                            <img src="${item.mediumImage}" border="5"/></br>
                            Rating of ${item.customerRating} (${item.numReviews} reviews)</br>
                            <a href="${item.addToCartUrl}">Go Buy Me!</a></br>
                            <hr>
                        </div>
                    </c:forEach>
                    <br><br>
                </div>
		
		<!--section to add or remove money amount-->
                <form action="AddMoney" method="POST">
                    <div style="text-align: left; margin-left: 2%">
                        <p>$
                            <input type="text" name="amount" />
                            <input type="hidden" name="userId" value="${userId}"/>
                            <input type="submit" value="Add Funds" />
                        </p>
                    </div>
                    <div style="text-align: left; margin-left: 2%">
                        <input type="button" value="Edit Budget Amount" name="EditCash" />
                        <input type="button" value="Add/Remove Items" name="EditItems" />
                        <input type="button" value="Logout" name="CreateCourse" />
                    </div>
                    <br>
                </form>
                
            </div>
	</div>
        
        
        
        <!--<form action="WebRead" method="POST">
            
        </form>
        <h1>Welcome (will place the user's name here)</h1>
        <h1>Below are details of your current budget:</h1>
        <h1>You currently have: $45.83, enough to purchase the following goals below</h1>
        <h1>\t holster jeans: $25.99</h1>
        <h1>Target Gift Card: $35.00</h1>
        <h1>You are close to buying the following goals:</h1>
        <h1>Winter coat: $75.99 ($30.16 to go)</h1>
        <h1>...</h1>
        <h1>Select the following links to change budget and other items</h1>
        
        <form action="AddMoney" method="POST">
            <p>$
                <input type="text" name="amount" />
                <input type="submit" value="Add Funds" />
            </p>
        </form>
        <input type="button" value="Edit Budget Amount" name="EditCash" />
        <input type="button" value="Add/Remove Items" name="EditItems" />
        <input type="button" value="Logout" name="CreateCourse" />-->
    </body>
</html>
