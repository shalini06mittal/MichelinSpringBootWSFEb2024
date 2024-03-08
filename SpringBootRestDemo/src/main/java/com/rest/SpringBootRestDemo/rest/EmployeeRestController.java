package com.rest.SpringBootRestDemo.rest;

import com.rest.SpringBootRestDemo.entity.Employee;
import com.rest.SpringBootRestDemo.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Employee> getAllEmployees()
    {
        return employeeService.getEmployees();
    }
    // localhost:8080/employees/110 =>
//    @GetMapping("/{id}")
//    public Employee getEmployeeById(@PathVariable int id){
//        return  employeeService.getEmployeeById(id);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Object>  getEmployeeById(@PathVariable int id){
//        try {
//            Employee employee = employeeService.getEmployeeById(id);
//            return  ResponseEntity.ok(employee);
//        }catch (EntityNotFoundException e){
//          return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>>  getEmployeeById(@PathVariable int id){
        Map<String , Object> map = new HashMap<>();
        try {
            Employee employee = employeeService.getEmployeeById(id);
            map.put("employee", employee);
            return  ResponseEntity.ok(map);
        }catch (EntityNotFoundException e){
            map.put("error", e.getMessage());
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
    }
}
