<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: marcos
  Date: 12/11/19
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th> For Delete</th>
        <th>Name</th>
        <th>Mass</th>
        <th>Habitable</th>
    </tr>
    <c:forEach var="planet" items="${planets}">
        <tr>
            <td><input type="checkbox" name="selectedPlanets" value="${planet.getName()}"></td>
            <td>${planet.getName()}</td>
            <td>${planet.getMass()}</td>
            <td>${planet.isHabitable()}</td>
            <td><input type="submit" name="${planet.getName()}" value="UpdatePlanetController"></td>
        </tr>
    </c:forEach>
    <tr><input type="submit" name="delete" value="DELETE ALL SELECTED"></tr>
</table>
</body>
</html>
