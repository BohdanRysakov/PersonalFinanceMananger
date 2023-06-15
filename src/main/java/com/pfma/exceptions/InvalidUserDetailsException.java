package com.pfma.exceptions;

public class InvalidUserDetailsException extends RuntimeException{
    public InvalidUserDetailsException(String message) {
        super(message);
    }
}
