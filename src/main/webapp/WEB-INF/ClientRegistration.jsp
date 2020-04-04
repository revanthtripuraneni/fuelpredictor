<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Sign Up</title>
	<link rel="icon" type="image/png" href="images/icons/titleLogo.jfif"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/Bk3.jfif');">
          <div class="container">
    </div>
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" method="post" action="registration.do">
					<span class="login100-form-title p-b-49">
						Create New Account
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is required">
						<span class="label-input100">Username<span style="color:red">*</span></span>
						<input class="input100" type="text" name="username" placeholder="Enter a Username" required>
						<span class="focus-input100" data-symbol="&#9981;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password<span style="color:red">*</span></span>
						<input class="input100" type="password" name="pass" placeholder="Enter a Password" required>
						<span class="focus-input100" data-symbol="&#x1F511;"></span>
					</div>
					<br>
					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Confirm Password<span style="color:red">*</span>	</span>
						<input class="input100" type="password" name="pass" placeholder="Re-Enter Password" required>
						<span class="focus-input100" data-symbol="&#x1F511;"></span>
					</div>

          <br><br>

					<div class="container-login100-form-btn">
						<p><font color = "red">${error}</font></p>
						<button type="Submit" class="btn btn-primary btn-lg">Register
						</div>
				</form>
			</div>
		</div>
	</div>

	<script src="js/main.js"></script>

</body>
</html>
