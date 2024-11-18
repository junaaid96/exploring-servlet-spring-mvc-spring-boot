<%@page language="java" %>

<html>
<body>
<head>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Programmer</title>
</head>
<h1>Add A Programmer</h1>

<form action="addProg">
    <label for="pid">Enter an ID:</label>
    <input type="number" id="pid" name="pid" required>
    <br>
    <label for="pname">Full Name:</label>
    <input type="text" id="pname" name="pname" required>
    <br>
    <label for="course">Course:</label>
    <input type="text" id="course" name="course" required>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>