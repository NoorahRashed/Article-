package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;

public interface SecurityConfigation {
    DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception;
    @Bean
    PasswordEncoder passwordEncoder();
}
