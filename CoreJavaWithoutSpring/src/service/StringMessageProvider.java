package service;

import java.util.Scanner;

public class StringMessageProvider implements  IMeesageProvider{

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public  String getMessage(){
        return message;
    }
}
