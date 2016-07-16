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
    </head>
    <body>
        <h1>Please enter your user credentials8fhffhfh</h1>
        <form action="CreateAccountServlet" method="POST">
            Username: <input type="text" id="newUsername" name="newUsername" /><br />
            Password: <input type="text" id="newPassword" name="newPassword" /><br />
            Budget: <input type="text" id="newBudget" name="newBudget" /><br />
            <input type="submit" value="Create" />
        </form>
        <a href="LoginPage.jsp" style="">Back to Login Page</a>
    </body>
</html>
