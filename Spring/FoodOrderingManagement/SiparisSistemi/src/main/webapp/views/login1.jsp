<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	type="text/css">
<meta charset="utf-8">
<title>Login</title>

<style>
.col-centered {
	float: none;
	margin: 0 auto;
	margin-top: 200px;
}

</style>
</head>
<body style="background-color: #4b5257">
	<div class="container">
		<div class="col-xs-12 col-sm-8 col-md-4 col-lg-4 col-centered">
			<div class="jumbotron">
				<h3>Lütfen Giris Yapiniz.</h3>
				<form action="login" method="post">
					<div class="form-group">
						<input name="username" type="text" class="form-control"
							placeholder="Kullanici Adi">
					</div>
					<div class="form-group">
						<input name="password" type="password" class="form-control"
							placeholder="Sifre">
					</div>
					<div class="custom-checkbox">
						<label><input type="checkbox"> Beni Hatirla</label>
					</div>
					<button type="submit" class="btn-primary form-control">Giris</button>
				</form>
			</div>
		</div>

	</div>
</body>

</html>