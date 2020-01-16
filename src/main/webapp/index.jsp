<%--
  Created by IntelliJ IDEA.
  User: emile
  Date: 11/12/2019
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
</head>
<body>
<section class="container">
  <div class="login">
    <h1>Login to Web App</h1>
    <form method="post" action="Login">
      <p><input type="text" name="login" value="" placeholder="Username or Email"></p>
      <p><input type="password" name="password" value="" placeholder="Password"></p>
      <p class="remember_me">
        <label>
          <input type="checkbox" name="remember_me" id="remember_me">
          Remember me on this computer
        </label>
      </p>
      <p class="submit"><input type="submit" name="commit" value="Login"></p>
    </form>
  </div>

  <div class="login-help">
    <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
  </div>
</section>

<section class="about">
  <p class="about-links">
    <a href="http://www.cssflow.com/snippets/login-form" target="_parent">View Article</a>
    <a href="http://www.cssflow.com/snippets/login-form.zip" target="_parent">Download</a>
  </p>
  <p class="about-author">
    &copy; 2012&ndash;2013 <a href="http://thibaut.me" target="_blank">Thibaut Courouble</a> -
    <a href="http://www.cssflow.com/mit-license" target="_blank">MIT License</a><br>
    Original PSD by <a href="http://www.premiumpixels.com/freebies/clean-simple-login-form-psd/" target="_blank">Orman Clark</a>
</section>
</body>
</html>
