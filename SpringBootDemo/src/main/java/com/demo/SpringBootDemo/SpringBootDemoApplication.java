package com.demo.SpringBootDemo;

import com.demo.SpringBootDemo.entity.Address;
import com.demo.SpringBootDemo.entity.Employee;
import com.demo.SpringBootDemo.service.EmployeeService;
import com.demo.SpringBootDemo.service.NotificationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.data
@SpringBootApplication
@EnableTransactionManagement
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =
		SpringApplication.run(SpringBootDemoApplication.class, args);
//		NotificationService service = context.getBean(NotificationService.class);
//		service.sendMessage();

		EmployeeService employeeService = context.getBean(EmployeeService.class);
		/**
		 * Employee Serivce - Insert Employee
		 */

//		Employee e1 = new Employee();
//		e1.setEid(1);
//		e1.setEname("abcabc");
//		e1.setEmail("abc@gmail.com");
//		e1.setPassword("abc123");
//		e1.setPhone("1212121212");

//		Employee employee = employeeService.insertEmployee(e1);
//		System.out.println(employee);

//		Address addr = new Address();
//		addr.setCity("Delhi");
//		addr.setCountry("India");
//		addr.setZipcode("989898");
//
//		employeeService.insertAddress(addr, 1);

		/**
		 * Employee Serivce - Transaction Example
		 */

//		Employee e1 = new Employee();
//		e1.setEname("manish");
//		e1.setEmail("manish@gmail.com");
//		e1.setPassword("manish123");
//		e1.setPhone("67676767676");

//		Address addr = new Address();
//		addr.setCity("Mumbai");
//		addr.setCountry("India");
//		addr.setZipcode("989898");
//		e1.setAddress(addr);
//
//		employeeService.insertEmployeeAndAddress(e1);

		System.out.println(employeeService.findEmployeeByEmail("shalini@gmail.com"));
	}

}
