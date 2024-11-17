<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
    <p>Time on server is <%= new java.util.Date() %>
    </p>
</h1>
<br/>
<%--<a href="hello">Hello Servlet</a>--%>
<a href="<%= request.getContextPath() %>/hello">Hello Servlet</a>
</body>
</html>