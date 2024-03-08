package com.rest.SpringBootRestDemo.exception;

public class InvalidCredentialsException extends Exception{

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
