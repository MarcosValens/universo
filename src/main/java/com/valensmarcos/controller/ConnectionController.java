package com.valensmarcos.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionController {
    private static Connection conn = null;
    private ConnectionController(){
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
            new ConnectionController();
        }
        return conn;
    }
}
