package com.example.addressbook.config;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "secondaryEntityManagerFactory",
		basePackages 	 = {"com.example.addressbook.secondaryRepo"},
		transactionManagerRef = "secondaryTransactionManager"
		)

public class SecondaryConfig {

	@Autowired
	Environment env;

	@Bean(name= "secondaryDataSource")
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(env.getProperty("secondary.datasource.url"));
		ds.setUsername(env.getProperty("secondary.datasource.username"));
		ds.setPassword(env.getProperty("secondary.datasource.password"));
		ds.setDriverClassName(env.getProperty("secondary.datasource.driver.class-name"));
		return ds;
	}

	@Bean(name= "secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManager() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);
		HashMap<String,Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		bean.setJpaPropertyMap(properties);
		bean.setPackagesToScan("com.example.addressbook.secondaryEntity");
		return bean;
	}

	@Bean("secondaryTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory entityManagerFactory ) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}

