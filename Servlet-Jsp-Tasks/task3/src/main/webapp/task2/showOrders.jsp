<%@page import="java.util.Objects"%>
<%@page import="java.util.ArrayList"%>
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
	
	<%
		List<String> orders = (List<String>) session.getAttribute("allOrders");
		
		if(orders == null){
			orders = new ArrayList<>();
			session.setAttribute("allOrders", orders);
		}
		
		String order = request.getParameter("order");
	    if (order != null) {
	        order = order.trim();

	        if (!order.isEmpty() && !order.equalsIgnoreCase("null")) {
	            orders.add(order);
	        }
	    }
		
	%>
		
	 	<div class="result-box">
        <h2>Selected Order is:</h2>
    <%
       		if(!orders.isEmpty()) {
       			for(String or: orders){
    	    		out.print("<div class='order-value'>" + or + "</div>");
    	    	}
       		} else {
       			out.print("<div class='order-value'>no order selected</div>");
       		}
    %>
    	</div>
	
</body>
</html>