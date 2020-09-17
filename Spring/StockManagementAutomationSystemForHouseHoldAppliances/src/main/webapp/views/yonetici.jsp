<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--<meta name="viewport" content="width=device-width, initial-scale=1">  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
#navButton {
	color: blue;
	padding-right: 10px;
	padding-top: 1px;
	padding-bottom: 1px;
}

#owner {
	color: gray;
}

#logoutButton {
	background-color: inherit;
}

#logoutButton:hover {
	background-color: aqua;
}

#urunEkleButton {
	margin-right: 0px;
}

.todark {
	color: #fff;
	background-color: #373a3c;
	font-weight: bold;
}
</style>
<title>Depo Gorevlisi</title>

</head>
<body>
	<nav class="navbar navbar-light bg-light navbar-inverse">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
					<h6 id="owner">SK</h6>
				</div>
				<div class="col-md-8">
					<h3 align="center" style="color: aqua;">Yonetici Sayfasi</h3>
				</div>
				<div class="col-md-2">
					<div id="navButton" class="nav navbar-nav navbar-right">
						<a id="logoutButton" href="/logout"
							class="btn btn-info navbar-brand" role="button">Cikis</a>
					</div>
				</div>
			</div>
		</div>
	</nav>


	<div class="container-fluid ">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div class="row">

				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown" id="depoSecici">
						Depolar <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
					    <li href="javascript:void(0)" onclick="searchTableProduct('hepsi')"><a href="#">Hepsi</a></li>
					<c:forEach items="${depolar}" var="temp">
						<li><a href="javascript:void(0)" onclick="searchTableProduct(this.innerHTML)">${temp}</a></li>
					</c:forEach>
					</ul>
				</div>
			</div>
			<div class="row" align="center">
				<table class="table table-striped table-bordered table-hover">
					<caption>
						<h3>Urunler:</h3>
					</caption>
					<thead class="todark">
						<tr>
							<td>DEPO ADI</td>
							<td>MARKA ADI</td>
							<td>URUN ADI</td>
							<td>URUN TUR</td>
						</tr>
					</thead>
					<tbody id="urunTablosu">
						<c:forEach items="${urunler}" var="temp">
							<tr>
								<td>${temp.depoAdi}</td>
								<td>${temp.markaAdi}</td>
								<td>${temp.urunAdi}</td>
								<td>${temp.urunTurAdi}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	<script src="webjars/jquery/2.2.4/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){

	  
});

function searchRow(){
	 var val2 = $.trim($("#depoSecici").text()).toLowerCase();
     var $rows = $('#urunTablosu > tbody > tr').not(".header");
  	  val2 = (val2 === "hepsi") ? "" : val2;
  	console.log("val2 : " +val2);
  		$("#urunTablosu tr").filter(function() {
  	      $(this).toggle($(this).text().toLowerCase().indexOf(val2) > -1)
  	    });
  	    
}
function searchTableProduct(product) {
	var filter, table, tr, td, i;

	$("#depoSecici").html(product);
  	console.log("depoSecici : " +product);
	if (product == "hepsi") {
		$("#deviceSelector").html("Hepsi");
	}

	searchRow();
}

</script>
</body>
</html>