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

#garsonlogoutButton {
	background-color: inherit;
}

#garsonlogoutButton:hover {
	background-color: gray;
}

#siparisEkleButton {
	margin-right: 0px;
}

.todark {
	color: #fff;
	background-color: #373a3c;
	font-weight: bold;
}
/** popup**/
/*.container-fluid {
	width: 960px;
	margin: 0 auto;
	overflow: hidden;
}*/

#content {
	float: left;
	width: 100%;
}

.post {
	margin: 0 auto;
	padding-bottom: 50px;
	float: left;
	width: 960px;
}

#maskEkle {
	display: none;
	background: #000;
	position: fixed;
	left: 0;
	top: 0;
	z-index: 10;
	width: 100%;
	height: 100%;
	opacity: 0.8;
	z-index: 999;
}

.ekle-popup {
	display: none;
	background: #333;
	padding: 10px;
	border: 2px solid #ddd;
	float: left;
	font-size: 1.2em;
	position: fixed;
	top: 50%;
	left: 50%;
	z-index: 99999;
	box-shadow: 0px 0px 20px #999;
	-moz-box-shadow: 0px 0px 20px #999; /* Firefox */
	-webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
	border-radius: 3px 3px 3px 3px;
	-moz-border-radius: 3px; /* Firefox */
	-webkit-border-radius: 3px; /* Safari, Chrome */
}

#maskGuncelle {
	display: none;
	background: #000;
	position: fixed;
	left: 0;
	top: 0;
	z-index: 10;
	width: 100%;
	height: 100%;
	opacity: 0.8;
	z-index: 999;
}

.guncelle-popup {
	display: none;
	background: #333;
	padding: 10px;
	border: 2px solid #ddd;
	float: left;
	font-size: 1.2em;
	position: fixed;
	top: 50%;
	left: 50%;
	z-index: 99999;
	box-shadow: 0px 0px 20px #999;
	-moz-box-shadow: 0px 0px 20px #999; /* Firefox */
	-webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
	border-radius: 3px 3px 3px 3px;
	-moz-border-radius: 3px; /* Firefox */
	-webkit-border-radius: 3px; /* Safari, Chrome */
}

img.btn_close {
	float: right;
	margin: -28px -28px 0 0;
}

fieldset {
	border: none;
}

form.signin .textbox label {
	display: block;
	padding-bottom: 7px;
}

form.signin .textbox span {
	display: block;
}

form.signin p, form.signin span {
	color: #999;
	font-size: 11px;
	line-height: 18px;
}

form.signin .textbox input {
	background: #666666;
	border-bottom: 1px solid #333;
	border-left: 1px solid #000;
	border-right: 1px solid #333;
	border-top: 1px solid #000;
	color: #fff;
	border-radius: 3px 3px 3px 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	font: 13px Arial, Helvetica, sans-serif;
	padding: 6px 6px 4px;
	width: 200px;
}

form.signin input:-moz-placeholder {
	color: #bbb;
	text-shadow: 0 0 2px #000;
}

form.signin input::-webkit-input-placeholder {
	color: #bbb;
	text-shadow: 0 0 2px #000;
}
</style>
<title>Garson</title>

