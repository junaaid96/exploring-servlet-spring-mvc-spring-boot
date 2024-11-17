<%@page language="java" %>

<html>
<body>
<head>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Simple Calculator</title>
</head>
<h1>Simple Calculator</h1>

<form action="add">
    <label for="num1">Number 1:</label>
    <input type="number" id="num1" name="num1" required>
    <br>
    <label for="num2">Number 2:</label>
    <input type="number" id="num2" name="num2" required>
    <br>
    <input type="submit" value="Add">
</form>
</body>
</html>