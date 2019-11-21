package com.valensmarcos.dao;

import com.valensmarcos.model.User;

import java.sql.Connection;
import java.util.List;

public class DAOUser implements DAO<User> {
    private static DAOUser daoUser;
    private Connection conn = DAOConnection.getConnection();
    private String sql;

    private DAOUser(){

    }

    public synchronized DAOUser getInstance(){
        if (daoUser == null){
            daoUser = new DAOUser();
        }
        return daoUser;
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
