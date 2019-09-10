<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/ico" href="../img/icon.ico">
<title>Error</title>
</head>
<body>

<% /* Obligatorio añadir esta directiva para que pueda detectar el objeto implicito exception */ %>
<%@ page isErrorPage="true" %>

Error message:<br><%=exception.getMessage()%>

</body>
</html>