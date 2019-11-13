<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="addPlanet">New Planet</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Mass</th>
            <th>Habitable</th>
        </tr>
        <c:forEach var="planet" items="${planets}">
            <tr>
                <td>${planet.getId()}</td>
                <td>${planet.getName()}</td>
                <td>${planet.getMass()}</td>
                <td>${(planet.isHabitable())?"Si":"No"}</td>
                <td><a href="addPlanet?id=${planet.getId()}">Edit</a></td>
            </tr>
        </c:forEach>
        <%--<tr>
            <td><input type="submit" name="delete" value="DELETE ALL SELECTED"></td>
        </tr>--%>
    </table>
</body>
</html>