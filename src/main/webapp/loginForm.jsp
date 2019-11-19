<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<c:import url="template/menu.html"></c:import>

<c:if test="${errorValidation}">
    <h2>Error Validation</h2>
</c:if>
<%--action = url pattern--%>
<form action="login" method="post">

    <label for="userName">Username:</label>
    <br>
    <input type="text" name="user" id="userName">
    <br>
    <label for="password"> Password: </label>
    <br>
    <input type="password" name="password" id="password">
    <br>
    <input type="submit" value="Login">

</form>
</body>
</html>

