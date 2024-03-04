package com.demo.service;

import java.util.Scanner;

public class ScannerMessageProvider implements IMeesageProvider{

    public  String getMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter");
        return scanner.nextLine();

    }
}
