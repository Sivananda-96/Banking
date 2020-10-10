<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import ="java.time.format.DateTimeFormatter" %>
	<%@ page import ="java.time.LocalDateTime" %>
	<%@ page import ="java.time.LocalTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
</head>
<body><center>
	<b><font color ="green"><h1>Welcome  <%=session.getAttribute("name") %>.</h1></font></b><br>
	<br><br>
<h2>	<a href="CheckBalance">Click here to known your balance</a></h2>
<h2>	<a href="Transfer.jsp">Click here to Transfer Money</a></h2>
<h2>	<a href="Statement">Your Statement</a></h2>
<h2>	<a href="Loan.jsp">Click here to apply for Loan</a></h2>
<h2>	<a href="ChangePwd.jsp">Click here to Change your Password</a></h2></center><
<% 
//TimeFormatter dtf=TimeFormatter.ofPattern("HH:mm:ss");
//LocalDateTime now = LocalDateTime.now();
//dtf=java.time.LocalTime.now();
//out.println(now);
String pattern="01:00:00.000";
LocalTime now1=LocalTime.now();
String no=now1.toString();

out.println(now1);
if(no==pattern)
{
}%>
</body>
</html>