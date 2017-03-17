<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: igor2i
  Date: 23.02.17
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<spring:form method="post"  modelAttribute="userJSP" action="registration">

    Name: <spring:input path="login"/> <br/>
    Password: <spring:input path="passwd"/>   <br/>
    <spring:button>Next Page</spring:button>

</spring:form>
</form>
</body>
</html>
