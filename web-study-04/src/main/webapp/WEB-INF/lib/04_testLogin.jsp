<%@page import="java.net.URLEncoder"%>
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
	String id = "test";
	String pwd = "1234";
	/* String name = "korea"; */
	
	request.setCharacterEncoding("utf-8");
	if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))) {
		
		/*	값을 영어로 전송할때는 아래 코드만 써주면됨
			response.sendRedirect("04_main.jsp?name=" + name)*/
		response.sendRedirect("04_main.jsp?name=" + URLEncoder.encode("홍길동","utf-8"));
		/*  response.sendRedirect("04_main.jsp?name=" + URLEncoder.encode(name,"utf-8"));
			경로에 값을 실어서 보냄 
			값에 한글을 입력해서 전송하려면 URLEncoder.encode(name,"utf-8") 써줘야함
			안써주면 뻑남 */
	}else{
		response.sendRedirect("04_loginForm.jsp");
	}
%>

</body>
</html>	