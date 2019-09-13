<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/ico" href="../img/icon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Product Details</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin;" class="container">
	<div class="row bg-light grey" style="padding:20px; margin-top:20px;">	
			<div style="height: 40%; width: 40%;" class="img-fluid">
				<!-- Nomeclatura para los nombres de las imagenes "ManufacturerName"-"ProductName".jpg Ejemplo: Adidas-Superstar.jpg-->
				<img style="width: 100%; height: 100%;" src="img/${product.manufacturer}-${product.name}.jpg" />
			</div>
			
			<div class="col-xs-5" style="border: 0px solid gray; margin:auto; padding-left:20px;">
				<!-- Datos del vendedor y titulo del producto -->
				<h3>${product.name}</h3>
				<h5 style="color: #337ab7">
					Manufacturer <a href="#">${product.manufacturer}</a>
				</h5>

				<!-- Precios -->
				<h6 class="title-price">
					<small>PRICE</small>
				</h6>
				<h4 style="margin-top: 0px;">EUR ${product.price}</h4>

				<!-- Detalles especificos del producto -->

				<div class="section" style="padding-bottom: 5px;">
					<h6 class="title-price">
						<small>CATEGORY</small>
					</h6>
						<h4 style="margin-top: 0px;">${product.category.name}</h4>
				</div>
				<div class="section" style="padding-bottom: 20px;">
					<h6 class="title-attr">
						<small>QUANTITY</small>
					</h6>
					<div>
						<div class="btn-minus">
							<span class="glyphicon glyphicon-minus"></span>
						</div>
						<input id="amount" value="${product.amount}" />
						<div class="btn-plus">
							<span class="glyphicon glyphicon-plus"></span>
						</div>
					</div>
					<hr>
						<div class="section" style="padding-bottom:20px;">
                        <button style="marign-left:200px;" class="btn btn-primary"><span style="text-align:center;"></span>Send</button>
                    	</div> 
				</div>

				<!-- Botones de compra -->
				
			</div>
		</div>
	</div>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>	
	
	<script>
	   $(document).ready(function(){

           //-- Click on QUANTITY
           $(".btn-minus").on("click",function(){
               var now = $(".section > div > input").val();
               if ($.isNumeric(now)){
                   if (parseInt(now) -1 > 0){ now--;}
                   $(".section > div > input").val(now);
               }else{
                   $(".section > div > input").val("1");
               }
           })            
           $(".btn-plus").on("click",function(){
               var now = $(".section > div > input").val();
               if ($.isNumeric(now)){
                   $(".section > div > input").val(parseInt(now)+1);
               }else{
                   $(".section > div > input").val("1");
               }
           })                        
       }) 
	</script>
</body>
</html>

