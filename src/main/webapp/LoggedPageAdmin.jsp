<%--
  Created by IntelliJ IDEA.
  Users.User: emile
  Date: 18/01/2020
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="BDD.FireStore" %>
<%@ page import="java.util.List" %>
<%@ page import="Sessions.Session" %>
<%@ page import="Sessions.ListSessions" %>
<%@ page import="Servlets.InitServlet" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Boardgames</title>
        </head>
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
                        <a href="ModifyUser.jsp" class="col-md-4">Edit Profile</a>
                        <a href="UserManagement.jsp" class="col-md-4">Manage Users</a>
                        <a href="CreateSession.jsp" class="col-md-4">Create a new session</a>
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
        <th scope="col">Name</th>
        <th scope="col">Date</th>
        <th scope="col">Horaires</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <% FireStore fireStore = new FireStore();
        List<Session> sessions = fireStore.getSessions();
        ListSessions Sessions = (ListSessions) request.getServletContext().getAttribute(InitServlet.CONTEXT_SESSIONS);
    %>


    <c:forEach items="${applicationScope.CONTEXT_SESSIONS.getSessions()}" var="session" >
        <tr>
        <% request.setAttribute("session", session);%>
        <td><p><c:out value="${session.name}"></c:out></p></td>
        <td><c:out value="${session.date}"></c:out></td>
        <td><c:out value="${session.hD}"></c:out> <c:out value="${session.hF}"></c:out></td>
        <td><a href="ModifySession.jsp?name=<c:out value="${session.name}"></c:out>">Modify Session    </a>    <a href="DeleteSession?name=<c:out value="${session.name}"></c:out>">Delete Session</a> </td>

        </tr>
    </c:forEach>








    </tbody>
</table>


</body>
</html>
