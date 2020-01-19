<%@ page import="BDD.FireStore" %>
<%@ page import="Servlets.InitServlet" %>
<%@ page import="Sessions.ListSessions" %>
<%@ page import="Sessions.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="Users.User" %>
<%@ page import="Users.ListUsers" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: emile
  Date: 19/01/2020
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
    <title class="bd-title">User Management</title>
</head>
<body>
<body class="text-center">
<% %>
<div class="container">
    <div class="row">
        <div class="col-md-8"><h1>Boardgames</h1></div>
        <div class="col-md-4">

            <div class="card" style="width: 25rem;">
                <div class="card-body">
                    <h5 class="card-title">Bienvenue <c:out value="${applicationScope.user.username}"></c:out></h5>
                    <h6 class="card-subtitle"><c:out value="${applicationScope.user.type}"></c:out></h6>
                    <div class="row">
                        <a href="LoggedPageAdmin.jsp" class="col-md-4">Manage Sessions</a>
                        <a href="UserCreation.jsp" class="col-md-4">Create a new user</a>
                        <a href="Logout" class="col-md-4">Deconnexion</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-2">
            <button class="btn btn-lg btn-primary btn-block" style="color: white"><a href="CreateSession.jsp">Create a new Session</a> </button>


        </div>
    </div>
</div>



<table class="table table-hover">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Email</th>
        <th scope="col">Name</th>
        <th scope="col">Password</th>
        <th scope="col">Type</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        //ListUsers users = (ListUsers) request.getServletContext().getAttribute(InitServlet.CONTEXT_USERS);
    %>


    <c:forEach items="${applicationScope.CONTEXT_USERS.getUsers()}" var="user" >
        <tr>
            <% //request.setAttribute("user", user);%>
            <td><p><c:out value="${user.email}"></c:out></p></td>
            <td><p><c:out value="${user.username}"></c:out></p></td>
            <td><p type="password"><c:out value="${user.password}"></c:out></p></td>
            <td><c:out value="${user.type}"></c:out></td>
            <td><a href="ModifyUser.jsp?name=<c:out value="${user.username}"></c:out>">Modify User    </a>    <a href="DeleteUser?name=<c:out value="${user.username}"></c:out>">Delete User</a> </td>

        </tr>
    </c:forEach>

    </tbody>
</table>


</body>
</body>
</html>
