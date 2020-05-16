package com.zkw;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.zkw.dao.CarDaoImpl;
import com.zkw.service.Student;
import com.zkw.service.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class AppTest 
{
    @Autowired
    private Teacher teacher;
    @Autowired
    private CompactDisc cd;
    @Autowired
    private ApplicationContext context;
    @Autowired
    private Student student;


    @Test
    public void testTeacher(){
        teacher.say();
    }

    @Test
    public void testStudent(){
        student.say();
    }

    @Test
    public void testCD(){
        System.out.println(context.getBean("myBean"));
    }
    @Test
    public void cdShouldNotBeNull(){
        cd.play();
    }

    @Test
    public void testJDBC(){

        CarDaoImpl carDaoImpl = (CarDaoImpl) context.getBean("carJDBCTemplate");
    }


}
