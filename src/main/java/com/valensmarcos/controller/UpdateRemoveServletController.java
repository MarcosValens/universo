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

@WebServlet(name = "deletePlanet",urlPatterns = "/updateRemoveServletController")
public class UpdateRemoveServletController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("delete") != null){
           String[] selectedPlanets = req.getParameterValues("selectedPlanets");
            try {
                DAOPlanet daoPlanet = new DAOPlanet();
                daoPlanet.get(selectedPlanets);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
