package com.example.demo;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/hi")
    public String hi(){
        return "THE STRING IS SHOWING UP , SAY HI";
    }
}
