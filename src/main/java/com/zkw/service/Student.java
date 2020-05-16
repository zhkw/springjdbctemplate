package com.zkw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private Book book;


    public Student(Book book){
        this.book=book;
    }

    public void say(){
        book.say();
    }
}
