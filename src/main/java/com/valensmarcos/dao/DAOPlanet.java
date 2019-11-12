package com.valensmarcos.dao;

import com.valensmarcos.controller.ConnectionController;
import com.valensmarcos.model.Planet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOPlanet implements DAO<Planet> {
    private Connection conn = ConnectionController.getConnection();
    private Statement stmt = conn.createStatement();
    private String sql;

    public DAOPlanet() throws SQLException {
    }

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() throws SQLException {
        sql = "select * from planeta";
        List<Planet> planets = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String namePlanet = rs.getString("nom");
            float massaPlanet = rs.getFloat("massa");
            int habitablePlanet = rs.getInt("habitable");
            Planet planet = new Planet(namePlanet,massaPlanet,habitablePlanet);
            planets.add(planet);
        }
        return planets;
    }

    @Override
    public void save(Planet planet) throws SQLException {
        String namePlanet = planet.getName();
        float massPlanet = planet.getMass();
        int habitablePlanet = planet.getHabitable();
        sql = "insert into planeta(nom,massa,habitable) value('"+namePlanet+"',"+massPlanet+","+habitablePlanet+")";
        stmt.executeUpdate(sql);
    }

    @Override
    public void update(Planet planet, String[] params) {

    }

    @Override
    public void delete(Planet planet) {

    }
}
