package com.ahm.jx.ttm.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ClassUtils;

import com.ahm.jx.Application;
import com.ahm.jx.ttm.utils.AuditorAwareImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
@EnableJpaRepositories(basePackageClasses = Application.class)
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
class JpaConfig {

    @Value("${dataSource.driverClassName}")
    private String driver;
    
    @Value("${dataSource.url}")
    private String url;
    
    @Value("${dataSource.username}")
    private String username;
    
    @Value("${dataSource.password}")
    private String password;
    
    @Value("${hibernate.dialect}")
    private String dialect;
    
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    
    @Value("${dataSource.poolsize}")
    private Integer poolSize;
    
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(poolSize);
        
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");

        return new HikariDataSource(config);
    }
    
    @Autowired
    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
    	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    	
        Properties jpaProperties = new Properties();
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
        jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
        jpaProperties.put(org.hibernate.cfg.Environment.FORMAT_SQL, "true");
        
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);

        String entities = ClassUtils.getPackageName(Application.class);
        String converters = ClassUtils.getPackageName(Jsr310JpaConverters.class);
        
        factory.setPackagesToScan(entities, converters);
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaProperties(jpaProperties);
        factory.afterPropertiesSet();
        
        return factory.getObject();
    }    

    @Autowired
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
    	JpaTransactionManager tx = new JpaTransactionManager();
    	tx.setEntityManagerFactory(factory);
        return tx;
    }
        
    //Required by Vanilla Code
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource ds) {	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(ds);	 
	    sessionBuilder.scanPackages("com.ahm.jx.app000");	 
	    return sessionBuilder.buildSessionFactory();
	}    
	
	//Required by Vanilla Code
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory factory) throws Exception {
		return new HibernateTransactionManager(factory);
	}	
    
    //Auditing module
    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }    
        
}
