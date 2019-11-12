<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateRemoveServletController" method="post">
    <table>
        <tr>
            <th>For Delete</th>
            <th>ID</th>
            <th>Name</th>
            <th>Mass</th>
            <th>Habitable</th>
        </tr>
        <c:forEach var="planet" items="${planets}">
            <tr>
                <td><input type="checkbox" name="selectedPlanets" value="${planet.getName()}"></td>
                <td>${planet.getId()}</td>
                <td>${planet.getName()}</td>
                <td>${planet.getMass()}</td>
                <td>${planet.isHabitable()}</td>
                <td><input type="submit" name="${planet.getName()}" value="UpdatePlanetController"></td>
            </tr>
        </c:forEach>
        <tr>
            <td><input type="submit" name="delete" value="DELETE ALL SELECTED"></td>
        </tr>
    </table>
</form>
</body>
</html>
