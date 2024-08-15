package com.example.demo.excption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler()
    public ResponseEntity<String> handelEmailNotUnaqeExcption(NotFoundExcption ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundExcption.class)
    public ResponseEntity<String> handelArticleNotFoundExcption(NotFoundExcption ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundExcption.class)
    public ResponseEntity<String> handelUserNotFoundExcption(NotFoundExcption ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
