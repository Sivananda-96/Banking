<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
<br>
<br>
<br>
<br>
<br>
<font color ="green"><h1>Dear Customer ,    <%=  session.getAttribute("name") %> Select the Type of Loan you Need </h1><br><br></font>
<form action="LoanDe.jsp"><h2>
<input type="radio" name="1" value="Home Loan"      >            HomeLoan<br>
<input type="radio" name="1" value="Eduction Loan"> EduationLoan<br>
<input type="radio" name="1" value="Personal Loan"> PersonalLoan<br>
<input type="submit" value="Select"/></form></center></h2>
</body>
</html>