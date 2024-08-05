package com.example.demo.excption;

public class EmailNotUnaqeExcption extends RuntimeException{
   // private static final long serialVerisionUID = 1;
    public EmailNotUnaqeExcption(String massege){
        super(massege);
    }
}
