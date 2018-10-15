package com.lym.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DBConfig {

    @Autowired
    private Environment env;
    
    @Bean
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(env.getProperty("spring.dataSource.url"));
        datasource.setUsername(env.getProperty("spring.dataSource.username"));
        datasource.setPassword(env.getProperty("spring.dataSource.password"));
        datasource.setDriverClassName(env.getProperty("spring.dataSource.driverClassName"));

        datasource.setInitialSize(Integer.valueOf(env.getProperty("spring.dataSource.initialSize")));
        datasource.setMinIdle(Integer.valueOf(env.getProperty("spring.dataSource.minIdle")));
        datasource.setMaxActive(Integer.valueOf(env.getProperty("spring.dataSource.maxActive")));
        datasource.setMaxWait(Integer.valueOf(env.getProperty("spring.dataSource.maxWait")));
        datasource.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getProperty("spring.dataSource.timeBetweenEvictionRunsMillis")));
        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(env.getProperty("spring.dataSource.minEvictableIdleTimeMillis")));
        datasource.setValidationQuery(env.getProperty("spring.dataSource.validationQuery"));
        datasource.setTestWhileIdle(Boolean.valueOf(env.getProperty("spring.dataSource.testWhileIdle")));
        datasource.setTestOnBorrow(Boolean.valueOf(env.getProperty("spring.dataSource.testOnBorrow")));
        datasource.setTestOnReturn(Boolean.valueOf(env.getProperty("spring.dataSource.testOnReturn")));
        datasource.setPoolPreparedStatements(Boolean.valueOf(env.getProperty("spring.dataSource.poolPreparedStatements")));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(env.getProperty("spring.dataSource.maxPoolPreparedStatementPerConnectionSize")));
        try {
            datasource.setFilters(env.getProperty("spring.dataSource.filters"));
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter: " + e);
        }
        datasource.setConnectionProperties(env.getProperty("spring.dataSource.connectionProperties"));
        return datasource;
    }
    
}
