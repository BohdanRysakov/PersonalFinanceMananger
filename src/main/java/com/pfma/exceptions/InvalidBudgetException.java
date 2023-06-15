package com.pfma.exceptions;

public class InvalidBudgetException extends RuntimeException{
    public InvalidBudgetException(String message) {
        super(message);
    }
}
