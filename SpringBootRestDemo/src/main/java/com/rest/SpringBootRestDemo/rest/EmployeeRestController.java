package com.rest.SpringBootRestDemo.rest;

import com.rest.SpringBootRestDemo.entity.Employee;
import com.rest.SpringBootRestDemo.service.EmployeeService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")///category/{category}")
    public ResponseEntity<Map<String,Object>>  getEmployeeById(@PathVariable int id){
                                                               //@PathVariable String category){
        //System.out.println(category);
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
    @PostMapping
    public ResponseEntity<Map<String, Object>> insertEmployee(@RequestBody Employee e)
    {
        System.out.println(e);
        Map<String , Object> map = new HashMap<>();
        try {
             Employee savedEmployee = employeeService.insertEmployee(e);
             map.put("SUCCESS", savedEmployee);
             return  ResponseEntity.status(HttpStatus.CREATED).body(map);
        }catch (EntityExistsException ex){
            map.put("error", ex.getMessage());
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
    }

    //localhost:8080/employees/filter?pageno=2&size=7
    //localhost:8080/employees/filter
    @GetMapping(path = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> filteredEmployees (
            @RequestParam(required = false, defaultValue = "0") Integer pageno,
            @RequestParam(required = false, defaultValue = "5") Integer size)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("page no "+pageno);
        Page<Employee> page = this.employeeService.getFilteredEmployees(pageno, size);
        map.put("current", page.getNumber());
        map.put("count",page.getNumberOfElements());
        map.put("total",page.getTotalElements());
        map.put("employees", page.getContent());
        map.put("pages", page.getTotalPages());
        return map;
    }

}
