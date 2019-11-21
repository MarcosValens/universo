package com.valensmarcos.controller;

import com.valensmarcos.dao.DAOSatellite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SatelliteController",urlPatterns = "/satellite")
public class SatelliteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List satellites;
        /*DAOSatellite daoSatellite = new DAOSatellite();*/
        satellites = DAOSatellite.getInstance().getAll();
        req.setAttribute("satellites",satellites);
        req.getRequestDispatcher("satellite.jsp").forward(req,resp);
    }
}
