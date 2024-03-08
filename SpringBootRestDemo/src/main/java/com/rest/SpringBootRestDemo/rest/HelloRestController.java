package com.rest.SpringBootRestDemo.rest;
// postman

import org.springframework.web.bind.annotation.*;
/**
 *Representaional State Transfer
 * URI : noun
 * GET => fetch
 * POST => insert
 * PUT => updation
 * DELETE => deletion
 *
 * localhost:8080/weather
 *
 * verb : HTTP method
  */

@RestController // @Controller + @ResponseBody
@RequestMapping("/api")
public class HelloRestController {


    @GetMapping//("/get")
    public String send(){
        return " from GET";
    }
    @PostMapping//("/post")
    public String post(){
        return " from POST";
    }
    @PutMapping//("/put")
    public String put(){
        return " from PUT";
    }
    @RequestMapping//("/hello")
    public  String greet()
    {
        return "Message from REST API";
    }
    @DeleteMapping//("/delete")
    public String delete(){
        return " from DELETE";
    }

}
