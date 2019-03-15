<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>WAP Lab13</title>
</head>
<body>
<h1>Please, insert your login information.</h1>
<form action="login" method="post">
  <p>UserName: <input name="username" value=${cookie.Username.value}></p>
  <p>Password: <input type="password" name="password"></p>
  <br> <input type="checkbox"
              name="remember" value="yes" checked/> Remember me.
  <p><input type="submit" value="Login"></p>
  <p>${err_msg}</p>
</form>
</body>
</html>