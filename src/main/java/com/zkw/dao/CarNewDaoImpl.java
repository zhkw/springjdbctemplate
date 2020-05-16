package com.zkw.dao;

import com.zkw.jdbc.CarRowMapper;
import com.zkw.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CarNewDaoImpl implements CarNewDao {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Car getCarById(Long id){
        String sql = "select * from CARS where ID = ?";
        Car car = jdbcTemplate.queryForObject(sql,new Object[]{id},new CarRowMapper());
        return car;
    }
}
