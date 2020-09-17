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
/** popup**/
/*.container-fluid {width: 960px; margin: 0 auto; overflow: hidden;}
*/
#content {	float: left; width: 100%;}
.post { margin: 0 auto; padding-bottom: 50px; float: left; width: 960px; }

#maskEkle {
	display: none;
	background: #000; 
	position: fixed; left: 0; top: 0; 
	z-index: 10;
	width: 100%; height: 100%;
	opacity: 0.8;
	z-index: 999;
}
.ekle-popup{
	display:none;
	background: #333;
	padding: 10px; 	
	border: 2px solid #ddd;
	float: left;
	font-size: 1.2em;
	position: fixed;
	top: 50%; left: 50%;
	z-index: 99999;
	box-shadow: 0px 0px 20px #999;
	-moz-box-shadow: 0px 0px 20px #999; /* Firefox */
    -webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
	border-radius:3px 3px 3px 3px;
    -moz-border-radius: 3px; /* Firefox */
    -webkit-border-radius: 3px; /* Safari, Chrome */
}
#maskGuncelle {
	display: none;
	background: #000; 
	position: fixed; left: 0; top: 0; 
	z-index: 10;
	width: 100%; height: 100%;
	opacity: 0.8;
	z-index: 999;
}
.guncelle-popup{
	display:none;
	background: #333;
	padding: 10px; 	
	border: 2px solid #ddd;
	float: left;
	font-size: 1.2em;
	position: fixed;
	top: 50%; left: 50%;
	z-index: 99999;
	box-shadow: 0px 0px 20px #999;
	-moz-box-shadow: 0px 0px 20px #999; /* Firefox */
    -webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
	border-radius:3px 3px 3px 3px;
    -moz-border-radius: 3px; /* Firefox */
    -webkit-border-radius: 3px; /* Safari, Chrome */
}
img.btn_close {
	float: right; 
	margin: -28px -28px 0 0;
}
fieldset { 
	border:none; 
}
form.signin .textbox label { 
	display:block; 
	padding-bottom:7px; 
}
form.signin .textbox span { 
	display:block;
}

form.signin p, form.signin span { 
	color:#999; 
	font-size:11px; 
	line-height:18px;
} 

form.signin .textbox input { 
	background:#666666; 
	border-bottom:1px solid #333;
	border-left:1px solid #000;
	border-right:1px solid #333;
	border-top:1px solid #000;
	color:#fff; 
	border-radius: 3px 3px 3px 3px;
	-moz-border-radius: 3px;
    -webkit-border-radius: 3px;
	font:13px Arial, Helvetica, sans-serif;
	padding:6px 6px 4px;
	width:200px;
}

