<%--
  Created by IntelliJ IDEA.
  User: igor2i
  Date: 23.02.17
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>new Student</title>
</head>
<body>
<h1>Student</h1>
<form action="/edit" method="post">
    <label for="firstName">firstName:</label>
    <input type="text" name="firstName" id="firstName" value="" placeholder="Input"><br>
    <label for="lastName">lastName:</label>
    <input type="text" name="lastName" id="lastName" value="" placeholder="Input"><br>
    <label for="dob">dob:</label>
    <input type="text" name="dob" id="dob" value="" placeholder="Input"><br>
    <label for="male">male:</label>
    <input type="text" name="male" id="male" value="" placeholder="Input"><br>
    <label for="idGroup">Group:</label>
    <input type="text" name="idGroup" id="idGroup" value="" placeholder="Input"><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
