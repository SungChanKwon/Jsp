<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "MethodServlet"> <!-- URL 잘 적어줘야함 -->
		<input type="submit" value="get 방식으로 처리"> 
	</form>
	<br>
	<br>
	<hr>
	<form action = "MethodServlet" method="post">
		<input type="submit" value="post 방식으로 처리"> 
	</form>
</body>
</html>