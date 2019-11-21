package com.valensmarcos.dao;

import com.valensmarcos.model.Planet;
import com.valensmarcos.model.Satellite;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOSatellite implements DAO<Satellite> {

    private Connection conn = DAOConnection.getConnection();
    private String sql;

    public DAOSatellite() throws SQLException {
    }

    @Override
    public Satellite get(long id) {
        DAOPlanet daoPlanet = new DAOPlanet();
        sql = "select * from satelit where idsatelit = ?";
        Satellite satellite = new Satellite();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                satellite.setId(id);
                satellite.setName(rs.getString("nom"));
                satellite.setMassa(rs.getLong("massa"));
                satellite.setSpeed(rs.getInt("velocitat"));
                satellite.setPlanet(daoPlanet.get(rs.getLong("planeta_idplaneta")));
            }
        } catch (SQLException e) {
            System.out.println("Error DAOPlanet.get:" + e.getMessage());
        }
        return satellite;
    }

    @Override
    public List<Satellite> getAll() {
        ArrayList satellites = new ArrayList();
        sql = "select * from satelit";
        PreparedStatement preparedStatement;
        ResultSet rs;
        try {
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idSatellite = rs.getInt("idsatelit");
                String nameSatellite = rs.getString("nom");
                long massSatellite = rs.getLong("massa");
                int speedSatellite = rs.getInt("velocitat");
                int satelliteOf = rs.getInt("planeta_idplaneta");
                DAOPlanet daoPlanet = new DAOPlanet();
                Planet planet = daoPlanet.get(satelliteOf);
                Satellite satellite = new Satellite();
                satellite.setId(idSatellite);
                satellite.setName(nameSatellite);
                satellite.setMassa(massSatellite);
                satellite.setSpeed(speedSatellite);
                satellite.setPlanet(planet);
                satellites.add(satellite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return satellites;
    }

    @Override
    public void save(Satellite satellite) {
        PreparedStatement preparedStatement;
        String nameSatellite = satellite.getName();
        long massSatellite = satellite.getMassa();
        int speedSatellite = satellite.getSpeed();
        Long idPlanetOf = satellite.getPlanet().getId();
        sql = "insert into satelit (nom, massa, velocitat, planeta_idplaneta) VALUES (?,?,?,?);";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nameSatellite);
            preparedStatement.setLong(2, massSatellite);
            preparedStatement.setInt(3, speedSatellite);
            preparedStatement.setLong(4, idPlanetOf);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Satellite satellite) {

        long idSatellite = satellite.getId();
        String newNameSatellite = satellite.getName();
        float newMassSatellite = satellite.getMassa();
        int newSpeedSatellite = satellite.getSpeed();
        long newPlanetSatellite = satellite.getPlanet().getId();
        sql = "UPDATE satelit SET nom=?, massa=?, velocitat=?, planeta_idplaneta=? WHERE idsatelit=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, newNameSatellite);
            preparedStatement.setFloat(2, newMassSatellite);
            preparedStatement.setInt(3, newSpeedSatellite);
            preparedStatement.setLong(4, newPlanetSatellite);
            preparedStatement.setLong(5, idSatellite);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Satellite satellite) {

    }
}
