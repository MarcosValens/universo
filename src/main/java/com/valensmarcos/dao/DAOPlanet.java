package com.valensmarcos.dao;

import com.valensmarcos.model.Planet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOPlanet implements DAO<Planet> {

    private static DAOPlanet daoPlanet;
    private Connection conn = DAOConnection.getConnection();
    private String sql;


    private DAOPlanet() {
    }


    public synchronized static DAOPlanet getInstance(){
        if (daoPlanet == null){
            daoPlanet = new DAOPlanet();
        }
        return daoPlanet;
    }

    @Override
    public Planet get(long id) {

        sql = "select * from planeta where idplaneta = ?";
        Planet planet = new Planet();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                planet.setId(id);
                planet.setName(rs.getString("nom"));
                planet.setMass(rs.getLong("massa"));
                planet.setHabitable(rs.getBoolean("habitable"));
            }
        } catch (SQLException e) {
            System.out.println("Error DAOPlanet.get:"+ e.getMessage());
        }
        return planet;
    }

    @Override
    public List<Planet> getAll() {
        List<Planet> planets = new ArrayList<>();
        sql = "select * from planeta";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planets;
    }

    @Override
    public void save(Planet planet) {
        String namePlanet = planet.getName();
        float massPlanet = planet.getMass();
        boolean habitablePlanet = planet.isHabitable();
        sql = "INSERT INTO planeta (nom,massa,habitable) VALUES (?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, namePlanet);
            preparedStatement.setFloat(2, massPlanet);
            preparedStatement.setBoolean(3, habitablePlanet);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Planet planet) {
        long idPlanet = planet.getId();
        String newNamePlanet = planet.getName();
        float newMassPlanet = planet.getMass();
        boolean newIsHabitable = planet.isHabitable();
        sql = "UPDATE planeta SET nom=?, massa=?, habitable=? WHERE idplaneta=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, newNamePlanet);
            preparedStatement.setFloat(2, newMassPlanet);
            preparedStatement.setBoolean(3, newIsHabitable);
            preparedStatement.setLong(4, idPlanet);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Planet planet) {
        long idPlanet = planet.getId();
        sql = "DELETE FROM planeta WHERE idplaneta=?";
        try  {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1,idPlanet);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
