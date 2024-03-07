package com.demo.SpringBootDemo.exception;

public class InvalidCredentialsException extends Exception{

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
