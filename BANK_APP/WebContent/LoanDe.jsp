<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Dear Customer ,    <%=  session.getAttribute("name") %> Select the Type of Loan you Need </h2><br><br>
<%String a=request.getParameter("1");
out.println(a);%>
</body>
</html>