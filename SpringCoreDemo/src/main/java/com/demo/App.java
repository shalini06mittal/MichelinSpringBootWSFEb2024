package com.demo;

import com.demo.service.StringMessageProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * spring related configuration
 * scan / look for classes with spring specific annotation withih
 * the same or sub package
 * entry point for my spring environment => track of all the objects that spring manages
 * if spring creates object of a class => spring managed beans
 * JDK / JVM
 */
@ComponentScan
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        // NOT A SPRING MANAGeD BEAN
        // StringMessageProvider messageProvider = new StringMessageProvider();
        System.out.println();
        for(String beanName: context.getBeanDefinitionNames())
            System.out.println(beanName);

        StringMessageProvider messageProvider = (StringMessageProvider) context.getBean("stringMessageProvider");
        messageProvider.setMessage("Hey!!");
        System.out.println(messageProvider.getMessage());
    }
}
