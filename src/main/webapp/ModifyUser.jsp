<%@ page import="Servlets.InitServlet" %>
<%@ page import="Users.ListUsers" %>
<%@ page import="Users.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: emile
  Date: 19/01/2020
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
    <title>Modify User</title>
</head>
<body>
<%
    ListUsers users = (ListUsers) request.getServletContext().getAttribute(InitServlet.CONTEXT_USERS);
    User user = users.getUserByName(request.getParameter("name"));
    config.getServletContext().setAttribute("USER", user); %>

<h1>Modifier l'utilisateur : <c:out value= "${applicationScope.USER.getUsername()}"></c:out></h1>
<body class="align-content-center">
<div class="container-fluid">
    <h1 class="h3 mb-3 font-weight-normal">Modify User form</h1>
    <form method="post" action="ModifyUser" _lpchecked="1">
        <div class="form-group">
            <label for="id">Mail</label>
            <input type="text" id="mail" name="mail" value="<c:out value= "${applicationScope.USER.getEmail()}"></c:out>" placeholder="New Name" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <div class="form-group">
            <label for="id">Username</label>
            <input type="text" id="id" name="id" value="" placeholder="New Name" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <div class="form-group">
            <label for="id">Password</label>
            <input type="password" id="password" name="password" value="" placeholder="Password" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <div class="form-group">
            <label for="id">Mode</label>
            <input type="text" id="mode" name="HeureDeb" value="" placeholder="Mode" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <button type="submit" class="btn btn-dark" name="commit" value="/ModifyUser">submit</button>

    </form>
</div>
</body>
</body>
</html>
