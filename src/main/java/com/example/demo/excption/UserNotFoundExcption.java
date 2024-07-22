package com.example.demo.excption;

public class UserNotFoundExcption extends RuntimeException{
    public UserNotFoundExcption(String massege){
        super(massege);
    }
}
