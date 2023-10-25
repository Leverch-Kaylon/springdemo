package com.example.forhitesh.errorhandling;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String message) {
        super(message);
    }

}
