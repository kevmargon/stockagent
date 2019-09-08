 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><b>StockAgent</b></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/stockagent/">Home</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/stockagent/AdminCategoryServ?action=LIST">Categories</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/stockagent/AdminProductServ?action=LIST">Products</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">Login</a>
      </li>
    </ul>
  </div>
</nav>

	<div class = "container">
	
		<h3>Product Form</h3>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/AdminProductServ" method="POST">
				
					<div class = "form-group">
						<input type="text" class="form-control" name="name" placeholder="Enter Name" value="${product.name}"/>
					</div>
					
					<div class = "form-group">
						<input type="text" class="form-control" name="price" placeholder="Enter Price" value="${product.price}"/>
					</div>
					
					<div class = "form-group">
						<input type="text" class="form-control" name="amount" placeholder="Enter Amount" value="${product.amount}"/>
					</div>
					
					<div class = "form-group">
						<input type="text" class="form-control" name="manufacturer" placeholder="Enter Manufacturer" value="${product.manufacturer}"/>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>