<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%! //선언문
   
   String str = "안녕하세요!";
   
   int a=5, b=-5;
   
   public int abs(int n ) {
	   return n>0? n : -n;
   }
   
   
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int c = 100;	// int 아래에 통용 됨
	out.println(str + "<br>");
	out.println(c + "<br>");
	out.println(a + "의 절대값 : " + abs(a));
	out.println(a + "의 절대값 : " + abs(a));
%>
<hr>
<%
	c = 120;
	out.println(str + "<br>");
	out.println(c + "<br>");
	out.println(a + "의 절대값 : " + abs(a));
	out.println(a + "의 절대값 : " + abs(a));
%>
</body>
</html>