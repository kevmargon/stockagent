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
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<title>Category List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class = "container">

		<h3 style="text-align:center;">Category List</h3>
		<hr/>
			
		<div class="active-cyan-3 active-cyan-4 mb-4">
 			
		</div>

		<c:if test="${nameCat.isEmpty() || nameCat == null}">
			<h3 style="text-align: center;">Product List</h3>
			<c:set var="n" value="1"/>
			<hr />
		</c:if>

		<c:if test="${n!=1}">
			<h3 style="text-align: center;">Category ${nameCat}. Products</h3>
			<hr />
		</c:if>

		<c:choose>
			<c:when test="${IDNAME=='save'}">
				<div class="alert alert-success" role="alert">
					<p>${NOTIFICATION}</p>
				</div>
			</c:when>
			<c:when test="${IDNAME=='update'}">
				<div class="alert alert-success" role="alert">
					<p>${NOTIFICATION}</p>
				</div>
			</c:when>
			<c:when test="${IDNAME=='delete'}">
				<div class="alert alert-success" role="alert">
					<p>${NOTIFICATION}</p>
				</div>
			</c:when>
			<c:when test="${IDNAME=='error'}">
				<div class="alert alert-warning" role="alert">
					<p>Error al procesar su solicitud.</p>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>

		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/admin-category-form.jsp'">Add Category</button>
		</p>
	
		<table class = "table table-striped table-bordered table-hover">
			
			<tr class = "thead-light">
				<th>Categories</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${listC}" var="category">
			
				<tr>
					<td>${category.name}</td>
					<td>
						<a href="${pageContext.request.contextPath}/AdminProductServ?action=LISTCAT&id=${category.id}&nameCat=${category.name}"><span class="fa fa-eye"></span></a>
						|
						<a href="${pageContext.request.contextPath}/AdminCategoryServ?action=EDIT&id=${category.id}"><span class="fa fa-edit"></span></a>
				   		| 
						<a href="${pageContext.request.contextPath}/AdminCategoryServ?action=DELETE&id=${category.id}" onclick="return confirm('You are going to delete the following item ${category.name}');"><span class="fa fa-trash"></span></a>
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>