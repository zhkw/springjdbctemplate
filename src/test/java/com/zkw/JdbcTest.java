package com.zkw;

import com.zkw.dao.CarDaoImpl;
import com.zkw.model.Car;
import com.zkw.service.CarService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {

    @Test
    public void testJdbc(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CarDaoImpl carDaoImpl = (CarDaoImpl) context.getBean("carJDBCTemplate");

        System.out.println(carDaoImpl.getCarById((long) 1));
    }

    @Test
    public void testService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CarService carService = (CarService) context.getBean("carServiceImpl");
        System.out.println(carService.getCarById((long) 1));
    }
}
