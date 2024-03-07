package com.mvc.SpringBootMVCDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetController {

    GreetController(){
        System.out.println("greet controller constructor");
    }
    @RequestMapping("/welcome")
    public @ResponseBody String welcomeMessage(){
        return "<h1>Welcome!!</h1>";
    }

//    @RequestMapping(value = "/greet", method = RequestMethod.GET)
//    public String greetMessage(){
//        return "greeting";
//    }
    @GetMapping("/greet")
    public String greetMessage(){
        return "greeting";
    }
}
