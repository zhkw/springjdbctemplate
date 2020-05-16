package com.zkw.jdbc;

import com.zkw.dao.CarDaoImpl;
import com.zkw.dao.CarNewDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.sql.DataSource;

@Configuration
public class SpringJdbcConfig {
    @Bean
    public DataSource mysqlDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(){
//        JdbcTemplate template = new JdbcTemplate();
//        template.setDataSource(mysqlDataSource());
//
//        return template;
//    }

    @Bean
    public CarNewDaoImpl carNewDaoImpl(){
        return new CarNewDaoImpl();
    }
}
