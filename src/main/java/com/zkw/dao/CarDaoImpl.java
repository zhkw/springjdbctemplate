package com.zkw.dao;

import com.zkw.jdbc.CarRowMapper;
import com.zkw.model.Car;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CarDaoImpl implements CarDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Car getCarById(Long id){
        String sql = "select * from CARS where ID = ?";
        Car car = jdbcTemplate.queryForObject(sql,new Object[]{id},new CarRowMapper());
        return car;
    }

    @Override
    public List<Car> getAll() {
        String sql="select * from CARS";
        List<Car> carList=jdbcTemplate.query(sql,new CarRowMapper());
        return carList;
    }
}
