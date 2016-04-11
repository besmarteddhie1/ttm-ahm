/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author achmad.ha
 */
public class DBConnectionMysqlImpl extends DBConnection {
    
	private String DB_DRIVER = "com.mysql.jdbc.Driver";
	private String DB_CONNECTION = "jdbc:mysql://localhost:3306/ttm_ahm";
	private String DB_USER = "ttm";  
	private String DB_PASSWORD = "nopassword";

    
    
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