form.signin input:-moz-placeholder { color:#bbb; text-shadow:0 0 2px #000; }
form.signin input::-webkit-input-placeholder { color:#bbb; text-shadow:0 0 2px #000;  }


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
					<h3 align="center" style="color: aqua;">Depo Gorevlisi Sayfasi</h3>
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
						<li href="javascript:void(0)"
							onclick="searchTableProduct('hepsi')"><a href="#">Hepsi</a></li>
						<c:forEach items="${depolar}" var="temp">
							<li><a href="javascript:void(0)"
								onclick="searchTableProduct(this.innerHTML)">${temp}</a></li>
						</c:forEach>
					</ul>
				</div>
				
				<div class="row">
				<a id="urunEkleButton" class=" btn btn-primary btn-lg"
					href="#ekle-box" style="position: absolute; right: 10%;">Urun
					Ekle</a>
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
							<td>ISLEM</td>
						</tr>
					</thead>
					<tbody id="urunTablosu">
						<c:forEach items="${urunler}" var="temp">
							<tr id="urun">
								<td id="depoAdi">${temp.depoAdi}</td>
								<td id="markaAdi">${temp.markaAdi}</td>
								<td id="urunAdi">${temp.urunAdi}</td>
								<td id="urunTurAdi">${temp.urunTurAdi}</td>
								<td>
									<!-- <a  id="guncelle" class="btn btn-info" onclick=""
									href="/urun-guncelle?id=${temp.urunId}">Guncelle</a>  --> <a id="${temp.urunId}"
									href="#guncelle-box" class="btn btn-info guncelle">Guncelle</a> <a
									class="btn btn-danger"
									onclick="return confirm('Silmek istediginizden emin misiniz?')"
									href="/urun-sil?urunid=${temp.urunId}">Sil</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>


			<div id="ekle-box" class="ekle-popup">
				<a href="#" class="eklekapat"><img src="../photos/close_pop.png"
					class="btn_close" title="Pencereyi Kapat" alt="Kapat" /></a>
				<form id="ekle-form" method="post" class="signin" action="urun-ekle" method="post">
					<fieldset class="textbox">
						<label class="eklepopupdepoAdi"> <span>depo adi</span> <input
							id="eklepopupdepoAdi" name="depoAdi" value="" type="text">
						</label> 
						<label class="eklepopupMarka"> <span>Marka</span> <input
							id="eklepopupMarka" name="markaAdi" value="" type="text"">
						</label>
						<label class="eklepopupUrun"> <span>Urun adi</span> <input
							id="eklepopupUrun" name="urunAdi" value="" type="text">
						</label> 
						<label class="eklepopupUrunTur"> <span>Urun Tur</span> <input
							id="eklepopupUrunTur" name="urunTurAdi" value="" type="text"">
						</label>
						<label class="eklepopupUrunId" style="visibility: collapse;"> <span>Urun ID</span> <input
							id="eklepopupUrunId" name="urunId" value="1" type="text"">
						</label>
						  <input type="submit" value="Ekle">
						  
					</fieldset>
				</form>
			</div>
			
			<div id="guncelle-box" class="guncelle-popup">
				<a href="#" class="guncellekapat"><img src="../photos/close_pop.png"
					class="btn_close" title="Pencereyi Kapat" alt="Kapat" /></a>
				<form id="guncelle-form" method="post" class="signin" action="#">
					<fieldset class="textbox">
						<label class="popupdepoAdi"> <span>depo adi</span> <input
							id="popupdepoAdi" name="popupdepoAdi" value="" type="text">
						</label> 
						<label class="popupMarka"> <span>Marka</span> <input
							id="popupMarka" name="popupMarka" value="" type="text"">
						</label>
						<label class="popupUrun"> <span>Urun adi</span> <input
							id="popupUrun" name="popupUrun" value="" type="text">
						</label> 
						<label class="popupUrunTur"> <span>Urun Tur</span> <input
							id="popupUrunTur" name="popupUrunTur" value="" type="text"">
						</label>
						  <input type="submit" value="Guncelle">
						  
					</fieldset>
				</form>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	<script src="webjars/jquery/2.2.4/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>

var selectedUrunId = "";

$(document).ready(function() {

/************************************************/	
	  // Ekle
    $('#urunEkleButton').on('click', function (e) {
        e.preventDefault();
      	console.log("urunEkleButton clicked ");	    
        	// Getting the variable's value from a link 
		var ekleBox = $(this).attr('href');//butonun href'i
		console.log("ekleBox :  " + ekleBox);	
	    eklePopup(ekleBox);


    } );
    
/************************************************/	
    // Guncelle
    $('.guncelle').on('click', function (e) {
        e.preventDefault();
        window.selectedUrunId = "";
        	// Getting the variable's value from a link 
		var loginBox = $(this).attr('href');
		var $urunId = $(this).attr("id");
		window.selectedUrunId=$urunId;
		if(window.selectedUrunId == ""){
			return;
		}
      	console.log("guncelle clicked ");	    



		var $depo = $(this).parent()             // Moves up from <a> to <td>
				  		  .parent()            // Moves up from <td> to <tr>     
				  		 .find("#depoAdi")     // Gets a descendent with id="depoAdi"
				         .text();         // Retrieves the text within <td> 
		var $marka = $(this).parent()             // Moves up from <a> to <td>
 		  					.parent()            // Moves up from <td> to <tr>     
 		 					.find("#markaAdi")     // Gets a descendent with id="markaAdi"
        					.text();         // Retrieves the text within <td>     	

		var $urun = $(this).parent()             // Moves up from <a> to <td>
							.parent()            // Moves up from <td> to <tr>     
							.find("#urunAdi")     // Gets a descendent with id="urunAdi"
							.text();         // Retrieves the text within <td>     	

		var $urunTur = $(this).parent()             // Moves up from <a> to <td>
							.parent()            // Moves up from <td> to <tr>     
							.find("#urunTurAdi")     // Gets a descendent with id="depoAdi"
							.text();         // Retrieves the text within <td>     	


        								  
	    console.log("depo :  " +  $depo  + "\n"+
	    	    	"marka : " + $marka + "\n"+ 
	    	    	"urun : " + $urun   + "\n"+
	    	    	"urunTur: " + $urunTur + "\n" +
	    	    	"urunId: " + $urunId);
	    
	    guncellePopup($urunId,$depo,$marka,$urun,$urunTur,loginBox);


    } );

	$('a.eklekapat, #maskEkle').on('click', function() { 
		  $('#maskEkle , .ekle-popup').fadeOut(300 , function() {
			$('#maskEkle').remove();  
		}); 
			return false;
	});
		  
	// When clicking on the button close or the maskGuncelle layer the popup closed
	$('a.guncellekapat, #maskGuncelle').on('click', function() { 
	  $('#maskGuncelle , .guncelle-popup').fadeOut(300 , function() {
		$('#maskGuncelle').remove();  
	}); 
	return false;
	});


    $("#guncelle-form").submit(function(event) {
        event.preventDefault(); 
    	console.log("guncelle-form clicked ");	 
    	console.log("event.currentTarget  : " + event.currentTarget);	 

    	var new_depoAdi = $("input[name='popupdepoAdi']",this).val();
        var new_marka = $("input[name='popupMarka']",this).val();
        var new_urun = $("input[name='popupUrun']",this).val();
        var new_urunTur = $("input[name='popupUrunTur']",this).val();
        var urunId = $("input[name='popupUrunId']",this).val();
        
	    console.log("Yeni depo :  " +  new_depoAdi  + "\n"+
    	    	"Yeni marka : " + new_marka + "\n"+ 
    	    	"Yeni urun : " + new_urun   + "\n"+
    	    	"Yeni urunTur: " + new_urunTur + "\n" +
    	    	" urunId: " +  window.selectedUrunId);
/*	    var search = {
	    	      "pName" : "bhanu",
	    	      "lName" :"prasad"
	    	   }
*/
		/*WebUrunModel attribute'lari ile ayni isimlendirmede olmalidir.*/
	    var search = {
	      "urunId" :  window.selectedUrunId,
	      "markaAdi" :new_marka,
	      "urunAdi" : new_urun,
	      "urunTurAdi" :new_urunTur,
	      "depoAdi" :new_depoAdi,
	   }
	    	   $.ajax({
	    	       type: "POST",
	    	       contentType : 'application/json; charset=utf-8',
	    	       dataType : 'json',
	    	       url: "/urun-guncelle",
	    	      // data: JSON.stringify(search), // Note it is important
	    	       data: search, // Note it is important
	    	       success :function(result) {
	    	       // do what ever you want with data
	    	        	alert("Basarili");
	    	    	   window.location.href = '/depogorevlisi';
	    	       },
	    	       error : function(xhr, textStatus, error){
	    	    	      console.log(xhr.statusText);
	    	    	      console.log(textStatus);
	    	    	      console.log(error);
	    	    	   var err = JSON.parse(xhr.responseText);
	    	    	   	alert(err.message);
		           }
	    	   });
       });

    
} );

function eklePopup(boxAttr){
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

function guncellePopup(urunId,depo,marka,urun,urunTur,boxAttr){
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