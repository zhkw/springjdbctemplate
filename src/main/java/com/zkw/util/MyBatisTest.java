package com.zkw.util;

import com.zkw.domain.User;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisTest {
    public static void main(String[] args) {
        MyBatisTest test = new MyBatisTest();
        test.getFile();

    }

    private void getFile(){
        InputStream stream = getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User("bbb",10,"M");
        session.insert("com.zkw.mapper.UserMapper.save",user);
        session.commit();
        session.close();

    }
}
