package com.valensmarcos.dao;

import com.valensmarcos.model.Satellite;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DAOSatellite implements DAO<Satellite> {
    @Override
    public Optional<Satellite> get(String[] name) {
        return Optional.empty();
    }

    @Override
    public List<Satellite> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Satellite satellite) throws SQLException {

    }

    @Override
    public void update(Satellite satellite, String[] params) {

    }

    @Override
    public void delete(Satellite satellite) {

    }
}
