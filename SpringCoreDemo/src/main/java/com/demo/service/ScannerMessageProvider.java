package com.demo.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ScannerMessageProvider implements IMeesageProvider{

    public  String getMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter");
        return scanner.nextLine();

    }
}
