package com.pfma.exceptions;

public class BudgetInfoNotFoundException extends RuntimeException{
    public BudgetInfoNotFoundException(String message) {
        super(message);
    }
}
