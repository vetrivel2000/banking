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
<h1>Accounts</h1>
<form action="connection" method="post">
<table border="1" width=100%>
<tr>
<th>AccountNo</th>
<th>CustomerId</th>
<th>Balance</th>
<th>DeleteAccount</th>
</tr>
 <c:forEach items="${account}" var="account">
 <tr>
 <td>${account.accountNumber}</td>
 <td>${account.customerId}</td>
 <td>${account.balance}</td>
 <td><a href="http://localhost:8080/BankingApplication/connection?users=DeleteAccount&accountNum=${account.accountNumber}&customerId=${account.customerId}">Delete</a></td>
 </tr>
 </c:forEach>
</table><br><br>
<table  width=100%>
 <tr>
 <th><input type="submit" name="users" value="AddAccount"></th>
 </tr>
</table>
</form>
</body>
</html>