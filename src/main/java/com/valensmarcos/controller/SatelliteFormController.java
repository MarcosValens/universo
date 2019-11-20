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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SatelliteFormController", urlPatterns = "/addSatellite")
public class SatelliteFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOPlanet daoPlanet = new DAOPlanet();
        List<Planet> planets;
        if (req.getParameter("idSatellite") != null) {
            try {
                long idSatellite = Long.parseLong(req.getParameter("idSatellite"));
                DAOSatellite daoSatellite = new DAOSatellite();
                Satellite satellite = daoSatellite.get(idSatellite);
                System.out.println(satellite.toString());
                planets = daoPlanet.getAll();
                req.setAttribute("satellite", satellite);
                req.setAttribute("planets", planets);
                req.getRequestDispatcher("satelliteForm.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            daoPlanet = new DAOPlanet();
            planets = daoPlanet.getAll();
            req.setAttribute("planets", planets);
            req.getRequestDispatcher("satelliteForm.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Satellite satellite = new Satellite();
        DAOSatellite daoSatellite = null;
        DAOPlanet daoPlanet = new DAOPlanet();
        Planet planet = daoPlanet.get(Long.parseLong(req.getParameter("satelliteOf")));
        String nameSatellite = req.getParameter("nameSatellite");
        long massSatellite = Long.parseLong(req.getParameter("massSatellite"));
        int speedSatellite = Integer.parseInt(req.getParameter("speedSatellite"));
        satellite.setName(nameSatellite);
        satellite.setMassa(massSatellite);
        satellite.setSpeed(speedSatellite);
        satellite.setPlanet(planet);
        try {
            daoSatellite = new DAOSatellite();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert daoSatellite != null;
        List satellites = daoSatellite.getAll();;

        if (req.getParameter("idSatellite").equals("")) {
            daoSatellite.save(satellite);
            satellites = daoSatellite.getAll();
            req.setAttribute("satellites", satellites);
            req.getRequestDispatcher("/satellite.jsp").forward(req, resp);
        } else {
            satellite.setId(Long.parseLong(req.getParameter("idSatellite")));
            assert false;
            daoSatellite.update(satellite);
            req.setAttribute("satellites", satellites);
            req.getRequestDispatcher("/satellite.jsp").forward(req, resp);
        }
    }
}