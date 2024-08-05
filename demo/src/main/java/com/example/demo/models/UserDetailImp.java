package com.example.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@EnableMethodSecurity
public class UserDetailImp implements UserDetails {

    private User user;

    @Autowired
    public UserDetailImp(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles= user.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
