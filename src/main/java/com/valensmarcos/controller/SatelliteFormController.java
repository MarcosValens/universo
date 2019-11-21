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

@WebServlet(name = "SatelliteFormController", urlPatterns = "/addSatellite")
public class SatelliteFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*DAOPlanet daoPlanet = new DAOPlanet();*/
        List<Planet> planets;
        if (req.getParameter("idSatellite") != null) {
            long idSatellite = Long.parseLong(req.getParameter("idSatellite"));
            /*DAOSatellite daoSatellite = new DAOSatellite();*/
            Satellite satellite = DAOSatellite.getInstance().get(idSatellite);
            System.out.println(satellite.toString());
            planets = DAOPlanet.getInstance().getAll();
            req.setAttribute("satellite", satellite);
            req.setAttribute("planets", planets);
            req.getRequestDispatcher("satelliteForm.jsp").forward(req, resp);
        } else {
            /*daoPlanet = new DAOPlanet();*/
            planets = DAOPlanet.getInstance().getAll();
            req.setAttribute("planets", planets);
            req.getRequestDispatcher("satelliteForm.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Satellite satellite = new Satellite();
        /*DAOSatellite daoSatellite = null;*/
        /*DAOPlanet daoPlanet = new DAOPlanet();*/
        Planet planet = DAOPlanet.getInstance().get(Long.parseLong(req.getParameter("satelliteOf")));
        String nameSatellite = req.getParameter("nameSatellite");
        long massSatellite = Long.parseLong(req.getParameter("massSatellite"));
        int speedSatellite = Integer.parseInt(req.getParameter("speedSatellite"));
        satellite.setName(nameSatellite);
        satellite.setMassa(massSatellite);
        satellite.setSpeed(speedSatellite);
        satellite.setPlanet(planet);
        /*daoSatellite = new DAOSatellite();*/
        /*assert daoSatellite != null;*/
        List satellites;

        if (req.getParameter("idSatellite").equals("")) {
            DAOSatellite.getInstance().save(satellite);
            satellites = DAOSatellite.getInstance().getAll();
            req.setAttribute("satellites", satellites);
            req.getRequestDispatcher("/satellite.jsp").forward(req, resp);
        } else {
            satellite.setId(Long.parseLong(req.getParameter("idSatellite")));
            assert false;
            DAOSatellite.getInstance().update(satellite);
            satellites = DAOSatellite.getInstance().getAll();
            req.setAttribute("satellites", satellites);
            req.getRequestDispatcher("/satellite.jsp").forward(req, resp);
        }
    }
}