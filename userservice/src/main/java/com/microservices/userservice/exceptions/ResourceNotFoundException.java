package com.microservices.userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource Not Found !!");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
