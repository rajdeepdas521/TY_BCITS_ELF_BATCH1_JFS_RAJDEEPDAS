<%@page import="com.bcits.projectbcits.bean.ConsumerMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%ConsumerMasterBean consumerMasterBean=(ConsumerMasterBean)session.getAttribute("loggedInConsumer"); %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />    
<jsp:include page="consumerHomePage.jsp"/>
<jsp:include page="consumerHeader.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Of Consumer</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<link rel="stylesheet" href="${css}/consumerDetails.css">
</head>
<body style="text-align: center;">
<table border="3"; style="width: 100%; height: 350px; text-align: center;">

<h3 style="text-align: center; color: coral;"><b> Consumer Details</b></h3>


<tr style="color: coral;">
<td><b>Name :</b></td>
<td><%=consumerMasterBean.getName() %></td>
</tr>

<tr style="color: coral;">
<td><b>Meter Number :</b></td>
<td><%=consumerMasterBean.getMeterNumber() %></td>
</tr>

<tr style="color: coral;">
<td><b>Mobile Number :</b></td>
<td><%=consumerMasterBean.getMobilenum() %></td>
</tr>

<tr style="color: coral;">
<td><b>Email Adress :</b></td>
<td><%=consumerMasterBean.getMailId() %></td>
</tr>

<tr style="color: coral;">
<td><b>Address :</b></td>
<td><%=consumerMasterBean.getAddress() %></td>
</tr>

<tr style="color: coral;">
<td><b>Region :</b></td>
<td><%=consumerMasterBean.getRegion() %></td>
</tr>

<tr style="color: coral;">
<td><b>Type :</b></td>
<td><%=consumerMasterBean.getConsumerType() %></td>
</tr>

<tr style="color: coral;">
<td><b>Password :</b></td>
<td><%=consumerMasterBean.getPassword() %></td>
</tr>

</table>

<jsp:include page="footer.jsp" />
 <script src="${js}/jquery-3.4.1.js"/>
 <script src="${js}/bootstrap.min.js"/>
 
 <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
 <script src="/jquery/jquery-3.4.1.js"></script>
</body>
</html>