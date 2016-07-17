<%-- 
    Document   : CreateNewAccount
    Created on : Jun 24, 2016, 3:27:55 PM
    Author     : robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account Page</title>
        
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
		<h1>New User</h1>
            </div>
            <div style="margin:1%; padding: 0.1%">
                <h1>Please enter your user credentials</h1>
                <form action="CreateAccountServlet" method="POST">
                    Username: <input type="text" id="newUsername" name="newUsername" /><br />
                    Password: <input type="text" id="newPassword" name="newPassword" /><br />
                    Budget: <input type="text" id="newBudget" name="newBudget" /><br />
                    <input type="submit" value="Create" />
                </form>
                <a href="LoginPage.jsp" style="">Back to Login Page</a>
            </div>
        </div>
    </body>
</html>
