package com.zkw;

import org.apache.ibatis.io.Resources;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void test1(){
//        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("mybatis-config.xml");

    }
}
