<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String concatenate (String name , int id ){
			return "my name is " + name + " with id " +id ;	
	}
	
	%>
	<%
		String name = "amir";
		int id  = 20010343;
		
		out.print(concatenate(name , id));
	%>		
</body>
</html>