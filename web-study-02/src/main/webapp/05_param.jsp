<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="param.js"></script>
</head>
<body>

	<form action="ParamServlet" name="frm"> <!--method 생략하면 기본 get 방식으로 요청 -->
		아이디 : <input type="text" name="id" value="free"><br> <!-- nbsp 한 칸 띄어줌 -->
		암&nbsp;&nbsp;호 : <input type="password" name="pass" value="1234"> <br>
		
		<input type="submit" value="로그인" onclick="return check()">
	</form>
	
</body>
</html>