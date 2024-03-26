<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/header.css">
<title>Insert title here</title>
</head>
<body>
	<div id="goMain">
	<a href="OttServlet?command=main">
	<img alt="로고" src="images/logo.png">
	</a>
	</div>
	<div id="menu" align="left">
		<ul>
			<li><a href="#">컨텐츠</a></li>
			<li><a href="#">게시판</a></li>
			<li><a href="OttServlet?command=qna_list">Q&A</a></li>
		</ul>
	</div>
	<div id="profile">
		<c:choose>
		<c:when test="${!empty member.userId}">
			<c:if test="${member.admin == 1}">
				<input type="image" src="images/profile4.png" onclick="location.href='OttServlet?command=admin_menu'">
			</c:if>
			<c:if test="${member.admin == 0 }">
				<input type="image" src="images/profile3.png" onclick="location.href='main.jsp'">
			</c:if>
		</c:when>
		<c:when test="${empty member.userId}">
		<div class="login"><a href="OttServlet?command=member_login_form" style="margin-top:50px" >로그인이 필요합니다</a></div> 
		</c:when>
		</c:choose>
		</div>
</body>
</html>