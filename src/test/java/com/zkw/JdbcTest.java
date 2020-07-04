package com.zkw;

import com.zkw.dao.CarDaoImpl;
import com.zkw.model.Car;
import com.zkw.service.CarService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

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

    @Test
    public void testContext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        String name = context.getMessage("customer.name",new Object[]{28,"http://www.mkong.com"}, Locale.US);
        System.out.println("english-->"+name);
        String namechinese = context.getMessage("customer.name",new Object[]{28,"http://www.mkong.com"}, Locale.SIMPLIFIED_CHINESE);
        System.out.println("english-->"+namechinese);
        String h = context.getMessage("hello",null,Locale.US);
        System.out.println(h);
        String hcn = context.getMessage("hello",null,Locale.SIMPLIFIED_CHINESE);
        System.out.println(hcn);

    }
}
