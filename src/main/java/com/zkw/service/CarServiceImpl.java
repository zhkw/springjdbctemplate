package com.zkw.service;

import com.zkw.dao.CarDao;
import com.zkw.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public Car getCarById(Long id) {
        return carDao.getCarById(id);
    }
}
