<%-- 
    Document   : LoginPage
    Created on : Jul 5, 2016, 8:07:13 PM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
	 body {
		background-image: url("Flag.jpg");
		opacity: 0.8;
		filter: alpha(opacity=40);
		background-size:cover
	 } 	  
	</style>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body background="Flag.jpg"> 
	<div id="mainBox" style="background-color: white; margin: 8%; padding: 1%">
		<!-- main title position -->
		<div></div> 
		<div style="background-color: red; margin:1%; text-align: center; padding: 0.1%"> 
			<h1>Semester Sign-up</h1>
		</div>
		<div style="background-color: blue; margin:1%; text-align: center">
		
			<form action="MainUserPage.jsp" method="GET">
				<div style="margin:0%; padding:1%;"> 
					<h1>Hey Guys!!!</h1>
                                        <h1>Welcome to the Walmart Page !</h1>
				</div>
				<div style="text-align: left; margin-left: 2%"> 
					Username: <input type="text" name="Username" /><br />
                                        Password: <input type="text" name="Password" /><br />
                                        <input type="submit" value="Sign-in" />

					<!-- SUBMIT RESULTS OF PAGE 
					<input type="submit-->
				</div>
			
			<br><br><br>
		


			</form>
		</div>
		<!--</div>-->
	</div>
	


</body>
    
    
    
    <!--<body>
        <h1>Welcome to the Walmart Page !</h1>
        <form action="MainUserPage.jsp" method="GET">
              Username: <input type="text" name="Username" /><br />
              Password: <input type="text" name="Password" /><br />
              <input type="submit" value="Sign-in" />
        </form>
    </body>-->
</html>
