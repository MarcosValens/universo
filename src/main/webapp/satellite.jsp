<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="template/helloUser.jsp"></c:import>
<c:import url="template/menu.html"></c:import>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Mass</th>
            <th>Speed</th>
            <th>Planet</th>
            <th>Operations</th>
        </tr>
        <c:forEach var="satellite" items="${satellites}">
            <tr>
                <td>${satellite.getId()}</td>
                <td>${satellite.getName()}</td>
                <td>${satellite.getMassa()}</td>
                <td>${satellite.getSpeed()}</td>
                <td>${satellite.getPlanet().getName()}</td>
                <td><a href="addSatellite?idSatellite=${satellite.getId()}">Edit</a></td>
                <td>
                    <button type="submit">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
