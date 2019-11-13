package com.valensmarcos.controller;

import com.valensmarcos.dao.DAOPlanet;
import com.valensmarcos.model.Planet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PlanetFormController", urlPatterns = "/addPlanet")
public class PlanetFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                DAOPlanet daoPlanet = new DAOPlanet();
                Planet planet = daoPlanet.get(id);
                req.setAttribute("planet", planet);
                req.getRequestDispatcher("planetForm.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect("planetForm.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namePlanet = req.getParameter("namePlanet");
        float massPlanet = Float.parseFloat(req.getParameter("massPlanet"));
        boolean habitablePlanet = Boolean.parseBoolean(req.getParameter("habitablePlanet"));
        List planets;
        Planet planet = new Planet();
        planet.setName(namePlanet);
        planet.setMass(massPlanet);
        planet.setHabitable(habitablePlanet);
        DAOPlanet daoPlanet = null;
        try {
            daoPlanet = new DAOPlanet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (req.getParameter("id") == null) {
            assert daoPlanet != null;
            daoPlanet.save(planet);
            planets = daoPlanet.getAll();
            req.setAttribute("planets", planets);
            req.getRequestDispatcher("/planet.jsp").forward(req, resp);
        } else {
            assert daoPlanet != null;
            daoPlanet.update(planet);
            planets = daoPlanet.getAll();
            req.setAttribute("planets", planets);
            req.getRequestDispatcher("/planet.jsp").forward(req, resp);
        }
    }
}
