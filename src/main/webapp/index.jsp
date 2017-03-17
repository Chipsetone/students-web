<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: igor2i
  Date: 06.03.17
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>root page</h1>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>Welcome : ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/logout" />" > Logout</a></h2>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name == null}">
    <a href="/auth">Войти</a><br>
    <a href="/registration">Зарегистрироваться</a><br>
</c:if>

<a href="/lections">Лекции</a><br>
</body>
</html>
