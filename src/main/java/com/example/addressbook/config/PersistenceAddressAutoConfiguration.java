//package com.example.addressbook.config;
//
//import jakarta.persistence.EntityManagerFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.*;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactory",
//        basePackages 	 = {"com.example.addressbook.repositories.address"},
//        transactionManagerRef = "transactionManager"
//)
//
//public class PersistenceAddressAutoConfiguration {
//    @Autowired
//    Environment env;
//
//    @Primary
//    @Bean(name= "addressDataSource")
//    public DataSource dataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setUrl(env.getProperty("address.datasource.url"));
//        ds.setUsername(env.getProperty("address.datasource.username"));
//        ds.setPassword(env.getProperty("address.datasource.password"));
//        ds.setDriverClassName(env.getProperty("address.datasource.driver.class-name"));
//        return ds;
//    }
//
//    @Primary
//    @Bean(name= "addressEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManager() {
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//        bean.setDataSource(dataSource());
//        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        bean.setJpaVendorAdapter(adapter);
//        HashMap<String,Object> properties = new HashMap<String, Object>();
//        properties.put("hibernate.hbm2ddl.auto", "update");
//        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//        bean.setJpaPropertyMap(properties);
//        bean.setPackagesToScan("com.example.addressbook.models.address");
//        return bean;
//    }
//
//    @Primary
//    @Bean("addressTransactionManager")
//    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory ) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//
//}
