package com.valensmarcos.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T get(long id);

    List<T> getAll();

    void save(T t);

    default void update(T t) /*throws Exception*/ {
        /*throw new Exception();//POR SI QUIERES QUE SE NO SE TENGA QUE IMPLEMENTAR ESTE METODO*/
    }

    void delete(T t);
}
