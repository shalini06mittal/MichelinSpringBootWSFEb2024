package com.mvc.SpringBootMVCDemo;

import com.mvc.SpringBootMVCDemo.entity.Employee;
import com.mvc.SpringBootMVCDemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//jdbc:h2:mem:883a12eb-d659-4657-ab93-b3a8d10d955d
@SpringBootApplication
public class SpringBootMvcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcDemoApplication.class, args);
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

		employeeService.insertEmployee(emp);

		Employee em = new Employee();
		em.setEname("John");
		em.setEmail("john@test.com");
		em.setPassword("john1235");
		em.setPhone("7654323456");

		employeeService.insertEmployee(em);

	}


}
