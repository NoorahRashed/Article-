package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/hi")
    public String hi(){
        return "THE STRING IS SHOWING UP , SAY HI";
    }
}
