package com.demo.SpringBootDemo;

import com.demo.SpringBootDemo.service.NotificationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.data
@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =
		SpringApplication.run(SpringBootDemoApplication.class, args);
		NotificationService service = context.getBean(NotificationService.class);
		service.sendMessage();
	}

}
