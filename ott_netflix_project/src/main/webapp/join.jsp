<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/join.css">
<script type="text/javascript" src="js/join.js"></script>
<title>join</title>
</head>
<body>
	<div>
		<h1>영화, 시리즈 등을 무제한으로</h1>
		<p>5,500원으로 시작하세요. 해지는 언제든 가능합니다.</p>
		<p>시청할 준비가 되셨나요? 멤버십을 등록하거나 재시작하려면<br>
		이메일 주소를 입력하세요.</p>			
	</div>
	
	<form method="post" action="signup.jsp">
		<input type="text" name="email" size="20" placeholder="이메일 주소">
		
		<label for="id"></label>
		<input type="submit" id="id" value="시작하기	>">
	</form>
		
		
	
</body>
</html>