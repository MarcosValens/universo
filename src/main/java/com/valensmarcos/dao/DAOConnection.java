package com.valensmarcos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnection {
    private static Connection conn = null;
    private DAOConnection(){
        String url = "jdbc:mysql://localhost:3306/univers";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "marcos";
        String password = "Root";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if (conn == null){
            new DAOConnection();
        }
        return conn;
    }
}
