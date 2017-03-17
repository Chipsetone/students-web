<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: igor2i
  Date: 24.02.17
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lections</title>
</head>
<body>
<h1>Lections</h1>
<table>
    <thead>
    <td>Название Лекции</td>
    <td>Описание</td>
    <td>Тема</td>
    <td>Время</td>
    <%--<td>Группа</td>--%>
    </thead>
    <c:forEach items="${lections}" var="item">
        <tr>
            <td>${item.getName()}</td>
            <td>${item.getText()}</td>
            <td>${item.getSubject()}</td>
            <td>${item.getDateTime()}</td>
            <td><form action="/lections?type=edit&id=${item.getId()}" method="post">
                <input type="submit"  value="Edit"/>
            </form>
            </td>
            <td><form action="/lections?type=del&id=${item.getId()}" method="post">
                <input type="submit"  value="Del"/>
            </form>
            </td>

        </tr>
    </c:forEach>
</table>
<form action="/lections?type=add" method="post">
    <input type="submit"  value="Add new"/>
</form>
</body>
</html>
