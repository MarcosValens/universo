package com.valensmarcos.controller;

import com.valensmarcos.dao.DAOConnection;
import com.valensmarcos.dao.DAOPlanet;
import com.valensmarcos.model.Planet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PlanetFormController", urlPatterns = "/addPlanet")
public class PlanetFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            DAOPlanet daoPlanet = new DAOPlanet();
            Planet planet = daoPlanet.get(id);
            req.setAttribute("planet", planet);
            req.getRequestDispatcher("planetForm.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("planetForm.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namePlanet = req.getParameter("namePlanet");
        float massPlanet = Float.parseFloat(req.getParameter("massPlanet"));
        boolean habitablePlanet = false;
        if (req.getParameter("habitablePlanet") != null){
            habitablePlanet = true;
        }
        /*habitablePlanet = Boolean.parseBoolean(req.getParameter("habitablePlanet"));*/
        List planets;
        Planet planet = new Planet();
        planet.setName(namePlanet);
        planet.setMass(massPlanet);
        planet.setHabitable(habitablePlanet);
        DAOPlanet daoPlanet;
        daoPlanet = new DAOPlanet();
        if (req.getParameter("idPlanet").equals("")) {
            daoPlanet.save(planet);
            planets = daoPlanet.getAll();
            req.setAttribute("planets", planets);
            req.getRequestDispatcher("/planet.jsp").forward(req, resp);
        } else {
            planet.setId(Long.parseLong(req.getParameter("idPlanet")));
            daoPlanet.update(planet);
            planets = daoPlanet.getAll();
            req.setAttribute("planets", planets);
            req.getRequestDispatcher("/planet.jsp").forward(req, resp);
        }
    }
}
