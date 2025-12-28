<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
<style>
    /* General body styling */
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Result container */
    .result-container {
        background-color: #ffffff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        width: 400px;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    /* Paragraph styling */
    p {
        font-size: 16px;
        color: #555;
        margin: 10px 0;
    }

    b {
        color: #333;
    }
</style>
</head>
<body>

<div class="result-container">
    <h2>Submitted Data</h2>

    <%
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String addressRadio = request.getParameter("addressRadio");
        String addressSelect = request.getParameter("addressSelect");
    %>

    <p><b>Full Name:</b> <%= fullName %></p>
    <p><b>Password:</b> <%= password %></p>
    <p><b>Age:</b> <%= age %></p>
    <p><b>Address (Radio):</b> <%= addressRadio %></p>
    <p><b>Address (Select):</b> <%= addressSelect %></p>
</div>

</body>
</html>
