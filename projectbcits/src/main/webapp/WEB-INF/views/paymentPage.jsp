<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${css}/paymentPage.css">
<link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet"
	href="/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>

	<form action="./paymentPage">
		<h3>All Type Of Cards Accepted Here</h3>
		<h2>PAYMENT PAGE</h2>

		<table style="margin-left: 600px;">
			<tbody>
				<tr>
					<td><label>Card HolderName:-</label></td>
				</tr>
				<tr>
					<td><input type="text" name=""></td>
				</tr>
				<tr>
					<td><label>Card Number:-</label></td>
				</tr>
				<tr>
					<td><input type="number" name=""></td>
				</tr>
				<tr>
					<td><label>CVV:-</label></td>
				</tr>
				<tr>
					<td><input type="number" name=""></td>
				</tr>

				<tr>
					<td><label>EXP:-</label></td>
				</tr>
				<tr>
					<td><input type="number" name=""></td>
				</tr>




			</tbody>



		</table>
		<input type="submit" value="pay Now">
	</form>
	<script src="${js}/jquery-3.4.1.js"/>
 <script src="${js}/bootstrap.min.js"/>
	<script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
	<script src="/jquery/jquery-3.4.1.js"></script>

</body>
</html>