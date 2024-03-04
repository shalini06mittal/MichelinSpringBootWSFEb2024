package com.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Scanner;
// spring specific annotation
@Component("ob")
//@Scope("prototype")
public class StringMessageProvider implements  IMeesageProvider{

    @Value("Hey injected via spring value annpotation")
    private String message;

    public StringMessageProvider() {
        System.out.println("String message provider constructor");
    }

    public StringMessageProvider(@Value("Hey injected via spring value annpotation. constructor") String message) {
        this.message = message;
    }

    //@Value("Hey injected via spring value annpotation.. setter")
    public void setMessage(String message) {
        this.message = message;
    }

    public  String getMessage(){
        return message;
    }
}
