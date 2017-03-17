<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: igor2i
  Date: 23.02.17
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Авторизация</h1>
<div>
    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
        <input type="text" name="j_username" placeholder="Login" value="">
        <input type="password"name="j_password" placeholder="Password" required value="">
        <button type="submit">Войти</button>
    </form>
</div>
<br>
<a href="/registration">Зарегистрироваться</a>

</body>
</html>
