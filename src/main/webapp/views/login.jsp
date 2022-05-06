<%--
  Created by IntelliJ IDEA.
  User: aparnadevi
  Date: 06/05/22
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h2>Login please</h2>
<form action="/" method="POST">
    <input name="Name" type="text" />
    <input name="Password" type="password"/>
    <input type="submit" value="submit" style="size: 15px" />
</form>
${status}
<form action="/sign-up" method="GET">
    <div>New customer?</div>
    <input type="submit" name="signup" value="Signup">
</form>
</body>
</html>
