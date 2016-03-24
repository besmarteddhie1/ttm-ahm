package com.ahm.jx.ttm.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence.properties" })
@ComponentScan({"com.ahm.jx.ttm"})
public class PersistenceConfig {
     	
	@Autowired
	DataSource ds;	
	  
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(ds);	 
	    sessionBuilder.scanPackages("com.ahm.jx.ttm");	 
	    return sessionBuilder.buildSessionFactory();
	}
	 
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager() throws Exception {
		return new HibernateTransactionManager(getSessionFactory());
	}
		
}
