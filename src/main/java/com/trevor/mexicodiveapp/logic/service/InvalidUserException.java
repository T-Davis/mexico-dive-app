package com.trevor.mexicodiveapp.logic.service;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException(String msg) {
        super(msg);
    }
}
