<%@page import="com.bcits.projectbcits.bean.ConsumerMasterBean"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%List<ConsumerMasterBean> consumersMasterList =(List<ConsumerMasterBean>)request.getAttribute("consumerMasterBeans"); %>  
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    
    <<jsp:include page="employeeHeader.jsp"></jsp:include>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumer Detail</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<link rel="stylesheet" href="${css}/billHistory.css">
</head>
<body>
<h2 style="color: coral; text-align: center;">Welcome To Bill Generation Page</h2>
<% String msg = (String)request.getAttribute("msg"); %>
<% String errMsg = (String)request.getAttribute("errMsg"); %>

<% if(errMsg != null && !errMsg.isEmpty()) {%>
	<h3 style="color:red"><%= errMsg %></h3>
	<%} %>
	
<% if(msg != null && !msg.isEmpty()) {%>
	<h3 style="color:red"><%= msg %></h3>
	<%} %>

     <% if(consumersMasterList != null ){ %>
<table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
	     <thead style='background-color: navy; color: white'>
	         <tr style="height:35px">
	         <th>Meter Number</th>
	         <th>Name</th>
	         <th>Email</th>
	         <th>Phone Number</th>
	         <th>Region</th>
	         <th>Consumer Type</th>
	         <th>Bill Generation</th>
	         </tr>
	     </thead>
	     <% for(ConsumerMasterBean consumersMasterBean : consumersMasterList){ %>
	    		 <form action="./currentBillPageGen">
	    		 <input name="meterNumber" type="text" value="<%= consumersMasterBean.getMeterNumber() %>" hidden="true">
	      <tr style="height:35px; color: white;">
	        <td><%= consumersMasterBean.getMeterNumber() %></td>
	        <td><%= consumersMasterBean.getName() %></td>
	        <td><%= consumersMasterBean.getMailId() %></td>
	        <td><%= consumersMasterBean.getMobilenum() %></td>
	        <td><%= consumersMasterBean.getRegion() %></td>
	        <td><%=consumersMasterBean.getConsumerType() %></td>
	        <td><input type="submit" value="Generate Bill"> 
	        </td>
	        </tr>
	        </form>
	<%} 
	}else{%>
	<%} %>
    
    <script src="/Jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>