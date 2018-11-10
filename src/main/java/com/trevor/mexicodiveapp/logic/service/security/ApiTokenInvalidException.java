package com.trevor.mexicodiveapp.logic.service.security;

public class ApiTokenInvalidException extends RuntimeException {
    public ApiTokenInvalidException(String message) {
        super(message);
    }
}
