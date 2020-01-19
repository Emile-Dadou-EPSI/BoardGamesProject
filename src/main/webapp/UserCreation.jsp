<%--
  Created by IntelliJ IDEA.
  Users.User: emile
  Date: 16/01/2020
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Creation user page</title>
</head>
<body class="align-content-center">
    <div class="container-fluid">
        <h1 class="h3 mb-3 font-weight-normal">New user creation form</h1>
    <form method="post" action="creationUser" _lpchecked="1">
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" value="" placeholder="Email" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="id" value="" placeholder="username" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" value="" placeholder="password" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <div class="form-group">
            <label for="mode">Mode</label>
            <input type="text" id="mode" name="mode" value="" placeholder="Mode" class="form-control" size="100px" autofocus="" autocomplete="off" style="width: 25rem;">
        </div>
        <button type="submit" class="btn btn-dark" name="commit" value="creationUser">submit</button>

    </form>
    </div>
</body>
</html>
