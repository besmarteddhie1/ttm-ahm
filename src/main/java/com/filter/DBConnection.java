/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filter;

import java.sql.Connection;
import javax.naming.Context;

/**
 *
 * @author achmad.ha
 */
public abstract class DBConnection {
        
    public abstract Connection getConnection();
    
}
