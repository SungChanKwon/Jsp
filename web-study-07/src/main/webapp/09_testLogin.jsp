<%@page import="java.lang.module.ResolutionException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = "chan";
	String pwd = "1234";
	String name = "권성찬";
	
	if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd")) ) {
		session.setAttribute("loginUser", name);
		response.sendRedirect("09_main.jsp");
	}else {
		response.sendRedirect("09_loginForm.jsp");
	}
%>



</body>
</html>