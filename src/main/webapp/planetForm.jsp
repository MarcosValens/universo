<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
</body>
</html>