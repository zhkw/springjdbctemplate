package com.zkw.dao;

import com.zkw.model.Car;

import java.util.List;

public interface CarDao {
    public Car getCarById(Long id);
    public List<Car> getAll();
}
