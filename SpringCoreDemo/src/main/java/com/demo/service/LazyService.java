package com.demo.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyService {
    public LazyService() {
        System.out.println("Lazy service intsantiated");
    }

}
