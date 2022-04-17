/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drivermonitor.database.tomalsir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class DbConnection {

    private static Connection connection = null;
    private static DbConnection instance = new DbConnection();
    
    private DbConnection() {
        try {
            String username = System.getProperty("root");
             username = "root";
            String password = System.getProperty("51525152");
             password = "51525152";
            System.out.printf("Username:password as environment variable: [%s]:[%s]\n", username, password);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogapi", username, password);
            System.out.println("Connection created");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        DbConnection.getConnection();
    }
}













