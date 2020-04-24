<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Quote History</title>
	<link rel="icon" type="image/png" href="images/icons/titleLogo.jfif"/>

	<link rel="stylesheet" type="text/css" href="./vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./css/util.css">
	<link rel="stylesheet" type="text/css" href="./css/main2.css">
		<style><%@include file="/WEB-INF/views/vendor/bootstrap/css/bootstrap.min.css"%></style>
	<style><%@include file="/WEB-INF/views/css/util.css"%></style>
	<style><%@include file="/WEB-INF/views/css/main.css"%></style>
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
	<form class="login100-form validate-form" method = "post" action = "History.do">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="collapse navbar-collapse" id="navbarText">
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">

<!--        <a class="nav-link" href="ProfileMgt.html">Profile Management</a> -->
       <button type = "submit" name="action" value="Profile Management" class="nav-link" "rules">Profile Management</a></button>
    </li>

    <li class="nav-item">
<!--       <a class="nav-link" href="History.html">History</a> -->
		<button type = "submit" name="action" value="Quote Form" class="nav-link" "rules">Quote Form</a></button>
    </li>
        </li>
        <li class="nav-item">
<!--       <a class="nav-link" href="History.html">History</a> -->
		<button type = "submit" name="action" value="Log Out" class="nav nav-link navbar-right" id="logout" "rules">Log Out</a></button>
    </li>
  </ul>
</div>
</nav>
</form>
		<div class="container-table100" style="background-image: url('css/images/Bk3.jfif')">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Gallons</th>
								<th class="column2">Delivery Address</th>
								<th class="column3">Delivery Date</th>
								<th class="column4">Suggeted Price($)</th>
								<th class="column5">Total Amount($)</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${BL}" var="g">
								<tr>
									<td class="column1">${g.get(0)}</td>
									<td class="column2">${g.get(1)}</td>
									<td class="column3">${g.get(2)}</td>
									<td class="column4">${g.get(3)}</td>
									<td class="column5">${g.get(4)}</td>
								</tr>
						</c:forEach>
								<tr>
									<td class="column1"></td>
									<td class="column2"></td>
									<td class="column3"></td>
									<td class="column4"></td>
									<td class="column5"></td>
								</tr>
								<tr>
									<td class="column1"></td>
									<td class="column2"></td>
									<td class="column3"></td>
									<td class="column4"></td>
									<td class="column5"></td>
								</tr>

								<tr>
									<td class="column1"></td>
									<td class="column2"></td>
									<td class="column3"></td>
									<td class="column4"></td>
									<td class="column5"></td>
								</tr>
								<tr>
									<td class="column1"></td>
									<td class="column2"></td>
									<td class="column3"></td>
									<td class="column4"></td>
									<td class="column5"></td>
								</tr>
								<tr>
									<td class="column1"></td>
									<td class="column2"></td>
									<td class="column3"></td>
									<td class="column4"></td>
									<td class="column5"></td>
								</tr>
								<tr>
									<td class="column1"></td>
									<td class="column2"></td>
									<td class="column3"></td>
									<td class="column4"></td>
									<td class="column5"></td>
								</tr>
								<tr>
									<td class="column1"></td>
									<td class="column2"></td>
									<td class="column3"></td>
									<td class="column4"></td>
									<td class="column5"></td>
								</tr>
								<tr>
									<td class="column1"></td>
									<td class="column2"></td>
									<td class="column3"></td>
									<td class="column4"></td>
									<td class="column5"></td>
								</tr>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script src="js/main.js"></script>

</body>
</html>