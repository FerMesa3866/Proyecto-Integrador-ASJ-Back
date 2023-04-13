package com.integrador.back.backintegrador.exception;

public class UnautorizedException extends RuntimeException{
    public UnautorizedException(String message) {
        super(message);
    }
}
