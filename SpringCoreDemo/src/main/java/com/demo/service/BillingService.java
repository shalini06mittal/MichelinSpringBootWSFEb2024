package com.demo.service;

import com.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillingService {

    @Autowired
    PaymentService paymentService;

    public void callService(){
        System.out.println(paymentService.makePayment(1000,10));
    }
}
