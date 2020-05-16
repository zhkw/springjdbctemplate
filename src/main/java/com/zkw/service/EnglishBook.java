package com.zkw.service;

import org.springframework.stereotype.Component;

@Component
public class EnglishBook implements Book {
    @Override
    public void say() {
        System.out.println("This is english book");
    }
}
