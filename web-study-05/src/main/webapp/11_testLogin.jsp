<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = "kwon";
	String pwd = "0328";
	String name = "권성찬";
	
	if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd")) ) {
		session.setAttribute("loginUser", name);
		response.sendRedirect("11_main.jsp");
	}else {
		response.sendRedirect("11_loginForm.jsp");
	}
%>
	
	
</body>
</html>