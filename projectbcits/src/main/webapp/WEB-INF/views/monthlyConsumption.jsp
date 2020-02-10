<%@page import="com.bcits.projectbcits.bean.MonthlyConsumption"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%MonthlyConsumption monthlyConsumption=(MonthlyConsumption)request.getAttribute("msg"); %>
    <jsp:include page="consumerHeader.jsp"/>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />    
<jsp:include page="consumerHomePage.jsp"/>    
    
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
<h3 style="text-align: center; color: coral">Monthly Consumption</h3>
<tr style="height: 50px">
<th>Meter Number :</th>
<th>Initial Reading :</th>
<th>Final Reading :</th>
<th>Total Unit :</th>
<th>Bill Amount :</th>
</tr>
</thead>

<tbody>
<tr style="color: white;">
<td><%=monthlyConsumption.getMonthlyConsumptionpk().getMeterNumber()%></td>
<td><%=monthlyConsumption.getInitialReading() %></td>
<td><%=monthlyConsumption.getFinalReading() %></td>
<td><%=monthlyConsumption.getTotalUnit() %></td>
<td><%=monthlyConsumption.getBillAmount() %></td>
</tr>
</tbody>
</table>




 <script src="${js}/jquery-3.4.1.js"/>
 <script src="${js}/bootstrap.min.js"/>
 
 <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
 <script src="/jquery/jquery-3.4.1.js"></script>
 <jsp:include page="footer.jsp" />
</body>
</html>