<%-- 
    Document   : LoginPage
    Created on : Jul 5, 2016, 8:07:13 PM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to the Walmart Page !</h1>
        <form action="MainUserPage.jsp" method="GET">
              Username: <input type="text" name="Username" /><br />
              Password: <input type="text" name="Password" /><br />
              <input type="submit" value="Sign-in" />
        </form>
    </body>
</html>
