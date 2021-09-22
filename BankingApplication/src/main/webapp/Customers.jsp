<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Customers</h1>
<form action="connection" method="post">
<table border="1" width=100%>
<tr>
<th>CustomerId</th>
<th>Name</th>
<th>Mobile</th>
<th>Delete</th>
</tr>
 <c:forEach items="${output}" var="customer">
 <tr>
 <td>${customer.customerId}</td>
 <td>${customer.name}</td>
 <td>${customer.mobileNo}</td>
 <td><a href="http://localhost:8080/BankingApplication/connection?users=DeleteCustomer&customerId=${customer.customerId}">Delete</a></td>
 </tr>
 </c:forEach>
</table><br><br>
<table  width=100%>
 <tr>
  <th><input type="submit" name="users" value="AddCustomer"></th>
 </tr>
</table>
</form>
</body>
</html>