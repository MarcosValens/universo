package com.valensmarcos.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(String[] name);

    List<T> getAll() throws SQLException;

    void save(T t) throws SQLException;

    default void update(T t, String[] params) throws Exception {
        throw new Exception();//POR SI QUIERES QUE SE NO SE TENGA QUE IMPLEMENTAR ESTE METODO
    }

    void delete(T t);
}
