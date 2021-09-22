<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Account</h1>
<form action="connection" method="post">
<table align="center">
<tr style="line-height:50px">
<td><label for="cid"><b>CustomerId</b></label></td>
<td><input type="text" placeholder="Enter your CustomerId" name="id" id="cid" required></td>
</tr>
<tr style="line-height:50px">
<td><label for="amount"><b>InitialDeposit</b></label></td>
<td><input type="text" placeholder="Enter the Amount" name="balance" id="amount" required></td>
</tr >
<tr style="line-height:50px">
<td><input type="submit" name="users" value="SubmitNewAccount"></td>
<td><input type="reset" value="Reset"></td>
</tr>
</table>
</form>
</body>
</html>