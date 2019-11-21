package com.valensmarcos.dao;

import com.valensmarcos.model.Planet;
import com.valensmarcos.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUser implements DAO<User> {
    private static DAOUser daoUser;
    private Connection conn = DAOConnection.getConnection();
    private String sql;

    private DAOUser() {

    }

    public synchronized static DAOUser getInstance() {
        if (daoUser == null) {
            daoUser = new DAOUser();
        }
        return daoUser;
    }

    @Override
    public User get(long id) {
        sql = "select * from usuari where idusuari = ?";
        User user = new User();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user.setId(id);
                user.setName(rs.getString("nom"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error DAOPlanet.get:" + e.getMessage());
        }
        return user;
    }

    public User authenticated(String name, String password){
        sql = "SELECT * FROM usuari WHERE nom=? AND password=?";
        User user = new User();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt("idusuari"));
                user.setName(rs.getString("nom"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getByName(String name){
        sql = "SELECT * FROM usuari WHERE nom=?";
        User user = new User();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt("idusuari"));
                user.setName(rs.getString("nom"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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
