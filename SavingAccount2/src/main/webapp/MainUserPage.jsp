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
		background-image: url("walmart-store.jpg");
		opacity: 0.8;
		filter: alpha(opacity=40);
		background-size:cover
	 } 	  
	</style>
    </head>
    
    
    <body background="walmart-store.jpg"> 
        <div id="mainBox" style="background-color: white; margin: 8%; padding: 1%">
            <!-- main title position -->
            <div></div> 
            <div style="background-color: red; margin:1%; text-align: center; padding: 0.1%"> 
		<h1>Home Page</h1>
            </div>
            <div style="background-color: blue; margin:1%; text-align: center">
		
		<form action="WebRead" method="POST">
                    <div style="margin:0%; padding:1%;"> 
                        <h1>Welcome Link (user page)</h1>
                    </div>
                    <div style="text-align: left; margin-left: 2%"> 
                        <input type="text" name="search"/>
                        <input type="submit" name="page" value="Search"/>            
                    </div>
			
                    <br><br><br>
		</form>
		
		<!--</div>-->
                <form action="AddMoney" method="POST">
                    <div style="text-align: left; margin-left: 2%">
                        <p>$
                            <input type="text" name="amount" />
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
