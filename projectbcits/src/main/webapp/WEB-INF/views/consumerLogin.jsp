<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<% String errMsg = (String) request.getAttribute("errMsg"); %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<% String msg = (String)request.getAttribute("msg"); %>
<% if(msg != null && !msg.isEmpty()) {%>
<h3 style="color: green"><%= msg %></h3>
<%} %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumer Login</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/consumerlogin.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

</head>
<body>
<% if(errMsg != null && !errMsg.isEmpty()){ %>
     <h2 style="color: red;"><%=errMsg%></h2>
     <%} %>

<form action="./consumerlogin" method="post">

	<div class="container">
		<div
			class="col-xs-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5 mx-auto d-block">

			<h1 style="font-style: italic;">WELCOME TO DISCOM ELECTRICITY PORTAL</h1>
			<div>
				<label for=""><b> Meter Number :- </b></label> <input type="number"
					name="meterNumber" placeholder="Enter Valid Meter Number" id=""><br>


				<label for=""> <b>Password :-</b></label> 
				<input type="password" name="password" placeholder="Enter Valid Password" id=""> <br>


				<input type="submit">
			 <input type="reset" value="Reset">
			</div>

			<h4 style="font-style: italic;">New User?</h4>

			<input type="button" value="Register"
				onclick="location.href='signUpPage';">


			<script src="${js}/jquery-3.4.1.js"></script>
			<script src="${js}/bootstrap.min.js"></script>

		</div>
	</div>
	
</form>	
	<script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
	<script src="/jquery/jquery-3.4.1.js"></script>



</body>
</html>