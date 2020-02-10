<%@page import="com.bcits.projectbcits.bean.ConsumerMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<% ConsumerMasterBean consumersMasterBean = (ConsumerMasterBean) request.getAttribute("consumerBean"); %>
<% int initialReading = (int) request.getAttribute("initialReading");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Genration</title>
<%-- <link rel="stylesheet" href="${css}/consumerDetails.css"> --%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
 <link rel="stylesheet" href="${css}/consumerlogin.css"> 
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<jsp:include page="employeeHeader.jsp"></jsp:include>

<body>
	<form action="./generateBillConsumer" method="post" style="color: coral; margin-left: 600px;">
		<h3 style="color: coral; ">Bill Generation</h3>
		<table >
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr style="color: coral;">
				<td><label class="label">Meter Number</label></td>
			</tr>
			<tr style="color: coral;">
				<td><input type="text" class="input" name="meterNumber" 
					value="<%= consumersMasterBean.getMeterNumber() %>"></td>
			</tr>

			<tr>
				<td><label class="label">Initial-Reading</label></td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="initialReading" 
					value="<%= initialReading %>"></td>
			</tr>
			<tr>
				<td><label class="label">Final-Reading</label></td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="finalReading" ></td>

			</tr>
			<tr>
				<td><label class="label">ConsumerType</label></td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="consumerType" 
					value="<%= consumersMasterBean.getConsumerType()%>"></td>
			</tr>
			<tr>
				<td><label class="label">Set Due Date</label></td>
			</tr>
			<tr>
				<td><input type="date" class="input" name="dueDate" ></td>

			</tr>
			<tr>
				<td><input type="submit" value="Generate">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="Reset"></td>
			</tr>
		</table>

	</form>
	
<script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<script src="/jquery/jquery-3.4.1.js"></script>

<jsp:include page="footer.jsp" />

</body>

</html>