<%@ page import="java.net.http.HttpResponse" %><%--
  Created by IntelliJ IDEA.
  Users.User: emile
  Date: 11/12/2019
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<section class="container">
  <form class="form-signin" method="post" action="Login" _lpchecked="1">
    <h1 class="h3 mb-3 font-weight-normal">Connectez-vous</h1>

    <div class="alert alert-danger" role="alert">
      <p></p>
    </div>

    <label for="inputEmail" class="sr-only">Login</label>
    <input type="text" id="inputEmail" class="form-control" placeholder="Users.Login" name="login" autofocus="" autocomplete="off">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" autocomplete="off">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>



  </form>
</section>
</body>
</html>
