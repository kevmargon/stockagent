 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/ico" href="../img/icon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Product Form</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class = "container">
	
		<h3 style="text-align:center;">Product Form</h3>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/AdminProductServ" method="POST">
				
					<div class = "form-group">
						<input type="text" class="form-control" name="name" placeholder="Enter Name" value="${product.name}" required/>
					</div>
					
					<div class = "form-group">
						<input type="text" class="form-control" name="price" placeholder="Enter Price" value="${product.price}" required/>
					</div>
					
					<div class = "form-group">
						<input type="text" class="form-control" name="amount" placeholder="Enter Amount" value="${product.amount}" required/>
					</div>
					
					<div class = "form-group">
						<input type="text" class="form-control" name="manufacturer" placeholder="Enter Manufacturer" value="${product.manufacturer}" required/>
					</div>
					
					<div class="form-group col-md-15">
						<select id="inputState" class="form-control" name="category" required>
							<option selected disabled value="">Select Category</option>
							<c:forEach items="${listC}" var="category"> 
							<option value="${category.id}">${category.name}</option>
							</c:forEach>
						</select>
					</div>
					
					<input type="hidden" name="id" value="${product.id}"/>
					
					<button type="submit" class="btn btn-primary">Save</button>
				</form>
				</div>
				</div>
					<a href = "${pageContext.request.contextPath}/AdminProductServ?action=LIST">Back to List</a>
				</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>