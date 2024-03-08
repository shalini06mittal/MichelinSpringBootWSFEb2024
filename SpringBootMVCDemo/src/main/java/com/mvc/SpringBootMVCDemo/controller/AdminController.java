package com.mvc.SpringBootMVCDemo.controller;

import com.mvc.SpringBootMVCDemo.entity.Employee;
import com.mvc.SpringBootMVCDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/admin")
    public String adminPage(Map<String , List<Employee>> map){

        List<Employee> employees = employeeService.getEmployees();
        map.put("employees", employees);
        return "employees";
    }
}
