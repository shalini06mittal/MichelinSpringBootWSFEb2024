package com.mvc.SpringBootMVCDemo.exception;

public class InvalidCredentialsException extends Exception{

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
