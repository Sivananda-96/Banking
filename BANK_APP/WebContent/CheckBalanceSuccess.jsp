<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CheckBalanceSuccess</title>
</head>
<body><center>
<font color="green"><h1>Dear customer,  <%= session.getAttribute("name")
%></h1><br></font>
<h3>your balance is:</h3>
<h2><%= session.getAttribute("balance")
%></h2></center>
</body>
</html>