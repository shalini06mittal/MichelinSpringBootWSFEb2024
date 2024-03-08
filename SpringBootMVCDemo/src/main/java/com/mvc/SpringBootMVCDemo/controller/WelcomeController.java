package com.mvc.SpringBootMVCDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WelcomeController {

//    @GetMapping("/welcome")
//    public String welcomePage(@RequestParam String email, Map<String, String> map){
//        map.put("email", email);
//        return "welcome";
//    }
//    @GetMapping("/profile")
//    public String profilePage(@RequestParam String email, Map<String, String> map){
//        map.put("email", email);
//        return "profile";
//    }

    /**
     *
     * If using session management no need of passing email id everywhere
     * @return
     */
    @GetMapping("/welcome")
    public String welcomePage(){
        return "welcome";
    }
    @GetMapping("/profile")
    public String profilePage(){

        return "profile";
    }
}
