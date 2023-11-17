<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/all_css.jsp"%>
</head>
<body>
	<%@include file="../component/navbar.jsp"%>
	<%if(u == null){
		response.sendRedirect("../login.jsp");	
	}
	%>
	
</body>
</html>