<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add Planet</title>
</head>
<body>
<h2>Insert Planet</h2>
<form action="addPlanet" method="post">
    <label for="namePlanet">Name Planet:</label>
    <br>
    <input type="text" name="namePlanet" id="namePlanet">
    <br>
    <label for="massPlanet">Mass:</label>
    <br>
    <input type="text" name="massPlanet" id="massPlanet">
    <br>
    <label for="habitablePlanet">Habitable:</label>
    <br>
    <input type="text" name="habitablePlanet" id="habitablePlanet">
    <br><br>
    <input type="submit" value="Submit">
</form>
<form action="updateRemoveServletController" method="post">
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
                <td>${planet.getHabitable()}</td>
                <td><input type="submit" name="${planet.getName()}" value="UpdatePlanetController"></td>
            </tr>
        </c:forEach>
        <tr><input type="submit" name="delete" value="DELETE ALL SELECTED"></tr>
    </table>
</form>
</body>
</html>
