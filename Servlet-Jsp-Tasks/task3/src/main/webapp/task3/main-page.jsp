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
	String place = "no place";
	
	Cookie [] cookies = request.getCookies();
	
	for(Cookie cookie: cookies){
		if (cookie.getName().equals("favPlace")){
			place = cookie.getValue();
			break;
		}
	}
	%>

	<%= place%>
</body>
</html>