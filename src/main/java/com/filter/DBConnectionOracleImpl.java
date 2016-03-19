/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

/**
 *
 * @author achmad.ha
 */
public class DBConnectionOracleImpl extends DBConnection {
    
    private String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private String DB_CONNECTION = "jdbc:oracle:thin:@t01557a09:1521:amazone";
//    private String DB_CONNECTION = "jdbc:mysql://localhost:3306/dims";
    private String DB_USER = "ahmps2005";
    private String DB_PASSWORD = "ahmps2005";
    
    
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            conn = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
