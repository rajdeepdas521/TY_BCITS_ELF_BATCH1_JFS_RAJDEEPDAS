<%@page import="com.bcits.projectbcits.bean.ConsumerMasterBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%List<ConsumerMasterBean> consumerMasterBeans=(List<ConsumerMasterBean>)request.getAttribute("consumerMasterBeans"); %>

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
	<link rel="stylesheet" href="${css}/consumerDetails.css">
 
</head>
<body>
<h1 style="text-align: center; color: coral;">WELCOME TO DISCOM ELECTRICITY PORTAL</h1>
<h6 style="text-align: center; color: coral;">Know Your Consumer</h6>

    
  <%
  if(consumerMasterBeans !=null){
  %>
  
      <div align="center">
  <table border="1"; style="width: 100%">
     <thead style="background: black;; color: coral; width: 70%">
       <tr style="height: 50px">
         <th>Sl no.</th>
          <th>Name</th>  
           <th>Meter Number</th>  
           <th>Mobile Number</th> 
            <th>Address</th> 
             <th>Mail Id</th> 
             <th>Region</th>
             <th>Type</th>
             <th>Password</th>
               </tr>
               </thead>
               
                 <tbody>
               <%int i=1 ;  for(ConsumerMasterBean emBean: consumerMasterBeans) { %>
               <tr style="height: 40px; color: white;">
               <td><%=i %></td>
               <td><%=emBean.getName() %>
               <td> <%=emBean.getMeterNumber() %> </td>
                <td> <%=emBean.getMobilenum()%></td>
                 <td> <%=emBean.getAddress() %> </td>
                  <td> <%=emBean.getMailId() %></td>
                  <td> <%=emBean.getRegion() %></td>
                  <td> <%=emBean.getConsumerType() %></td>
                  <td> <%=emBean.getPassword() %></td>
                   <% i++; %>
                    </tr>
                    <%}%>
                   
                  </tbody>
           </table>


 </div>

  <%} else { %>
  
  <h2 style="color: red; text-align: center;">No Record Found</h2>

  
  
  <%} %> 

<jsp:include page="footer.jsp" />
 <script src="${js}/jquery-3.4.1.js"/>
 <script src="${js}/bootstrap.min.js"/>
</body>
</html>