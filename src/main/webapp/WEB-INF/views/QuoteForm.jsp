<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Quote Form</title>
	<link rel="icon" type="image/png" href="images/icons/titleLogo.jfif"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
		<style><%@include file="/WEB-INF/views/vendor/bootstrap/css/bootstrap.min.css"%></style>
	<style><%@include file="/WEB-INF/views/css/util.css"%></style>
	<style><%@include file="/WEB-INF/views/css/main.css"%></style>
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="collapse navbar-collapse" id="navbarText">
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="nav-link" href="#">Profile Management</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Quote Form</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">History</a>
    </li>
  </ul>
</div>
</nav>
		<div class="container-login100" style="background-image: url('css/images/Bk3.jfif');">

			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" method = "post" action="quote.do" >
					<span class="login100-form-title p-b-49">
						Quote Form
					</span>

          <div class="form-group">
              <label for="gallons">Gallons Needed<span style="color:red">*</span></label>
              <input type="Number" class="form-control" id="gallons" name = "numofgallons" value=${gallons}  placeholder="Enter Number of Gallons Required" required>
          </div>

          <div>
              <label for="del_address">Delivery Address</label>
							<input type="Name" class="form-control" id="del_address" name = "deladd" value=${del_adds}  readonly = "readonly" >
          </div>
					<br>
          <div class="form-group">
              <label for="del_date">Delivery Date</label>
              <input type="date" class="form-control" id="del_date" name = "del_date" value=${date}>
          </div>

					<div class="form-group">
              <label for="sug_price">Suggested Price</label>
              <input type="Number" class="form-control" id="sug_price" name = "sug_price" value=${price} readonly = "readonly">
          </div>

					<div class="form-group">
							<label for="total_amt">Total Amount Due</label>
							<input type="Number" class="form-control" id="total_amt" name="total_amt" value=${total} readonly = "readonly">
					</div>

					<div class="container-login100-form-btn">
						<button type="Submit" class="btn btn-primary btn-lg">Submit
						</div>
				</form>
			</div>
		</div>
	</div>

	<script src="js/main.js"></script>

</body>
</html>
