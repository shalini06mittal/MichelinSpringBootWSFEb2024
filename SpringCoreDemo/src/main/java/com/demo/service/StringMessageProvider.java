package com.demo.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;
// spring specific annotation
@Component//("ob")
public class StringMessageProvider implements  IMeesageProvider{

    private String message;

    public StringMessageProvider() {
        System.out.println("String message provider constructor");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public  String getMessage(){
        return message;
    }
}
