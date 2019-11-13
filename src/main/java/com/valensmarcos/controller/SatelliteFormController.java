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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SatelliteFormController", urlPatterns = "/addSatellite")
public class SatelliteFormController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameSatellite = req.getParameter("nameSatellite");
        long massSatellite = Long.parseLong(req.getParameter("massSatellite")) ;
        int speedSatellite = Integer.parseInt(req.getParameter("speedSatellite"));
        Satellite satellite = new Satellite();
        satellite.setName(nameSatellite);
        satellite.setMassa(massSatellite);
        satellite.setSpeed(speedSatellite);
        DAOSatellite daoSatellite = null;
        try {
            daoSatellite = new DAOSatellite();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert daoSatellite != null;
        daoSatellite.save(satellite);
        List satellites;
        satellites = daoSatellite.getAll();
        req.setAttribute("satellites",satellites);
        if (req.getRequestURL().toString().equals("/satellite")){
            req.getRequestDispatcher("satellite.jsp").forward(req,resp);}
        else req.getRequestDispatcher("satelliteForm.jsp").forward(req,resp);
    }
}