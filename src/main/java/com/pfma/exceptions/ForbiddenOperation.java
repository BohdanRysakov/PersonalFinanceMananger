package com.pfma.exceptions;

public class ForbiddenOperation extends RuntimeException{
    public ForbiddenOperation() {
    }

    public ForbiddenOperation(String message) {
        super(message);
    }
}
