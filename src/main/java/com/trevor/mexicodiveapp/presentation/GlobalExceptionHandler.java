package com.trevor.mexicodiveapp.presentation;

import com.trevor.mexicodiveapp.logic.service.InvalidUserException;
import com.trevor.mexicodiveapp.logic.service.security.ApiTokenInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Token Invalid")
    @ExceptionHandler(ApiTokenInvalidException.class)
    private void handleInvalidToken(RuntimeException ex, WebRequest request) {
    }


    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid User")
    @ExceptionHandler(InvalidUserException.class)
    private void handleInvalidUser(RuntimeException ex, WebRequest request) {
    }
}
