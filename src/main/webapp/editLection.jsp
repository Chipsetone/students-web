<%--
  Created by IntelliJ IDEA.
  User: igor2i
  Date: 24.02.17
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit lection</title>
</head>
<body>
    <h1><%=request.getAttribute("title") != null ? request.getAttribute("title") : ""%></h1>

    <div>
        <form action="/editLection<%=request.getAttribute("id") != null ? "?id="+request.getAttribute("id") : ""%>" method="post">
            <label for="name">name:</label>
            <input type="text" name="name" id="name" value="<%=request.getAttribute("name") != null ? request.getAttribute("name") : ""%>"><br>
            <label for="text">text:</label>
            <input type="text" name="text" id="text" value="<%=request.getAttribute("text") != null ? request.getAttribute("text") : ""%>"><br>
            <label for="subject">subject:</label>
            <input type="text" name="subject" id="subject" value="<%=request.getAttribute("subject") != null ? request.getAttribute("subject") : ""%>"><br>
            <label for="dateTime">dateTime:</label>
            <input type="datetime-local" name="dateTime" id="dateTime" value="<%=request.getAttribute("dateTime") != null ? request.getAttribute("dateTime") : ""%>"><br>

            <input type="submit" value="Submit">
        </form>
        <a href="/lections">Посмотреть все лекции</a><br>
    </div>

</body>
</html>
