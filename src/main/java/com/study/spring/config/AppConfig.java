package com.study.spring.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.study.spring")
@PropertySource("classpath:mysql.properties")
public class AppConfig {
	
	@Autowired
	private Environment environment;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;	
	}
	
	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			logger.info("JDBC drive = " + getProperty("jdbc.driver"));
			logger.info("JDBC url = "+getProperty("jdbc.url"));
			logger.info("JDBC user = "+ getProperty("jdbc.user"));
			logger.info("JDBC password = "+getProperty("jdbc.user"));
			dataSource.setDriverClass(getProperty("jdbc.driver"));
			dataSource.setJdbcUrl(getProperty("jdbc.url"));
			dataSource.setUser(getProperty("jdbc.user"));
			dataSource.setPassword(getProperty("jdbc.password"));
			
			//Config for pool size
			dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
			dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
			dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
			dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
					
		} catch(Exception exception) {
			throw new RuntimeException(exception);
		}
		return dataSource;
	}
	
	private String getProperty(String property) {
		return environment.getProperty(property);
	}
	
	private Integer getIntProperty(String property) {
		return Integer.parseInt(environment.getProperty(property));
	}
}
