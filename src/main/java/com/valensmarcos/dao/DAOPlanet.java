package com.valensmarcos.dao;

import com.valensmarcos.model.Planet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOPlanet implements DAO<Planet> {
    private DAOConnection conn = DAOConnection.getConnection();
    private Statement stmt = conn.createStatement();
    private String sql;


    public DAOPlanet() throws SQLException {
    }

    @Override
    public Optional get(String[] name) {
        sql = "select * from planeta where nom in ('";
        for (String s : name) {

        }
        System.out.println(sql);

        return Optional.empty();
    }

    @Override
    public List getAll() throws SQLException {
        sql = "select * from planeta";
        List<Planet> planets = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            long idPlanet = rs.getInt("idplaneta");
            String namePlanet = rs.getString("nom");
            float massPlanet = rs.getFloat("massa");
            boolean habitablePlanet = rs.getBoolean("habitable");
            Planet planet = new Planet();
            planet.setId(idPlanet);
            planet.setName(namePlanet);
            planet.setMass(massPlanet);
            planet.setHabitable(habitablePlanet);
            planets.add(planet);
        }

        return planets;
    }

    @Override
    public void save(Planet planet) throws SQLException {
        String namePlanet = planet.getName();
        float massPlanet = planet.getMass();
        boolean habitablePlanet = planet.isHabitable();
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
