package com.valensmarcos.controller;

import com.valensmarcos.dao.DAOPlanet;
import com.valensmarcos.dao.DAOSatellite;
import com.valensmarcos.model.Planet;
import com.valensmarcos.model.Satellite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PlanetDeleteController", urlPatterns = "/deletePlanet")
public class PlanetDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idPlanet = Long.parseLong(req.getParameter("planetId"));
        Planet planet = DAOPlanet.getInstance().get(idPlanet);
        List satellites = DAOSatellite.getInstance().getSatellitesOfPlanet(planet);
        satellites.forEach(satellite -> DAOSatellite.getInstance().delete((Satellite) satellite));
        DAOPlanet.getInstance().delete(planet);
        List<Planet> planets = DAOPlanet.getInstance().getAll();
        req.setAttribute("planets",planets);
        req.getRequestDispatcher("/planet.jsp").forward(req,resp);
    }
}
