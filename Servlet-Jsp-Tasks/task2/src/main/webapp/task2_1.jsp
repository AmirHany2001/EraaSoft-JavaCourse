<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Page</title>
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

    /* Form container */
    form {
        background-color: #ffffff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        width: 350px;
    }

    /* Form heading */
    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    /* Input fields and select styling */
    input[type="text"],
    input[type="password"],
    select {
        width: 100%;
        padding: 10px;
        margin: 5px 0 15px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        transition: border-color 0.3s;
    }

    input[type="text"]:focus,
    input[type="password"]:focus,
    select:focus {
        border-color: #4CAF50;
        outline: none;
    }

    /* Radio buttons */
    input[type="radio"] {
        margin-right: 5px;
        margin-left: 10px;
    }

    /* Submit button */
    input[type="submit"] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 12px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    /* Labels styling */
    label {
        font-weight: bold;
        color: #555;
    }
</style>
</head>
<body>



<form action="task2_2.jsp" method="post">

    <label>Full Name:</label>
    <input type="text" name="fullName"><br>

    <label>Password:</label>
    <input type="password" name="password"><br>

    <label>Age:</label>
    <input type="text" name="age"><br>

    <label>Address (Radio):</label>
    <input type="radio" name="addressRadio" value="cairo"> Cairo
    <input type="radio" name="addressRadio" value="alex"> Alex
    <input type="radio" name="addressRadio" value="menofia"> Menofia
    <br><br>

    <label>Address (Select):</label>
    <select name="addressSelect">
        <option value="cairo">Cairo</option>
        <option value="alex">Alex</option>
        <option value="menofia">Menofia</option>
    </select>
    <br>

    <input type="submit" value="Submit">

</form>

</body>
</html>