</head>
<body  >
	<nav class="navbar navbar-light bg-light navbar-inverse">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
					<h6 id="owner">Nil</h6>
				</div>
				<div class="col-md-8">
					<h3 align="center" style="color: white;">Garson Sayfasi</h3>
				</div>
				<div class="col-md-2">
					<div id="navButton" class="nav navbar-nav navbar-right">
						<a id="garsonlogoutButton" href="/logout"
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
						data-toggle="dropdown" id="masaSecici">
						Masalar <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li href="javascript:void(0)" onclick="searchMasa('hepsi')"><a
							href="#">Hepsi</a></li>
						<c:forEach items="${masalar}" var="temp" >
							<li><a href="javascript:void(0)"
								onclick="searchMasa(this.innerHTML)">${temp}</a></li>
						</c:forEach>
					</ul>
				</div>

				<div class="row">
					<a id="siparisEkleButton" class=" btn btn-primary btn-lg"
						href="#ekle-box" style="position: absolute; right: 10%;">Siparis
						Ekle</a>
				</div>
			</div>
			<div class="row" align="center">
				<table class="table table-striped table-bordered table-hover">
					<caption>
						<h3>Siparisler:</h3>
					</caption>
					<thead class="todark">
						<tr>
							<td>MASA</td>
							<td>CORBA</td>
							<td>ANA YEMEK</td>
							<td>SALATA</td>
							<td>TATLI</td>
							<td>SIPARIS DETAYI</td>
							<td>ISLEM</td>
						</tr>
					</thead>
					<tbody id="siparisTablosu">
						<c:forEach items="${siparisler}" var="temp">
							<tr id="siparis">
								<td id="masaAdi">${temp.masaAdi}</td>
								<td id="corbaAdi">${temp.corbaAdi}</td>
								<td id="anayemekAdi">${temp.anayemekAdi}</td>
								<td id="salataAdi">${temp.salataAdi}</td>
								<td id="tatliAdi">${temp.tatliAdi}</td>
								<td id="siparisDurumu">${temp.siparisDurumu}</td>
								<td>
									<!-- <a  id="guncelle" class="btn btn-info" onclick=""
									href="/siparis-guncelle?id=${temp.siparisId}">Guncelle</a>  -->
									<a id="${temp.siparisId}" href="#guncelle-box"
									class="btn btn-info guncelle">Guncelle</a> <a
									class="btn btn-warning"
									onclick="return confirm('Silmek istediginizden emin misiniz?')"
									href="/siparis-sil?siparisid=${temp.siparisId}">Sil</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>


			<div id="ekle-box" class="ekle-popup">
				<a href="#" class="eklekapat"><img src="../photos/close_pop.png"
					class="btn_close" title="Pencereyi Kapat" alt="Kapat" /></a>
				<form id="ekle-form" method="post" class="signin"
					action="siparis-ekle" method="post">
					<fieldset class="textbox">
						<div class="dropdown" >
							<button class="btn btn-secondary dropdown-toggle btn-block" type="button"
								data-toggle="dropdown" id="eklepopupmasaAdi"  name="btnmasaAdi" value="serdar">
								Masa Seciniz <span class="caret"></span>
							</button>
							
							<ul class="dropdown-menu"  >
								<c:forEach items="${masalar}" var="temp">
									<li ><a href="#"  data-value="${temp}" >${temp}</a></li>
								</c:forEach>
							</ul>
							 <input class="degergonder" type="hidden" name="masaAdi" value="" />
						</div>
						<br>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle btn-block" type="button"
								data-toggle="dropdown" id="eklepopupcorbaAdi" name="btncorbaAdi" >
								Corba Seciniz <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<c:forEach items="${corbalar}" var="temp">
									<li ><a href="#"  data-value="${temp}" >${temp}</a></li>
								</c:forEach>
							</ul>
							 <input class="degergonder" type="hidden" name="corbaAdi" value="" />
						</div>
						<br>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle btn-block" type="button"
								data-toggle="dropdown" id="eklepopupanayemekAdi" name="btnyemekAdi" >
								Ana Yemek Seciniz <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<c:forEach items="${anayemekler}" var="temp">
									<li ><a href="#"  data-value="${temp}" >${temp}</a></li>
								</c:forEach>
							</ul>
							<input class="degergonder" type="hidden" name="yemekAdi" value="" />
						</div>
						<br>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle btn-block" type="button"
								data-toggle="dropdown" id="eklepopupsalataAdi" name="btnsalataAdi" >
								Salata Seciniz <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<c:forEach items="${salatalar}" var="temp">
									<li ><a href="#"  data-value="${temp}" >${temp}</a></li>
								</c:forEach>
							</ul>
							<input class="degergonder" type="hidden" name="salataAdi" value="" />
						</div>
						<br>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle btn-block" type="button"
								data-toggle="dropdown" id="eklepopuptatliAdi" name="btntatliAdi" >
								Tatli Seciniz <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<c:forEach items="${tatlilar}" var="temp">
									<li ><a href="#"  data-value="${temp}" >${temp}</a></li>
								</c:forEach>
							</ul>
							<input class="degergonder" type="hidden" name="tatliAdi" value="" />
						</div>	
						<br>					
						 <label class="eklepopupsiparisDurumu"> <span>Siparis
								Durumu</span> <input id="eklepopupsiparisDurumu"
							name="siparisDurumu" value="" type="text"">
						</label> <label class="eklepopupsiparisId" style="visibility: collapse;">
							<span>Siparis ID</span> <input id="eklepopupsiparisId"
							name="siparisId" value="1" type="text"">
						</label> <input type="submit" value="Ekle">
					</fieldset>
				</form>
			</div>


			<div id="guncelle-box" class="guncelle-popup">
				<a href="#" class="guncellekapat"><img src="../photos/close_pop.png"
					class="btn_close" title="Pencereyi Kapat" alt="Kapat" /></a>
				<form id="guncelle-form" method="post" class="signin"
					action="#" method="post">
					<fieldset class="textbox">
						<div class="dropdown" >
							<button class="btn btn-secondary dropdown-toggle btn-block" type="button"
								data-toggle="dropdown" id="guncellepopupmasaAdi"  name="btnmasaAdi" value="serdar">
								Masa Seciniz <span class="caret"></span>
							</button>
							
							<ul class="dropdown-menu"  >
								<c:forEach items="${masalar}" var="temp">
									<li ><a href="#"  data-value="${temp}" >${temp}</a></li>
								</c:forEach>
							</ul>
							 <input class="degergonder" type="hidden" name="guncellemasaAdi" value="" />
						</div>
						<br>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle btn-block" type="button"
								data-toggle="dropdown" id="guncellepopupcorbaAdi" name="btncorbaAdi" >
								Corba Seciniz <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<c:forEach items="${corbalar}" var="temp">
									<li ><a href="#"  data-value="${temp}" >${temp}</a></li>
								</c:forEach>
							</ul>
							 <input class="degergonder" type="hidden" name="guncellecorbaAdi" value="" />
						</div>
						<br>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle btn-block" type="button"
								data-toggle="dropdown" id="guncellepopupanayemekAdi" name="btnyemekAdi" >
								Ana Yemek Seciniz <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<c:forEach items="${anayemekler}" var="temp">
									<li ><a href="#"  data-value="${temp}" >${temp}</a></li>
								</c:forEach>
							</ul>
							<input class="degergonder" type="hidden" name="guncelleanayemekAdi" value="" />
						</div>
						<br>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle btn-block" type="button"
								data-toggle="dropdown" id="guncellepopupsalataAdi" name="btnsalataAdi" >
								Salata Seciniz <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<c:forEach items="${salatalar}" var="temp">
									<li ><a href="#"  data-value="${temp}" >${temp}</a></li>
								</c:forEach>
							</ul>
							<input class="degergonder" type="hidden" name="guncellesalataAdi" value="" />
						</div>
						<br>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle btn-block" type="button"
								data-toggle="dropdown" id="guncellepopuptatliAdi" name="btntatliAdi" >
								Tatli Seciniz <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<c:forEach items="${tatlilar}" var="temp">
									<li ><a href="#"  data-value="${temp}" >${temp}</a></li>
								</c:forEach>
							</ul>
							<input class="degergonder" type="hidden" name="guncelletatliAdi" value="" />
						</div>	
						<br>					
						 <label class="guncellepopupsiparisDurumu"> <span>Siparis
								Durumu</span> <input id="guncellepopupsiparisDurumu"
							name="guncellesiparisDurumu" value="" type="text"">
						</label> <label class="eklepopupsiparisId" style="visibility: collapse;">
							<span>Siparis ID</span> <input id="eklepopupsiparisId"
							name="siparisId" value="1" type="text"">
						</label> <input type="submit" value="Ekle">
					</fieldset>
				</form>
			</div>
			
		<!--  <div id="guncelle-box" class="guncelle-popup">
				<a href="#" class="guncellekapat"><img
					src="../photos/close_pop.png" class="btn_close"
					title="Pencereyi Kapat" alt="Kapat" /></a>
				<form id="guncelle-form" method="post" class="signin" action="#">
					<fieldset class="textbox">
						<label class="guncellepopupmasaAdi"> <span>masa</span> <input
							id="guncellepopupmasaAdi" name="guncellemasaAdi" value=""
							type="text">
						</label> <label class="guncellepopupcorbaAdi"> <span>corba</span>
							<input id="guncellepopupcorbaAdi" name="guncellecorbaAdi"
							value="" type="text">
						</label> <label class="guncellepopupanayemekAdi"> <span>Anayemek</span>
							<input id="guncellepopupanayemekAdi" name="guncelleanayemekAdi"
							value="" type="text">
						</label> <label class="guncellepopupsalataAdi"> <span>Salata</span>
							<input id="guncellepopupsalataAdi" name="guncellesalataAdi"
							value="" type="text">
						</label> <label class="guncellepopuptatliAdi"> <span>Tatli</span>
							<input id="guncellepopuptatliAdi" name="guncelletatliAdi"
							value="" type="text">
						</label> <label class="guncellepopupsiparisDurumu"> <span>Siparis
								Durumu</span> <input id="guncellepopupsiparisDurumu"
							name="guncellesiparisDurumu" value="" type="text">
						</label> <input type="submit" value="Guncelle">
					</fieldset>
				</form>
			</div>
			 -->	
		</div>
		<div class="col-md-1"></div>
	</div>
	<script src="webjars/jquery/2.2.4/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>
