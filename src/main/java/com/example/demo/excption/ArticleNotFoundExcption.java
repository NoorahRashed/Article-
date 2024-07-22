package com.example.demo.excption;

public class ArticleNotFoundExcption extends RuntimeException{
    public ArticleNotFoundExcption(String massege){
        super(massege);
    }
}
