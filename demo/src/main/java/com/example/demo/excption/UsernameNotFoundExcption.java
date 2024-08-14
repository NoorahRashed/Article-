package com.example.demo.excption;

public class UsernameNotFoundExcption  extends RuntimeException{
    public UsernameNotFoundExcption(String massege){
        super(massege);
    }
}