var selectedSiparisId = "";

$(document).ready(function() {

	/*window.onload = function() {
	    if(!window.location.hash) {
	        window.location = window.location + '#loaded';
	        window.location.reload();
	    }
	}*/
    //Check if the current URL contains '#'
 /*   if(document.URL.indexOf("#")==-1){
        // Set the URL to whatever it was plus "#".
        url = document.URL+"#";
        location = "#";

        //Reload the page
        location.reload(true);
    }
  */  
	//dropdown listesindeki secileni dropdownliste ve hidden text'e yazar. Hidden text'i submitle gonderebildigimiz için kullandik..
	$(".dropdown-menu li a").click(function() {
		  $(this).parents(".dropdown").find('.btn').html($(this).text() + ' <span class="caret"></span>');
		  $(this).parents(".dropdown").find('.btn').val($(this).data('value'));
		  $(this).parents(".dropdown").find('.degergonder').val($(this).data('value'));
		  
	});
	
	/************************************************/
	// Ekle
	$('#siparisEkleButton').on('click', function(e) {
		e.preventDefault();
		console.log("siparisEkleButton clicked ");
		// Getting the variable's value from a link 
		var ekleBox = $(this).attr('href');//butonun href'i
		console.log("ekleBox :  " + ekleBox);
		eklePopup(ekleBox);

	});

	/************************************************/
	// Guncelle
	$('.guncelle').on(
			'click',
			function(e) {
				e.preventDefault();
				window.selectedSiparisId = "";
				// Getting the variable's value from a link 
				var guncelleBox = $(this).attr('href');
				var $siparisId = $(this).attr("id");
				window.selectedSiparisId = $siparisId;
				if (window.selectedSiparisId == "") {
					return;
				}
				console.log("guncelle clicked ");

				var $masa = $(this).parent() // Moves up from <a> to <td>
				.parent() // Moves up from <td> to <tr>     
				.find("#masaAdi") // Gets a descendent with id="masaAdi"
				.text(); // Retrieves the text within <td> 
				var $corba = $(this).parent() // Moves up from <a> to <td>
				.parent() // Moves up from <td> to <tr>     
				.find("#corbaAdi") // Gets a descendent with id="corbaAdi"
				.text(); // Retrieves the text within <td>     	

				var $anayemek = $(this).parent() // Moves up from <a> to <td>
				.parent() // Moves up from <td> to <tr>     
				.find("#anayemekAdi") // Gets a descendent with id="anayemekAdi"
				.text(); // Retrieves the text within <td>     	

				var $salata = $(this).parent() // Moves up from <a> to <td>
				.parent() // Moves up from <td> to <tr>     
				.find("#salataAdi") // Gets a descendent with id="salataAdi"
				.text(); // Retrieves the text within <td>     	

				var $tatli = $(this).parent() // Moves up from <a> to <td>
				.parent() // Moves up from <td> to <tr>     
				.find("#tatliAdi") // Gets a descendent with id="tatliAdi"
				.text(); // Retrieves the text within <td>    

				var $siparisdurumu = $(this).parent() // Moves up from <a> to <td>
				.parent() // Moves up from <td> to <tr>     
				.find("#siparisDurumu") // Gets a descendent with id="siparisDurumu"
				.text(); // Retrieves the text within <td>  

				console.log("masa :  " + $masa + "\n"
						+ "corba : " + $corba + "\n"
						+ "anayemek : " + $anayemek
						+ "\n" + "salata: " + $salata
						+ "\n" + "tatli: " + $tatli
						+ "\n" + "siparisdurumu: "
						+ $siparisdurumu
						+ "selectedSiparisId: "
						+ window.selectedSiparisId);

				guncellePopup($siparisId, $masa,
						$corba, $anayemek, $salata,
						$tatli, $siparisdurumu,
						guncelleBox);

			});

	$('a.eklekapat, #maskEkle').on(
			'click',
			function() {
				$('#maskEkle , .ekle-popup').fadeOut(
						300, function() {
							$('#maskEkle').remove();
						});
				return false;
			});

	// When clicking on the button close or the maskGuncelle layer the popup closed
	$('a.guncellekapat, #maskGuncelle').on(
			'click',
			function() {
				$('#maskGuncelle , .guncelle-popup')
						.fadeOut(
								300,
								function() {
									$('#maskGuncelle')
											.remove();
								});
				return false;
			});

	$("#guncelle-form")
			.submit(
	function(event) {
		event.preventDefault();
		console
				.log("guncelle-form clicked ");
		console
				.log("event.currentTarget  : "
						+ event.currentTarget);

		var new_masaAdi = $(
				"input[name='guncellemasaAdi']",
				this).val();
		var new_corbaAdi = $(
				"input[name='guncellecorbaAdi']",
				this).val();
		var new_anayemekAdi = $(
				"input[name='guncelleanayemekAdi']",
				this).val();
		var new_salataAdi = $(
				"input[name='guncellesalataAdi']",
				this).val();
		var new_tatliAdi = $(
				"input[name='guncelletatliAdi']",
				this).val();
		var new_siparisDurumu = $(
				"input[name='guncellesiparisDurumu']",
				this).val();

		console
				.log("Yeni masaAdi :  "
						+ new_masaAdi
						+ "\n"
						+ "Yeni corbaAdi : "
						+ new_corbaAdi
						+ "\n"
						+ "Yeni anayemekAdi : "
						+ new_anayemekAdi
						+ "\n"
						+ "Yeni salataAdi: "
						+ new_salataAdi
						+ "\n"
						+ "Yeni tatliAdi: "
						+ new_tatliAdi
						+ "\n"
						+ "Yeni siparisDurumu: "
						+ new_siparisDurumu
						+ "\n"
						+ " siparisId: "
						+ window.selectedSiparisId);
		/*	    var search = {
		 "pName" : "bhanu",
		 "lName" :"prasad"
		 }
		 */
		/*WebSiparisModel attribute'lari ile ayni isimlendirmede olmalidir.*/
		var search = {
			"siparisId" : window.selectedSiparisId,
			"masaAdi" : new_masaAdi,
			"corbaAdi" : new_corbaAdi,
			"yemekAdi" : new_anayemekAdi,
			"salataAdi" : new_salataAdi,
			"tatliAdi" : new_tatliAdi,
			"siparisDurumu" : new_siparisDurumu

		}
	$.ajax({
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			url : "/siparis-guncelle",
			// data: JSON.stringify(search), // Note it is important
			data : search, // Note it is important
			success : function(
					result) {
				// do what ever you want with data
				alert("Basarili");
				window.location.href = '/garson';
			},
			error : function(
					xhr,
					textStatus,
					error) {
				console
						.log(xhr.statusText);
				console
						.log(textStatus);
				console
						.log(error);
				var err = JSON
						.parse(xhr.responseText);
				alert(err.message);
			}
		});
});

});

		function eklePopup(boxAttr) {
			console.log("eklePopup calisti. ");
			$(boxAttr).fadeIn(300);
			//Set the center alignment padding + border
			var popMargTop = ($(boxAttr).height() + 24) / 2;
			var popMargLeft = ($(boxAttr).width() + 24) / 2;
			$(boxAttr).css({
				'margin-top' : -popMargTop,
				'margin-left' : -popMargLeft
			});

			// Add the maskEkle to body
			$('body').append('<div id="maskEkle"></div>');
			$('#maskEkle').fadeIn(300);
		}

		function guncellePopup(siparisId, masa, corba, anayemek, salata, tatli,
				siparisdurumu, boxAttr) {
			console.log("guncellePopup calisti. ");
			//Fade in the Popup and add close button
			$(boxAttr).fadeIn(300);

			//Set the center alignment padding + border
			var popMargTop = ($(boxAttr).height() + 24) / 2;
			var popMargLeft = ($(boxAttr).width() + 24) / 2;
			$(boxAttr).css({
				'margin-top' : -popMargTop,
				'margin-left' : -popMargLeft
			});

			// Add the mask to body
			$('body').append('<div id="maskGuncelle"></div>');
			$('#maskGuncelle').fadeIn(300);
		}

		function searchRow() {
			var val2 = $.trim($("#masaSecici").text()).toLowerCase();
			var $rows = $('#siparisTablosu > tbody > tr').not(".header");
			val2 = (val2 === "hepsi") ? "" : val2;
			console.log("val2 : " + val2);
			$("#siparisTablosu tr").filter(function() {
				$(this).toggle($(this).text().toLowerCase().indexOf(val2) > -1)
			});

		}
		function searchMasa(siparis) {
			var filter, table, tr, td, i;

			$("#masaSecici").html(siparis);
			console.log("masaSecici : " + siparis);
			if (siparis == "hepsi") {
				$("#masaSecici").html("Hepsi");
				//	$("#deviceSelector").html("Hepsi");

			}

			searchRow();
		}
	</script>
</body>
</html>