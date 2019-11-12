<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>satelliteForm</title>
</head>
<body>
<form action="addSatellite" method="post">
    <label for="nameSatellite">Name Satellite:</label>
    <br>
    <input type="text" name="nameSatellite" id="nameSatellite">
    <br>
    <label for="massSatellite">Mass:</label>
    <br>
    <input type="text" name="massSatellite" id="massSatellite">
    <br>
    <label for="speedSatellite">Speed:</label>
    <br>
    <input type="text" name="speedSatellite" id="speedSatellite">
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
