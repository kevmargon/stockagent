<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
ul > li{margin-right:25px;font-weight:lighter;cursor:pointer}

.item-photo{display:flex;justify-content:center;align-items:center;border-right:1px solid #f6f6f6;}
.menu-items{list-style-type:none;font-size:11px;display:inline-flex;margin-bottom:0;margin-top:20px}
.btn-success{width:100%;border-radius:0;}
.section{width:100%;margin-left:-15px;padding:2px;padding-left:15px;padding-right:15px;background:#f8f9f9}
.title-price{margin-top:30px;margin-bottom:0;color:black}
.title-attr{margin-top:0;margin-bottom:0;color:black;}
.btn-minus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-right:0;}
.btn-plus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-left:0;}
div.section > div {width:100%;display:inline-flex;}
div.section > div > input {margin:0;padding-left:5px;font-size:10px;padding-right:5px;max-width:18%;text-align:center;}
.attr,.attr2{cursor:pointer;margin-right:5px;height:20px;font-size:10px;padding:2px;border:1px solid gray;border-radius:2px;}
.attr.active,.attr2.active{ border:1px solid orange;}

@media (max-width: 426px) {
    .container {margin-top:0px !important;}
    .container > .row{padding:0 !important;}
    .container > .row > .col-xs-12.col-sm-5{
        padding-right:0 ;    
    }
    .container > .row > .col-xs-12.col-sm-9 > div > p{
        padding-left:0 !important;
        padding-right:0 !important;
    }
    .container > .row > .col-xs-12.col-sm-9 > div > ul{
        padding-left:10px !important;
        
    }            
    .section{width:104%;}
    .menu-items{padding-left:0;}
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"><b>StockAgent</b></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/stockagent/">Home</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/stockagent/AdminCategoryServ?action=LIST">Categories</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/stockagent/AdminProductServ?action=LIST">Products</a></li>
				<li class="nav-item active"><a class="nav-link" href="#">Login</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-xs-4 item-photo">
				<img style="max-width: 100%;" src="${product.id}${product.name}.jpg" />
			</div>
			<div class="col-xs-5" style="border: 0px solid gray">
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
					<h3 class="title-attr">
						Category
					</h3>
					<div>
						<div class="attr2">${product.category.name}</div>
					</div>
				</div>
				<div class="section" style="padding-bottom: 20px;">
					<h6 class="title-attr">
						<small>CANTIDAD</small>
					</h6>
					<div>
						<div class="btn-minus">
							<span class="glyphicon glyphicon-minus"></span>
						</div>
						<input value="${product.amount}" />
						<div class="btn-plus">
							<span class="glyphicon glyphicon-plus"></span>
						</div>
					</div>
				</div>

				<!-- Botones de compra -->
				
			</div>
		</div>
	</div>
	
	<script>
	   $(document).ready(function(){
           //-- Click on detail
           $("ul.menu-items > li").on("click",function(){
               $("ul.menu-items > li").removeClass("active");
               $(this).addClass("active");
           })

           $(".attr,.attr2").on("click",function(){
               var clase = $(this).attr("class");

               $("." + clase).removeClass("active");
               $(this).addClass("active");
           })

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

