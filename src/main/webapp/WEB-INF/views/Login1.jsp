<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<link rel="icon" type="image/png" href="images/icons/titleLogo.jfif"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./util.css">
	<link rel="stylesheet" type="text/css" href="./main.css">
		<style><%@include file="/WEB-INF/views/vendor/bootstrap/css/bootstrap.min.css"%></style>
	<style><%@include file="/WEB-INF/views/css/util.css"%></style>
	<style><%@include file="/WEB-INF/views/css/main.css"%></style>
<!--===============================================================================================-->
<style>
body {
    background-image: url(""src/main/webapp/WEB-INF/views/Bk3.jfif"");
}

</style>


</head>
<body>

	<div class="limiter">
		<div class="container-login100" style="background-image: url('css/images/Bk3.jfif');">
          <div class="container">
    </div>
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" method="post" action="login.do">
					<span class="login100-form-title p-b-49">
						Login
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is required">
						<h1> ${name} </h1>
						<span class="label-input100">Username<span style="color:red">*</span></span>
						<input class="input100" type="text" name="username" placeholder="Enter your Username" required>
						<span class="focus-input100" data-symbol="&#9981;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password<span style="color:red">*</span></span>
						<input class="input100" type="password" name="pass" placeholder="Enter your Password" required>
						<span class="focus-input100" data-symbol="&#x1F511;"></span>
					</div>

          <br><br>

					<div class="container-login100-form-btn">
						<p><font color = "red">${error}</font></p>
						<button type="Submit" class="btn btn-primary btn-lg">Submit</button>
					</div>
				</form>
          <br><br>
					<div class="text-center">
					<form class="login100-form validate-form" method="get" action="registration.do">
						<span>
							<button type="Submit" class="btn btn-primary btn-lg">New User</button>
							
						</span>
					</form>
					</div>
						</div>
				
			</div>
		</div>
	</div>

	<script src="js/main.js"></script>

</body>
</html>
