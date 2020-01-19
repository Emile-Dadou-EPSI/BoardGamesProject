<%--
  Created by IntelliJ IDEA.
  Users.User: emile
  Date: 18/01/2020
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Boardgames</title>
</head>
<body>
    <h1>This is your first connection</h1>
    <p>Please enter your username / email address and the password that have been sent to you by email !</p>
    <form method="post" action="changeDefPsswd">
        <h3><input type="text" name="email" value="" placeholder="Email"></h3>
        <h3><input type="password" name="password" value="" placeholder="Password"></h3>
        <h3><input type="password" name="Npassword" value="" placeholder="New Password"></h3>
        <p class="submit"><input type="submit" name="commit" value="Users.changeDefPsswd"></p>
    </form>
</body>
</html>
