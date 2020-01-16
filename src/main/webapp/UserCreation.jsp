<%--
  Created by IntelliJ IDEA.
  User: emile
  Date: 16/01/2020
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creation user page</title>
</head>
<body>
    <form method="post" action="creationUser">
        <p><input type="text" name="id" value="" placeholder="Username or Email"></p>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <p><input type="text" name="mode" value="" placeholder="type d'user"></p>
        <p class="submit"><input type="submit" name="commit" value="creationUser"></p>
    </form>
</body>
</html>
