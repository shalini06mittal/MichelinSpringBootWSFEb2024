package com.demo;

import com.demo.coll.CollectionDemo;
import com.demo.jdbc.Book;
import com.demo.jdbc.BookDatabase;
import com.demo.service.BillingService;
import com.demo.service.LazyService;
import com.demo.service.NotificationService;
import com.demo.service.StringMessageProvider;
import com.payment.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * spring related configuration
 * scan / look for classes with spring specific annotation withih
 * the same or sub package
 * entry point for my spring environment => track of all the objects that spring manages
 * if spring creates object of a class => spring managed beans
 * JDK / JVM
 */
@ComponentScan//(basePackages = {"config","com.demo"})

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        // NOT A SPRING MANAGeD BEAN
        // StringMessageProvider messageProvider = new StringMessageProvider();

        System.out.println("beans loaded");

    //    context.getBean(LazyService.class);
//        for(String beanName: context.getBeanDefinitionNames())
//            System.out.println(beanName);

//        StringMessageProvider messageProvider = context.getBean(StringMessageProvider.class);
//        StringMessageProvider messageProvider = (StringMessageProvider) context.getBean("ob");
//        System.out.println(messageProvider.getMessage());
//        messageProvider.setMessage("Hey from spring bean");
//        System.out.println(messageProvider.getMessage());

        /**
         * Scoping
         */
//        System.out.println("lets see if beans created!!");
//        StringMessageProvider messageProvider1 = context.getBean(StringMessageProvider.class);
//        System.out.println(messageProvider1.getMessage());
//        System.out.println();
//        StringMessageProvider messageProvider2 = context.getBean(StringMessageProvider.class);
//        System.out.println(messageProvider2.getMessage());
//        messageProvider1.setMessage("changed");
//        System.out.println();
//        System.out.println(messageProvider1.getMessage());
//        System.out.println(messageProvider2.getMessage());

        /**
         * Autowired
         */
//        NotificationService notificationService = context.getBean(NotificationService.class);
//        System.out.println(notificationService.getMessageProvider());
//        notificationService.sendMessage();

        /**
         * Payment Project
         */
//        BillingService billingService = context.getBean(BillingService.class);
//        billingService.callService();

        /**
         * Collection Demo
         */
//        CollectionDemo collectionDemo = context.getBean(CollectionDemo.class);
//        System.out.println(collectionDemo.getFruits());

        /**
         * database
         */
        BookDatabase bookDatabase = context.getBean(BookDatabase.class);
        System.out.println(bookDatabase.getJdbcTemplate());
        System.out.println(bookDatabase.getBookCount());
      //  bookDatabase.insertBook(new Book(2,"HTML",454));
        bookDatabase.queryForBook(1);
        bookDatabase.queryForBooks();

    }
    // @Bean: only used at method level definition
    @Bean
    public PaymentService createPaymentService()
    {
      //  System.out.println("payment service object...");
        return  new PaymentService();
    }
}
