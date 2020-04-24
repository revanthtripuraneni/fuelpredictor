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
              <input type="text" class="form-control" name = "fullname" id="fullname" placeholder="Enter Full Name" maxlength="50" required />
          </div>
		  
          <div class="form-group">
              <label for="address1">Address 1<span style="color:red">*</span></label>
              <input type="text" class="form-control" name="address1" id="address1" placeholder="Enter your Address" maxlength="100" required />
          </div>

          <div class="form-group">
              <label for="address2">Address 2</label>
              <input type="text" class="form-control" name = "address2" id="address2" placeholder="Enter your Address" maxlength="100" />
          </div>

          <div class="form-group">
              <label for="city1">City<span style="color:red">*</span></label>
<!--               <input type="text" class="form-control" name = "city" id="city1" placeholder="Enter City" maxlength = "100" required value=${city}/> -->
              <input type="text" class="form-control" name = "city" id="city1" placeholder="Enter City" maxlength = "100" required />
          </div>

          <div class="form-group">
              <label for="state">State<span style="color:red">*</span></label><br>
              <select id="cars" id="state" name = "state" class="form-control" maxlength = "2" required>
              <option placeholder="Enter State" value=${state}></option>
              <option value="AL">AL</option>
				<option value="AK">AK</option>
				<option value="AZ">AZ</option>
				<option value="AR">AR</option>
				<option value="CA">CA</option>
				<option value="CO">CO</option>
				<option value="CT">CT</option>
				<option value="DE">DE</option>
				<option value="DC">DC</option>
				<option value="FL">FL</option>
				<option value="GA">GA</option>
				<option value="HI">HI</option>
				<option value="ID">ID</option>
				<option value="IL">IL</option>
				<option value="IN">IN</option>
				<option value="IA">IA</option>
				<option value="KS">KS</option>
				<option value="KY">KY</option>
				<option value="LA">LA</option>
				<option value="ME">ME</option>
				<option value="MD">MD</option>
				<option value="MA">MA</option>
				<option value="MI">MI</option>
				<option value="MN">MN</option>
				<option value="MS">MS</option>
				<option value="MO">MO</option>
				<option value="MT">MT</option>
				<option value="NE">NE</option>
				<option value="NV">NV</option>
				<option value="NH">NH</option>
				<option value="NJ">NJ</option>
				<option value="NM">NM</option>
				<option value="NY">NY</option>
				<option value="NC">NC</option>
				<option value="ND">ND</option>
				<option value="OH">OH</option>
				<option value="OK">OK</option>
				<option value="OR">OR</option>
				<option value="PA">PA</option>
				<option value="RI">RI</option>
				<option value="SC">SC</option>
				<option value="SD">SD</option>
				<option value="TN">TN</option>
				<option value="TX">TX</option>
				<option value="UT">UT</option>
				<option value="VT">VT</option>
				<option value="VA">VA</option>
				<option value="WA">WA</option>
				<option value="WV">WV</option>
				<option value="WI">WI</option>
				<option value="WY">WY</option>
            </select>
            <!--  <input type="Name" class="form-control" id="state"placeholder="Enter State" maxlength = "2" required/>-->
          </div>

          <div class="form-group">
              <label for="zipcode">Zip Code<span style="color:red">*</span></label>
              <input type="Number" class="form-control" name = "zip" id="zipcode" placeholder="Enter Zip" maxlength = "9" minlength="5" required />
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

		}
	}

	</script>


</body>
</html>
