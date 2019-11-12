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

@WebServlet(name = "addPlanet", urlPatterns = "/addPlanet")
public class InsertPlanetController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOPlanet daoPlanet = null;
        try {
            daoPlanet = new DAOPlanet();
        } catch (SQLException e){
            e.printStackTrace();
        }
        List planets = new ArrayList<>();
        try {
            assert daoPlanet != null;
            planets = daoPlanet.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("planets",planets);
        req.getRequestDispatcher("/").forward(req,resp);
    }

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
        List planets = new ArrayList<>();
        try {
            planets = daoPlanet.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("planets",planets);
        req.setAttribute("namePlanet",namePlanet);
        req.setAttribute("planeta", planet);

        req.getRequestDispatcher("/planetDone.jsp").forward(req,resp);
    }
}
