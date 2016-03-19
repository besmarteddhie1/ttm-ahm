/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.config;

import com.ahm.jx.secure.CryptUtil;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author achmad.ha
 */
@Configuration
@PropertySource("classpath:database.properties")
public class AppConfig {
    
    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    
    @Value("${jdbc.driver}")
    private String driver;
    
    @Bean
    public DataSource dataSource() {
        System.out.println("password : "+password);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        try {
//            Key key = CryptUtil.generateDefaultKey();
//            String realPass = CryptUtil.decryptFromBase64(key, password).trim();
              String realPass = password;
            System.out.println("realPass : "+realPass.trim());
            dataSource.setPassword(realPass);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataSource;
    }
    
}
