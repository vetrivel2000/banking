<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/db" user="root" password="Vetri@50"/>
  <sql:query var="rs" dataSource="${db}">select * from CustomerInfo</sql:query>
  <c:forEach items="${rs.rows}" var="customer">
  <br> <c:out value="${customer.CustomerName}"></c:out>
  </c:forEach>
</body>
</html>