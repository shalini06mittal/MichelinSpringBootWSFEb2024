package com.demo.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class EagerService {

    public EagerService() {
        System.out.println("Eager service intsantiated");
    }


}
