<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.saeyan.dao.MemberDAO" %>

<%
	MemberDAO memDAO =  MemberDAO.getInstance();

	Connection con = memDAO.getConnection();
	
	out.println("DB연결 성공 : " + con);
%>