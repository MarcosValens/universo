<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planet Added!!</title>
</head>
<body>

<p>You added "${namePlanet}" to the database!!</p>
<p>You can now <a href="http://localhost:8080/universo_war_exploded/addPlanet">add another planet</a> or <a href="addSatellite.jsp">add a satellite</a>. </p>
<table>
    <tr>
        <th>Name</th>
        <th>Mass</th>
        <th>Habitable</th>
    </tr>
    <c:forEach var="planet" items="${planets}">
        <tr>
            <td>${planet.getName()}</td>
            <td>${planet.getMass()}</td>
            <td>${planet.getHabitable()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
