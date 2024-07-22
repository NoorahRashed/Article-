package com.example.demo.excption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(EmailNotUnaqeExcption.class)
    public ResponseEntity<String> handelEmailNotUnaqeExcption(EmailNotUnaqeExcption ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ArticleNotFoundExcption.class)
    public ResponseEntity<String> handelArticleNotFoundExcption(ArticleNotFoundExcption ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserNotFoundExcption.class)
    public ResponseEntity<String> handelUserNotFoundExcption(UserNotFoundExcption ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
