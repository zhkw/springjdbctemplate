package com.zkw;

import com.zkw.service.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.zkw")
public class CDPlayerConfig {
    @Bean
    public Teacher teacher(){
        return new Teacher();
    }

//    @Bean
//    public SgtPeppers sgtPeppers(){
//        return new SgtPeppers();
//    }

}

