package com.demo.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    /**
     * 1. getMessage() : reads data from the Scanner
     * has a dependency on the object of type IMessageProvider
     * Dependency Injection : constructor / setter
     */
    @Autowired
    @Qualifier("scannerMessageProvider")
    IMeesageProvider messageProvider;

//    @Autowired
//    Validations validations;

    public NotificationService() {
        System.out.println("Notification service constructor");
    }

    public NotificationService(IMeesageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void setMessageProvider(IMeesageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public IMeesageProvider getMessageProvider() {
        return messageProvider;
    }

    public void sendMessage()
    {
//        messageProvider = new ScannerMessageProvider();
        String message = messageProvider.getMessage();
        System.out.println(message);
    }
}
