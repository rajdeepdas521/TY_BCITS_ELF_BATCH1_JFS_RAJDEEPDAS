<%@page import="com.bcits.projectbcits.bean.CurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%CurrentBill currentBill =(CurrentBill)request.getAttribute("currentBill"); %>
    <jsp:include page="consumerHeader.jsp"/>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<link rel="stylesheet" href="${css}/monthlyConsumption.css">
</head>
<body>
<table border="1"; style="width: 100%">
<thead style="background: black;; color: coral; width: 70%">
<h1 style="text-align: center; color: coral">Welcome To Discom Electricity Portal</h1>
<h3 style="text-align: center; color: coral">Current Bill</h3>
<tr style="height: 50px">
 <td></td>
 <td>Meter Number</td>
 <td><%=currentBill.getMeterNumber() %></td>
</tr>
<tr>
 <td></td>
 <td>consuption Units</td>
 <td><%=currentBill.getConsuptionUnits() %></td>
</tr>

<tr>
 <td></td>
 <td>billAmount</td>
 <td><%=currentBill.getBillAmount() %></td>
</tr>

<tr>
 <td></td>
 <td>dueAmount</td>
 <td><%=currentBill.getDueAmount() %></td>
</tr>

<tr>
 <td></td>
 <td>dueDate</td>
 <td><%=currentBill.getDueDate() %></td>
</tr>
<tr>
 <td></td>
 <td>dueDate</td>
 <td><%=currentBill.getInitialReading()%></td>
</tr>

<tr>
 <td></td>
 <td>dueDate</td>
 <td><%=currentBill.getFinalReading() %></td>
</tr>
</table>

<script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<script src="/jquery/jquery-3.4.1.js"></script>

<jsp:include page="footer.jsp" />

</body>
</html>