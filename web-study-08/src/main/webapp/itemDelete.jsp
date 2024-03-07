<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	Connection con = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String username = "ezen";
	String password = "1234";
	String sql = "delete from item where name = ?";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection(url, username, password);
		
		request.setCharacterEncoding("utf-8");
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, request.getParameter("name"));
		
		pstmt.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
	}try{
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<h3>상품삭제 완료</h3>
<a href= "itemWrite.jsp">결과 보기</a>
</body>
</html>