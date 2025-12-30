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
		String place = request.getParameter("place");
		Cookie cookie = new Cookie("favPlace" , place);
		cookie.setMaxAge(5);
		response.addCookie(cookie);
	%>
	
	<a href="main-page.jsp">main page</a>
</body>
</html>