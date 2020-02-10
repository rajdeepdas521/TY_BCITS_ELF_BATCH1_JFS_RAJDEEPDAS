<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html>
<%-- <head>
<meta charset="ISO-8859-1">
<title>SignUp</title>

    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/signup.css">
    <link rel="stylesheet" href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">

</head> --%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>SignUp page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/signup.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>

<body>

	<div class="container">
		<div
			class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5 mx-auto d-block">


			<h1 style="font-style: italic;">Welcome To Discom Electricity
				Private limited</h1>
			<h2 style="font-style: italic;">For New User Sign Up Here</h2>
			<form action="./addConsumer" method="post">
				<label for="" style="color: aliceblue;"> <b> Name :- </b></label> <input
					type="text" name="name" placeholder="Enter your name" id=""
					required> <br> <label for="" style="color: aliceblue;">
					<b> Meter Number :- </b>
				</label> <input type="number" name="meterNumber"
					placeholder="Enter your Meter Number" id="" required> <br>
				<label for="" style="color: aliceblue;"><b> Phone Number
						:-</b></label> <input type="number" name="mobilenum"
					placeholder="Enter Phone Number" id=""> <br> <label
					for="" style="color: aliceblue;"><b> Email Id :-</b></label> <input
					type="email" name="mailId" placeholder="Enter Email Id" id="">
				<br> <label for="" style="color: aliceblue;"><b>
						Address :-</b></label> <input type="text1" name="address"
					placeholder="Address" required> <br> <label
					for="country" style="color: aliceblue;" required><b>
						Choose Region :-</b> <select name="region" class="formcontrol">
						<option placeholder="Select One">Select Region</option>
						<option value="Bangalore South">Bangalore South</option>
						<option value="Bangalore North">Bangalore North</option>
				</select> <br> <label for="country" style="color: aliceblue;" required><b>
							Type :-</b> <select name="consumerType" class="formcontrol2">
							<option placeholder="Select One">Select Type</option>
							<option value="Residential">Residential</option>
							<option value="Commercial">Comercial</option>
					</select> <br> <label for="" style="color: aliceblue;"><b>Password
								:-</b></label> <input type="password" name="password"
						placeholder="Enter New Password" id="myInput" required> <br>


						<label for="" style="color: aliceblue;"><b> Confirm :-<br>
								Password
						</b></label> <input type="password" name="confirmPassword"
						placeholder="Re-enter Password" id="myInput" required> <br>


						<!-- <input type="checkbox" class="form-check-input" id="myInput" onclick="myFunction()"><b> Show Password</b> -->
						<!-- <label class="form-check-label" for="exampleCheck1" ><b> Show Password</b> </label> <br> -->

						<input type="submit" value="Submit"> <input type="reset"
						value="Reset">
			</form>


			<%--  <script src="${js}/signup.js"></script> --%>
		</div>
	</div>
	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>


</body>
</html>