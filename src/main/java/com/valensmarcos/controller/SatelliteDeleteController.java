package com.valensmarcos.controller;


import com.valensmarcos.dao.DAOSatellite;
import com.valensmarcos.model.Satellite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name = "SatelliteDeleteController", urlPatterns = "/deleteSatellite")
public class SatelliteDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long idSatellite = Long.parseLong(req.getParameter("satelliteId"));
        Satellite satellite = DAOSatellite.getInstance().get(idSatellite);
        DAOSatellite.getInstance().delete(satellite);
        List satellites = DAOSatellite.getInstance().getAll();
        req.setAttribute("satellites", satellites);
        req.getRequestDispatcher("/satellite.jsp").forward(req, resp);
    }
}
