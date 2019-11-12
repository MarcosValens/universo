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

@WebServlet(name = "insertPlanet", urlPatterns = "/")
public class InsertPlanetController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namePlanet = req.getParameter("namePlanet");
        float massPlanet = Float.parseFloat(req.getParameter("massPlanet")) ;
        int habitablePlanet = Integer.parseInt(req.getParameter("habitablePlanet"));
        Planet planet = new Planet(namePlanet,massPlanet,habitablePlanet);
        DAOPlanet daoPlanet = null;
        try {
            daoPlanet = new DAOPlanet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            assert daoPlanet != null;
            daoPlanet.save(planet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("namePlanet",namePlanet);
        req.setAttribute("planeta", planet);

        req.getRequestDispatcher("planetDone.jsp").forward(req,resp);
    }
}
