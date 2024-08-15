package com.example.demo.excption;

public class NotFoundExcption extends RuntimeException{
    public NotFoundExcption(String massege){
        super(massege);
    }
}
