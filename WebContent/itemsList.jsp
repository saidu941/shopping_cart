<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		HttpSession session2 = request.getSession(false);
		System.out.println("=====>"+session2.getAttribute("itemsList"));
	%>
	
	
	<table>
		<tr>
			<td>Item Name: <%= session2.getAttribute("Username")%></td>
		</tr>
		<tr>
			<td>Item Price: <%= session2.getAttribute("Username") %></td>
		</tr>
	</table>

</body>
</html>