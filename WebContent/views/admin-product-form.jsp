 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	
	<div class = "container">
	
		<h1>Category Form</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/AdminCategoryServ" method="POST">
				
					<div class = "form-group">
						<input type="text" class="form-control" name="name" placeholder="Enter Name Category" value="${category.name}"/>
					</div>
					
					<input type="hidden" name="id" value="${product.id}"/>
					
					<button type="submit" class="btn btn-primary">Save</button>
				</form>
				</div>
				</div>
					<a href = "${pageContext.request.contextPath}/AdminCategoryServ?action=LIST">Back to List</a>
				</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>