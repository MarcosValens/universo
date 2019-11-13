package com.valensmarcos.dao;

import com.valensmarcos.model.Satellite;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOSatellite implements DAO<Satellite> {

    private Connection conn = DAOConnection.getConnection();
    private Statement stmt = conn.createStatement();
    private String sql;

    public DAOSatellite() throws SQLException {
    }

    @Override
    public Satellite get(long id) {
        return null;
    }

    @Override
    public List<Satellite> getAll() {
        List<Satellite> satellites = new ArrayList<Satellite>();
        sql = "select * from satelit";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return satellites;
    }

    @Override
    public void save(Satellite satellite)  {
        String nameSatellite = satellite.getName();
        long massPlanet = satellite.getMassa();
        int speedSatellite = satellite.getSpeed();
        sql = "insert into satelit(nom,massa,velocitat) value('"+nameSatellite+"',"+massPlanet+","+speedSatellite+")";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Satellite satellite) {

    }

    @Override
    public void delete(Satellite satellite) {

    }
}
