package com.example.forhitesh.errorhandling;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainErrorHandler {

    //Have a few methods here that has the exception handler annotation,
    //The annotation added class determines what will be returned after the error is thrown
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorModel> incorrectInputFromJSON(MethodArgumentNotValidException theException){
        ErrorModel theErr = new ErrorModel(theException.getMessage());
        return new ResponseEntity<>(theErr, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFound.class)
    ResponseEntity<ErrorModel> userNotFound(UserNotFound noUser){
        ErrorModel theErr = new ErrorModel(noUser.getMessage());
        return new ResponseEntity<>(theErr, HttpStatus.PRECONDITION_FAILED);
    }
}
