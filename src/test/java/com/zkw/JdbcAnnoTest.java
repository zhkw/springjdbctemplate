package com.zkw;

import com.zkw.dao.CarNewDao;
import com.zkw.jdbc.SpringJdbcConfig;
import com.zkw.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJdbcConfig.class)
public class JdbcAnnoTest {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private CarNewDao carNewDao;

    @Test
    public void testJdbc(){
        Car car = carNewDao.getCarById((long) 2);
        System.out.println(car);
    }

}
