<!DOCTYPE html>
<html lang="en">
<head>
	<title>Profile Management</title>
  <meta charset = "UTF-8" />
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
      <a class="nav-link" href="ProfileMgt.html">Profile Management</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="QuoteForm.html">Quote Form</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="History.html">History</a>
    </li>
  </ul>
</div>
</nav>
		<div class="container-login100" style="background-image: url('css/images/Bk3.jfif');">

			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" method = "post" action = "profilemgt.do">
					<span class="login100-form-title p-b-49">
						Profile Management
					</span>

          <div class="form-group">
              <label for="fullname">Full Name<span style="color:red">*</span></label>
              <input type="Name" class="form-control" name = "fullname" id="fullname"placeholder="Enter Full Name" value=<%= request.getParameter("fname") %> maxlength = "50" required/>
          </div>

          <div class="form-group">
              <label for="address1">Address 1<span style="color:red">*</span></label>
              <input type="Name" class="form-control" name="address1" id="address1"placeholder="Enter your Address" value=<%= request.getParameter("add1") %> maxlength = "100" required/>
          </div>

          <div class="form-group">
              <label for="address2">Address 2</label>
              <input type="Name" class="form-control" name = "address2" id="address2" value=<%= request.getParameter("add2") %> placeholder="Enter your Address" maxlength = "100">
          </div>

          <div class="form-group">
              <label for="city">City<span style="color:red">*</span></label>
              <input type="Name" class="form-control" name = "city" id="city"placeholder="Enter City" value=<%= request.getParameter("city") %> maxlength = "100" required/>
          </div>

          <div class="form-group">
              <label for="state">State<span style="color:red">*</span></label><br>
              <select id="cars" id="state"placeholder="Enter State" name = "state" class="form-control" value=<%= request.getParameter("state") %> maxlength = "2" required>
              <option value="" selected disabled hidden placeholder="Enter State"></option>
              <option value="tx">TX</option>
              <option value="ca">CA</option>
              <option value="il">IL</option>
              <option value="ny">NY</option>
            </select>
            <!--  <input type="Name" class="form-control" id="state"placeholder="Enter State" maxlength = "2" required/>-->
          </div>

          <div class="form-group">
              <label for="zipcode">Zip Code<span style="color:red">*</span></label>
              <input type="Number" class="form-control" name = "zip" id="zipcode"placeholder="Enter Zip" value=<%= request.getParameter("zip") %> maxlength = "9" minlength="5" required />
          </div>

					<div class="container-login100-form-btn">
						<button type="submit" class="btn btn-primary btn-lg" onclick="checkLength()">Submit
						</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	function checkLength(){
	    var textbox = document.getElementById("zipcode");
	    if(textbox.value.length <= 9 && textbox.value.length >= 5){
					return true
	    }
	    else
	    {
	      alert("Zipcode should be of 5-9 characters long")

	    }

	}

	</script>

</body>
</html>
