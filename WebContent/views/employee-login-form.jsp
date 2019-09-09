<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<HTML>
<head>
<title>Servlet | LogIn Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h1>Log in Form</h1>
	<form action="${pageContext.request.contextPath}/LogInEmployeeServ" method="POST">

		User Name:<br> <input type="text" name="user" placeholder="User Name"><br> <br>
		Password:<br> <input type="password" name="pass" placeholder="Password"> <br> <br>
		
		<input type="submit" value="Send">
		<input type ="reset" value ="Delete">
	
	</form>
	<!--<hr>
	<a href="NewUsForm.html">New user</a>
 		(REV:añadir formulario nuevo usuario solicitud) -->
</body>
</HTML>
