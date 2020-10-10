<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center><br>
<br>
<font color="green"><h1>Dear Customer , <%=session.getAttribute("name")    %>       your Transactions are</h1></font>
<br>
<br>
<h2>Money Credited:</h2>
<ol>
<%
ArrayList<String> arraylist1=(ArrayList<String>)session.getAttribute("arraylist1");
ArrayList<Integer> arraylist=(ArrayList<Integer>)session.getAttribute("arraylist");
for(Integer x : arraylist)
{	if(x>0)
	out.println("<li>"+x+"</li>");

}
%>
</ol>
<br/><br/>
<h2>Money debited:</h2>
<ol>
<%
for(Integer x : arraylist)
{	if(x<0)
	out.println("<li>"+x+"</li>");
}
%>
</ol>
</center>
</body>
</html>