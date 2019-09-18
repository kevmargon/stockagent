
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" type="image/ico" href="../img/icon.ico">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css">
.box {
	color: #fff;
	padding: 20px;
	display: none;
	margin-top: 20px;
}

.red {
	background: #ff0000;
}

.green {
	background: #228B22;
}

.blue {
	background: #0000ff;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("select").change(function() {
			$(this).find("option:selected").each(function() {
				var optionValue = $(this).attr("value");
				if (optionValue) {
					$(".box").not("." + optionValue).hide();
					$("." + optionValue).show();
				} else {
					$(".box").hide();
				}
			});
		}).change();
	});
</script>
<title>New Employee Form</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

		<h3 style="text-align: center;">New User Form</h3>
		<hr />

		<div class="row">
			<div class="col-md-4">
				<form action="${pageContext.request.contextPath}/AdminEmployeeServ"method="POST">

					<div class="form-group">
						<input type="text" class="form-control" name="name"
							placeholder="Enter Name" required value="${employee.name}" />
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="surname1"
							placeholder="Enter Surname" required value="${employee.surname1}" />
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="surname2"
							placeholder="Enter Surname" value="${employee.surname2}" />
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="dni"
							placeholder="Enter ID Number" required value="${employee.dni}" />
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="phoneNumber"
							placeholder="Enter Phone" value="${employee.phoneNumber}" />
					</div>
					<br>
					<div>
						<select>
							<option>Choose for insert more data</option>
							<option value="white">Insert Employee Direction</option>
<!-- 							<option value="green">Green</option> -->
<!-- 							<option value="blue">Blue</option> -->
						</select>
					</div>

					<div class="white box">
					<br>
						<div class="form-group">
							<input type="text" class="form-control" name="address"
								placeholder="Enter Street Name" value="${direction.address}" />
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="houseNumber"
								placeholder="Enter House Number"
								value="${direction.houseNumber}" />
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="zipCode"
								placeholder="Enter Zip Code" value="${direction.zipCode}" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="city"
								placeholder="Enter City Name" value="${direction.city}" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="province"
								placeholder="Enter Province" value="${direction.province}" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="country"
								placeholder="Enter Country" value="${direction.country}" />
						</div>
						
					<%-- 	<c:set var="employee.pass" value="${fn:trim(${employee.name})}" /> --%>
						<input type="hidden" name="pass" value="${employee.pass}" /> 
						<input type="hidden" name="user" value="${employee.user}" /> 
						<input type="hidden" name="idemployee" value="${employee.id}" />
						<input type="hidden" name="iddirection" value="${ditection.id}" />
					</div>
					<br>
					<button type="submit" class="btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		<a
			href="${pageContext.request.contextPath}/AdminProductServ?action=LIST">Back to List</a>
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