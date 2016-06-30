<%-- 
    Document   : index.jsp
    Created on : Jun 30, 2016, 11:05:31 AM
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
        <h1>Hello World!</h1>
         <div> Robert still is here</div>
        <form action="MainUserPage.jsp" method="GET">
              Username: <input type="text" name="Username" /><br />
              Password: <input type="text" name="Password" /><br />
              <input type="submit" value="Sign-in" />
        </form>
    </body>
</html>
