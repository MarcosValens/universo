package com.valensmarcos.controller;

import com.valensmarcos.dao.DAOPlanet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PlanetController", urlPatterns = "/planet")
public class PlanetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List planets;
        planets = DAOPlanet.getInstance().getAll();
        req.setAttribute("planets", planets);
        req.getRequestDispatcher("planet.jsp").forward(req, resp);
    }
}
