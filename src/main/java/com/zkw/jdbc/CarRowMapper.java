package com.zkw.jdbc;

import com.zkw.model.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException{
        Car car = new Car();
        car.setId(rs.getLong("ID"));
        car.setName(rs.getString("NAME"));
        car.setPrice(rs.getInt("PRICE"));
        return car;
    }
}
