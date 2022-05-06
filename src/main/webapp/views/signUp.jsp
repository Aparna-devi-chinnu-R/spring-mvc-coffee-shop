<%--
  Created by IntelliJ IDEA.
  User: aparnadevi
  Date: 07/05/22
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<form action="/sign-up" method="post">
  <input type="text" name="username">
  <input type="password" name="password" value="password">
  <input type="password" name="confirm password" value="confirm password">
  <input type="submit" value="submit">
</form>
</body>
</html>
