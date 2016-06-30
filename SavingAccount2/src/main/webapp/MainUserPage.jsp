<%-- 
    Document   : MainUserPage
    Created on : Jun 24, 2016, 3:32:38 PM
    Author     : robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">k,k,,
        <title>JSP Page</title>
    </head>
    <body>
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
        <input type="button" value="Logout" name="CreateCourse" />
    </body>
</html>
