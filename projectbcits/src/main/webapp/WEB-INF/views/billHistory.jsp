<%@page import="java.util.List"%>
<%@page import="com.bcits.projectbcits.bean.ConsumerMasterBean"%>
<%@page import="com.bcits.projectbcits.bean.BillHistory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <% List<BillHistory> billHistories=(List<BillHistory>)request.getAttribute("billHistory"); %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<jsp:include page="consumerHeader.jsp"></jsp:include>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill History</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<link rel="stylesheet" href="${css}/billHistory.css">

</head>
<body >

<h1 style="text-align: center; color: coral;">WELCOME TO DISCOM ELECTRICITY PORTAL</h1>
<h6 style="text-align: center; color: coral;">Know Your Bill History</h6>
      
       <%
  if(billHistories !=null){
  %>
  <div align="center">
  <table border="1"; style="width: 100%">
     <thead style="background: black;; color: coral; width: 70%">
       <tr style="height: 50px">
          <th>Meter Number</th>  
           <th>Units</th> 
            <th>Bill Amount</th> 
             <th>Status</th> 
               </tr>
               </thead>
               
              <tbody>
               <%for(BillHistory emBean: billHistories) { %>
               <tr style="height: 40px; color: white;">
               <td> <%=emBean.getBeanPK().getMeterNumber() %> </td>
                <td> <%=emBean.getUnits()%></td>
                 <td> <%=emBean.getBillAmount() %> </td>
                  <td> <%=emBean.getStatus() %></td>
                
                    </tr>
                    <% } %>
                   
                  </tbody>
                    
  
  </table>
  
  
  </div>
  <%} else { %>
  <h2 style="color: red; text-align: center;">No Record Found</h2>
  <%} %> 
      
 <script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<script src="/jquery/jquery-3.4.1.js"></script>

<jsp:include page="footer.jsp" />
      
</form>

</body>
</html>