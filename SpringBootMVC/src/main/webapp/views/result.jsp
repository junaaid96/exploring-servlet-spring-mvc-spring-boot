<%@page language="java" %>

<html>
<body>
<head>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Simple Calculator</title>
</head>
<h1>Simple Calculator</h1>
<%--<p>Result: <%= session.getAttribute("result") %></p>--%>
<%--another way to display the result: JSTL--%>
<p>Result: ${result}</p>
</body>
</html>