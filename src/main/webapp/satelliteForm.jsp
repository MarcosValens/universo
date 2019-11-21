<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>satelliteForm</title>
</head>
<body>
<c:import url="template/helloUser.jsp"></c:import>
<c:import url="template/menu.html"></c:import>
<form action="addSatellite" method="post">
    <input type="hidden" name="idSatellite" value="${satellite.getId()}">
    <label for="nameSatellite">Name Satellite:</label>
    <br>
    <input type="text" name="nameSatellite" id="nameSatellite" value="${satellite.getName()}">
    <br>
    <label for="massSatellite">Mass:</label>
    <br>
    <input type="text" name="massSatellite" id="massSatellite" value="${satellite.getMassa()}">
    <br>
    <label for="speedSatellite">Speed:</label>
    <br>
    <input type="text" name="speedSatellite" id="speedSatellite" value="${satellite.getSpeed()}">
    <br>
    <label> Select Planet
        <select name="satelliteOf">
            <c:forEach var="planet" items="${planets}">
                <option value="${planet.getId()}"  <c:if test="${satellite.getPlanet().getName()==planet.getName()}">selected</c:if>   >${planet.getName()}</option>

            </c:forEach>
        </select>
    </label>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
