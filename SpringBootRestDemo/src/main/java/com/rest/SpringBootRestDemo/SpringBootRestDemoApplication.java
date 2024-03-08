package com.rest.SpringBootRestDemo;

import com.rest.SpringBootRestDemo.entity.Employee;
import com.rest.SpringBootRestDemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class
SpringBootRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestDemoApplication.class, args);
	}
	@Autowired
	private EmployeeService employeeService;

	@PostConstruct
	public void initialize()
	{
		Employee emp = new Employee();
		emp.setEname("Sia");
		emp.setEmail("sia@test.com");
		emp.setPassword("sia123");
		emp.setPhone("9898989898");

		Employee e = employeeService.insertEmployee(emp);

		Employee em = new Employee();
		em.setEname("John");
		em.setEmail("john@test.com");
		em.setPassword("john1235");
		em.setPhone("7654323456");

		 employeeService.insertEmployee(em);

	}
}
