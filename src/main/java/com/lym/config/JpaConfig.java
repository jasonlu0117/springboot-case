package com.lym.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactory",
        transactionManagerRef="transactionManager",
        basePackages= {"com.lym.dao"})
@EnableSpringDataWebSupport
public class JpaConfig {
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private Environment env;
    
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(vendorAdapter);
        // 配置实体类所在位置
        factory.setPackagesToScan("com.lym.entity");
        factory.setJpaProperties(jpaProperties());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory());
        return manager;
    }
    
    private Properties jpaProperties() {
        Properties properties = new Properties();
        // 显示sql语句
        properties.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.show-sql"));
        // 格式化sql语句
        properties.put("hibernate.format_sql", env.getRequiredProperty("spring.jpa.format_sql"));
        // 方言
        properties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
        // 自动生成表
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("spring.jpa.properties.hibernate.hbm2ddl.auto"));
        // 名字策略
        properties.put("hibernate.ejb.naming_strategy", env.getRequiredProperty("spring.jpa.hibernate.naming-strategy"));
        return properties;
    }
    
}
