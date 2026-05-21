<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String user=(String) session.getAttribute("user"); %>
	<h1>Welcome <%=user %></h1>
	<form action="AddStud.jsp" method="post">
	Click here to Add student <input type="submit" value="Add">
	</form><br>
	<form action="ViewSrv" method="post">
	Click here to View student  <input type="submit" value="View">
	</form><br>
	<form action="UpdateSrv" method="post">
	Click here to Update student  <input type="submit" value="Update">
	</form><br>
	<form action="DeleteSrv" method="post">
	Click here to Delete student  <input type="submit" value="Delete">
	</form>
	<h2><a href='Login.jsp'>Logout</a></h2>
</body>
</html>