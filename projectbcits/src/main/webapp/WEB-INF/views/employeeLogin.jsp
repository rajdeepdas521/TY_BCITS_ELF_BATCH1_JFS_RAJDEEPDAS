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
<title>Insert title here</title>


<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/logg.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


</head>

<body >
<% if(errMsg != null && !errMsg.isEmpty()){ %>
     <h2 style="color: red;"><%=errMsg%></h2>
     <%} %>
    <div class="container">
        <div class="card col-6 col-sm-6 col-md-6 col-lg-6 offset-3 mt-5">
            <div class="card-body">

                <form action="./empLogin" method="post">
                    <legend>Emoloyee Login Portal</legend>

                    <div class="form-group" >
                        <label for="">Employee Id</label>
                        <input type="number" name="empId" id="" placeholder="Enter Id" style="width: 100%">
                    </div>
                    <div class="form-group">
                        <label for="">Password</label>
                        <input type="password" name="password" id="" placeholder="Enter password" style="width: 100%">
                    </div>

                    <input type="submit" style="text-align: center; background-color:  rgb(25, 61, 97); color: white;">
                </form>
                
 <script src="${js}/jquery-3.4.1.js"/>
 <script src="${js}/bootstrap.min.js"/>
                
            </div>
        </div>
    </div>

    <script src="/jquery/jquery-3.4.1.js"></script>
    <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>

</body>
</html>