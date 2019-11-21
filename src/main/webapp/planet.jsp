<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="template/helloUser.jsp"></c:import>
<c:import url="template/menu.html"></c:import>
<form action="deletePlanet" method="post">
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Mass</th>
            <th>Habitable</th>
            <th>Operations</th>
        </tr>
        <c:forEach var="planet" items="${planets}">
            <tr>
                <td>${planet.getId()}</td>
                <td>${planet.getName()}</td>
                <td>${planet.getMass()}</td>
                <td>${(planet.isHabitable())?"Si":"No"}</td>
                <td><a href="addPlanet?id=${planet.getId()}">Edit</a></td>
                <td>
                    <button type="submit">Delete</button>
                    <input type="hidden" name="planetId" value="${planet.getId()}">
                </td>
            </tr>
        </c:forEach>
        <%--<tr>
            <td><input type="submit" name="delete" value="DELETE ALL SELECTED"></td>
        </tr>--%>
    </table>
</form>
</body>
</html>
