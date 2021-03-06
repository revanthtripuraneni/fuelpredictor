<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
<body onload=hideButtons()>

	<div class="limiter">
	<form class="login100-form validate-form" method = "post" action = "profilemgt.do">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="collapse navbar-collapse" id="navbarText">
  <ul class="navbar-nav mr-auto">

    <li class="nav-item">
<!--       <a class="nav-link" href="QuoteForm.html">Quote Form</a> -->
			<button type = "submit" name="action" value="Quote Form" id="button1" class="nav-link" "rules">Quote Form</a></button>
    </li>
    <li class="nav-item">
<!--       <a class="nav-link" href="History.html">History</a> -->
		<button type = "submit" name="action" value="History" class="nav-link" id="button2" "rules">History</a></button>
    </li>
        <li class="nav-item">
<!--       <a class="nav-link" href="History.html">History</a> -->
		<button type = "submit" name="action" value="Log Out" class="nav nav-link navbar-right" id="logout" "rules">Log Out</a></button>
    </li>
  </ul>
</div>
</nav>
		<div class="container-login100" style="background-image: url('css/images/Bk3.jfif');">

			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<!-- <form class="login100-form validate-form" method = "post" action = "profilemgt.do"> -->
					<span class="login100-form-title p-b-49">
						Profile Management
					</span>

          <div class="form-group">
           <input type="hidden" name="name" id="id" value=${profile}>
              <label for="fullname">Full Name<span style="color:red">*</span></label>
              <input type="text" class="form-control" name = "fullname" id="fullname" placeholder="Enter Full Name" maxlength="50" required value=${fname} />
          </div>
		  
          <div class="form-group">
              <label for="address1">Address 1<span style="color:red">*</span></label>
              <input type="text" class="form-control" name="address1" id="address1" placeholder="Enter your Address" maxlength="100" required value=${add1} />
          </div>

          <div class="form-group">
              <label for="address2">Address 2</label>
              <input type="text" class="form-control" name = "address2" id="address2" placeholder="Enter your Address" maxlength="100" value=${add2} />
          </div>

          <div class="form-group">
              <label for="city1">City<span style="color:red">*</span></label>
<!--               <input type="text" class="form-control" name = "city" id="city1" placeholder="Enter City" maxlength = "100" required value=${city}/> -->
              <input type="text" class="form-control" name = "city" id="city1" placeholder="Enter City" value=${city} maxlength = "100" required />
          </div>

          <div class="form-group">
              <label for="state">State<span style="color:red">*</span></label><br>
<!--               <select id="cars" id="state" name = "state" class="form-control" value=${state} maxlength = "2" required> -->
<!--               <option placeholder="Enter State" value=${state}></option> -->
<!--               <option value="tx">TX</option> -->
<!--               <option value="ca">CA</option> -->
<!--               <option value="il">IL</option> -->
<!--               <option value="ny">NY</option> -->
<!--             </select> -->
					<input type="text" class="form-control" name = "state" id="state" placeholder="Enter State" value=<%= request.getAttribute("state") %> />
            <!--  <input type="Name" class="form-control" id="state"placeholder="Enter State" maxlength = "2" required/>-->
          </div>

          <div class="form-group">
              <label for="zipcode">Zip Code<span style="color:red">*</span></label>
              <input type="Number" class="form-control" name = "zip" id="zipcode" placeholder="Enter Zip" value=${zip} maxlength = "9" minlength="5" required />
          </div>

					<div class="container-login100-form-btn">
						<p><font color = "red">${error}</font></p><br><br>
						<button type="submit" class="btn btn-primary btn-lg" name="action" id="sub" value="Submit" onclick="checkLength()">Submit</button>
						</div>
				</form>
			</div>
		</div>
	</div>
		  	<script type="text/javascript">
	function checkLength(){
	    var textbox = document.getElementById("zipcode");
	    if(textbox.value.length <= 9 && textbox.value.length >= 5){
					return true;
	    }
	    else
	    {
	      alert("Zipcode should be of 5-9 characters long");
		  return false;

	    }

	}
	
	function hideButtons()
	{
		var x = document.getElementById("id").value;

		if(x==="no")
		{
				document.getElementById("button2").disabled = true;
				document.getElementById("button1").disabled = true;
		}
		else if(x==="yes")
		{
			document.getElementById("sub").disabled = true;
			document.getElementById("fullname").readOnly = true;
			document.getElementById("address1").readOnly = true;
			document.getElementById("address2").readOnly = true;
			document.getElementById("city1").readOnly = true;
			document.getElementById("state").readOnly = true;
			document.getElementById("zipcode").readOnly = true;

		}
	}

	</script>


</body>
</html>
