<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   
   <style>
    ul > li{margin-right:25px;font-weight:lighter;cursor:pointer}
   </style>
   
    <title>Product List</title>
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

		
		<h3>Product List</h3>
		<hr/>
		
		<div class="active-cyan-3 active-cyan-4 mb-4">
 			<input class="form-control" type="text" placeholder="Search" aria-label="Search">
		</div>
		
		<div class="alert alert-info" role="alert">
			<p>${NOTIFICATION}</p>
		</div>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/admin-product-form.jsp'">Add Product</button>
		</p>
	
		<table class = "table table-striped table-bordered table-hover">
			
			<tr class = "thead-light">
				<th>Products</th>
				
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${listP}" var="product">
			
				<tr>
					<td>${product.name}</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/AdminProductServ?action=EDIT&id=${product.id}"><span class="glyphicon glyphicon-edit"></span></a>
				   		| 
						<a href = "${pageContext.request.contextPath}/AdminProductServ?action=DELETE&id=${product.id}" onclick="return confirm('You are going to delete the following item ${product.name}');"><span class="glyphicon glyphicon-trash"></span></a>
						|
						<a href= "${pageContext.request.contextPath}/AdminProductServ?action=LIST"><span class="glyphicon glyphicon-eye-open"></span></a>
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>
   	
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>
</html>