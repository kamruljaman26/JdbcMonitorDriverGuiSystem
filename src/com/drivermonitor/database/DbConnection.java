/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drivermonitor.database;

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
    private static final String DB_USERNAME = "root";
    private static final String DB_PASS = "51525152";

    private DbConnection() {
        try {
            System.out.printf("Username:password as environment variable: [%s]:[%s]\n", DB_USERNAME, DB_PASS);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogapi", DB_USERNAME, DB_PASS);
            System.out.println("Connection created");
        } catch (SQLException ex) {
            System.out.println("ecxsdfg");
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }

//    public static void main(String[] args) {
//        DbConnection.getConnection();
//    }
}













