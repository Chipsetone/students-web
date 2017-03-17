<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: igor2i
  Date: 23.02.17
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListUsers</title>
</head>
<body>
<h1>List Users</h1>
<table>
    <thead>
        <td>Фамилия</td>
        <td>Имя</td>
        <td>год рождения</td>
        <td>пол</td>
        <td>Группа</td>
    </thead>
<c:forEach items="${list}" var="item">

        <tr>
            <td>${item.getFirstName()}</td>
            <td>${item.getLastName()}</td>
            <td>${item.getDob()}</td>
            <td>${item.getMale()}</td>
            <td>${item.getIdGroup()}</td>
            <td><form action="/del?id=${item.getId()}" method="post">
                <input type="submit"  value="Del"/>
            </form>
            </td>
        </tr>

</c:forEach>
</table>

<form action="/edit" method="GET">
    <input type="submit"  value="Add new User"/>
</form>

</body>
</html>
