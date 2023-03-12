package com.sanketh.protium.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

// This annotation marks this class as a global exception handler for all controllers.
@ControllerAdvice
public class UserNotFoundAdvice {

    // This annotation specifies that this method handles UserNotFoundExceptions.
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    // This annotation specifies the HTTP status code to be returned when this exception is thrown.
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(UserNotFoundException exception){

        // Create a HashMap to hold the error message.
        Map<String,String> errorMap=new HashMap<>();
        // Add the error message to the HashMap.
        errorMap.put("errorMessage",exception.getMessage());

        // Return the HashMap with the error message.
        return errorMap;

    }

}
