<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- if  -->
<c:if test="${param.color==1}">
	<h1>빨강</h1>
</c:if>

<c:if test="${param.color==2}">
	<h1>파랑</h1>
</c:if>

<c:if test="${param.color==3}">
	<h1>노랑</h1>
</c:if>


<!-- switch case와 같은 개념 -->
<c:choose>

	<c:when test="${param.color==1}">
		<h1>빨강2</h1>
	</c:when>
	
	<c:when test="${param.color==2}">
		<h1>파랑2</h1>
	</c:when>
	
	<c:when test="${param.color==3}">
		<h1>빨강2</h1>
	</c:when>
	
	
</c:choose>


</body>
</html>