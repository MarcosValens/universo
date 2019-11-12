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
            <th>Planet</th>
        </tr>
        <c:forEach var="satellite" items="${satellites}">
            <tr>
                <td><input type="checkbox" name="selectedPlanets" value="${satellite.getName()}"></td>
                <td>${satellite.getId()}</td>
                <td>${satellite.getName()}</td>
                <td>${satellite.getMass()}</td>
                <td>${satellite.getSpeed()}</td>
                <td>${satellite.getPlanet().getName()}</td>
                <td><input type="submit" name="${satellite.getName()}" value="UpdatePlanetController"></td>
            </tr>
        </c:forEach>
        <tr>
            <td><input type="submit" name="delete" value="DELETE ALL SELECTED"></td>
        </tr>
    </table>
</form>
</body>
</html>
