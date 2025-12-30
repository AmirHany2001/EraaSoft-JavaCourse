
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
        background-color: #f4f6f9;
        margin: 0;
        padding: 20px;
    }

    h1 {
        font-size: 18px;
        color: #333;
        background: #ffffff;
        padding: 10px 15px;
        margin: 8px 0;
        border-left: 5px solid #4CAF50;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    h1:first-of-type {
        font-size: 26px;
        text-align: center;
        background: #4CAF50;
        color: #fff;
        border-left: none;
    }

    h1:nth-of-type(11) {
        background: #2196F3;
        color: #fff;
        border-left: none;
        text-align: center;
    }
</style>

</head>
<body>
<body>
    <div class="container">
        <h1>Result</h1>
        
        <%
		    String firstName = request.getParameter("firstName");
		    String secondName = request.getParameter("secondName");
		
		    boolean validName = true;
		
		    if (firstName == null || secondName == null ||
		        firstName.isEmpty() || secondName.isEmpty()) {
		        validName = false;
		    }
		    else if (!firstName.matches("[a-zA-Z]+") ||
		             !secondName.matches("[a-zA-Z]+")) {
		        validName = false;
		    }
		
		    if (!validName) {
		%>
		        <div class="message error">No name was written</div>
		<%
		    } else {
		%>
		        <div class="message success">
		            Your Full Name is: <%= firstName %> <%= secondName %>
		        </div>
		<%
		    }
		%>
		
		  <br><br>

        <%
            String ageRequest = request.getParameter("age"); 
            Integer age = null;

            if (ageRequest != null && !ageRequest.isEmpty()) {
                try {
                    age = Integer.parseInt(ageRequest);
            %>
            		<div class="message success">Your age is: <%= age %></div>
            <%         
                } catch (NumberFormatException e) {
                    age = null;
            %>
            		<div class="message error">No age was written</div>
            <%         
                }
            }
        %>
            


    </div>
</body>
</html>