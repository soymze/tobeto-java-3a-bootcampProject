package com.bootcamp.com.bootcamp.core.exceptions.types;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String message){
        super(message);
    }
}
