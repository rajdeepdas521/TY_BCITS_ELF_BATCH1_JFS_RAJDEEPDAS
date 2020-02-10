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
<title>Employee Home Page</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
 <link rel="stylesheet" href="${css}/consumerlogin.css"> 
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

</head>
<body>
<h1 style="color: coral; font-style: italic;"><b>Welcome To Discom Home</b></h1>
<h4 style="color: coral; font-style: italic; text-align: center;"><b>Employee HomePage</b></h4>
   <table border="4" style="width: 100%; height: 80px">
  <tr style="background: transparent;;; color: white; height: 30px">
  
  <th><a href="homePage">Home</a></th>
  <th><a href="./employeeDetail">My Detail</a></th>
  <th><a href="./consumerDetails">Consumer Details</a></th>
  <th><a href="./billGeneration">Bill Generation</a></th>
  <th><a href="#">Month To Month Revenue</a></th>  
  <th><a href="./emplogout">Logout</a>
</table>





<script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<script src="/jquery/jquery-3.4.1.js"></script>

<jsp:include page="footer.jsp" />

</body>
</html>