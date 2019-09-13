<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="icon" type="image/ico" href="../img/icon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Report Form</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">

		<h3 style="text-align: center;">Report Form</h3>
		<hr />

		<div style="margin: auto;" class="row">
			<div style="margin:auto; padding:20px;" class="col-md-5 bg-light text-dark">
				<form action="${pageContext.request.contextPath}/AdminCategoryServ" method="POST">
					<div class="form-group">
						<textarea class="form-control" id="name" placeholder="Explain the situation" rows=10></textarea>
					</div>

					<input type="hidden" name="id" value="${category.id}" />

					<button type="submit" class="btn btn-primary">Send</button>
				</form>
				<a href="${pageContext.request.contextPath}/AdminCategoryServ?action=LIST">Back	to List</a>
			</div>
		</div>
		
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>