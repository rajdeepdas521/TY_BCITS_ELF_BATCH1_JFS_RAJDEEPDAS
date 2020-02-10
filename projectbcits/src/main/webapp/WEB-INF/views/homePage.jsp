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
    
    <% if(errMsg != null && !errMsg.isEmpty()){ %>
     <h2 style="color: red;"><%=errMsg%></h2>
     <%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/homepage.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


</head>
<body>

<form action="./consumerlogin" method="get">

<nav class="navbar navbar-light bg-light" >
    <a class="navbar-brand" href="" >
      <img src="/images/Bescom-Customer-Care.jpg" width="80" height="60" class="d-inline-block align-top" alt="">
    </a>
    
    <marquee style="color: coral;"><h1>Welcome to Discom homepage</h1> </marquee>
  </nav>
  <div class="container">
    
   <a href="./employeeLoginPage" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Employee Login</a> <br><br>
   <a href="./consumerLoginPage" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Consumer Login</a> <br> <br><br>


  <p>24*7 HelpLine Number </p>
  <p>Complaints : <br> Call xxxxx <br> SMS xxxxxx</p>
  <p>Whatsaap 1800-xxxxx</p>
  <p>discomhelpline@gmail.com</p>
    <jsp:include page="footer.jsp" />
 <script src="${js}/jquery-3.4.1.js"/>
 <script src="${js}/bootstrap.min.js"/>

 </div>
 

 

   
      <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
      <script src="/jquery/jquery-3.4.1.js"></script>
</form>

</body>
</html>