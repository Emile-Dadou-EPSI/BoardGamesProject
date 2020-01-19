<%@ page import="BDD.FireStore" %>
<%@ page import="Servlets.InitServlet" %>
<%@ page import="Sessions.ListSessions" %>
<%@ page import="Sessions.Session" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  Users.User: emile
  Date: 16/01/2020
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Menu Sessions.Session</title>
</head>
<body>
<%ListSessions Sessions = (ListSessions) request.getServletContext().getAttribute(InitServlet.CONTEXT_SESSIONS);
   Session session1 = Sessions.getSessionByName(request.getParameter("name"));
    config.getServletContext().setAttribute("SESSION", session1); %>
<h1>Modifier la session : <c:out value= "${applicationScope.SESSION.getGetName()}"></c:out></h1>
<body class="align-content-center">
<div class="container-fluid">
    <h1 class="h3 mb-3 font-weight-normal">Modify session form</h1>
    <form method="post" action="ModifySession" _lpchecked="1">
        <div class="form-group">
            <label for="ON">Old Name</label>
            <input type="text" id="ON" name="oldname" value="<c:out value= "${applicationScope.SESSION.getGetName()}"></c:out>" placeholder="New Name" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <div class="form-group">
            <label for="id">New Name</label>
            <input type="text" id="id" name="id" value="" placeholder="New Name" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <div class="form-group">
            <label for="date">Date</label>
            <input type="date" id="date" name="date" value="" placeholder="New date" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <div class="form-group">
            <label for="id">Heure Debut</label>
            <input type="text" id="hD" name="HeureDeb" value="" placeholder="Heure Debut" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <div class="form-group">
            <label for="id">Heure Fin</label>
            <input type="text" id="hF" name="HeureFin" value="" placeholder="Heure Fin" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <button type="submit" class="btn btn-dark" name="commit" value="/ModifySession">submit</button>

    </form>
</div>
</body>
</body>
</html>
