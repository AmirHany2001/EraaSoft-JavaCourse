<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Page</title>
</head>
<body>

<h2>User Form</h2>

<form action="task2_2.jsp" method="post">

    Full Name:
    <input type="text" name="fullName"><br><br>

    Password:
    <input type="password" name="password"><br><br>

    Age:
    <input type="text" name="age"><br><br>

    Address (Radio):
    <input type="radio" name="addressRadio" value="cairo"> Cairo
    <input type="radio" name="addressRadio" value="alex"> Alex
    <input type="radio" name="addressRadio" value="menofia"> Menofia
    <br><br>

    Address (Select):
    <select name="addressSelect">
        <option value="cairo">Cairo</option>
        <option value="alex">Alex</option>
        <option value="menofia">Menofia</option>
    </select>
    <br><br>

    <input type="submit" value="Submit">

</form>


</body>
</html>
