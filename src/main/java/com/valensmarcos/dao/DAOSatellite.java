package com.valensmarcos.dao;

import com.valensmarcos.model.Satellite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOSatellite implements DAO<Satellite> {

    private Connection conn = DAOConnection.getConnection();
    private Statement stmt = conn.createStatement();
    private String sql;

    public DAOSatellite() throws SQLException {
    }

    @Override
    public Optional<Satellite> get(String[] name) {
        return Optional.empty();
    }

    @Override
    public List<Satellite> getAll() throws SQLException {
        List<Satellite> satellites = new ArrayList<Satellite>();
        sql = "select * from satelit";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            long idPlanet = rs.getInt("idplaneta");
            String nameSatellite = rs.getString("nom");
            long massSatellite = rs.getLong("massa");
            int speedSatellite = rs.getInt("velocitat");
            int satelliteOf = rs.getInt("planeta_idplaneta");
            /*
            * USAR DAOPlaneta para obtener el planeta e insertarlo en el satellite???
            *
            *
            *
            * */
            Satellite satellite = new Satellite();
            satellite.setId(idPlanet);
            satellite.setName(nameSatellite);
            satellite.setMassa(massSatellite);
            satellite.setSpeed(speedSatellite);
            satellites.add(satellite);
        }
        return satellites;
    }

    @Override
    public void save(Satellite satellite) throws SQLException {
        String nameSatellite = satellite.getName();
        long massPlanet = satellite.getMassa();
        int speedSatellite = satellite.getSpeed();
        sql = "insert into satelit(nom,massa,velocitat) value('"+nameSatellite+"',"+massPlanet+","+speedSatellite+")";
        stmt.executeUpdate(sql);
    }

    @Override
    public void update(Satellite satellite, String[] params) {

    }

    @Override
    public void delete(Satellite satellite) {

    }
}
