<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStudSrv" method="post">
		Id: <input type="number" name="id"><br><br>
		Name: <input type="text" name="name"><br><br>
		Email: <input type="text" name="email"><br><br>
		Course: <input type="text" name="course"><br><br>
		Marks: <input type="number" name="marks"><br><br>
		<input type="submit" value="Add Student"><br><br>
		<h2>Goto ---><a href='Dashboard.jsp'>Dashboard</a></h2>
	</form>
</body>
</html>