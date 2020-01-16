<%--
  Created by IntelliJ IDEA.
  User: emile
  Date: 16/01/2020
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu Session</title>
</head>
<body>
<h1>Dans cette partie vous pouvez Créerdes Sessions de jeux !</h1>
    <form method="post" action="CreateSession">
        <p><input type="text" name="id" value="" placeholder="id de la seance"></p>
        <p><input type="date" name="date" value="" placeholder="Date"></p>
        <p><input type="text" name="hD" value="" placeholder="Heure de début"></p>
        <p><input type="text" name="hF" value="" placeholder="Heure de fin"></p>
        <p class="submit"><input type="submit" name="commit" value="CreateSession"></p>
    </form>
</body>
</html>
