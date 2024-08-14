package com.example.demo.service;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.dto.UserDto;
import com.example.demo.excption.EmailNotUnaqeExcption;
import com.example.demo.excption.UsernameNotFoundExcption;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.models.reposetory.RoleRebo;
import com.example.demo.models.reposetory.UserRebo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
@CrossOrigin("http://localhost:4200")
@Service
public class UserService1 {
    private UserRebo userrebo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private RoleRebo roleRebo;

    @Autowired
    public UserService1(UserRebo userrebo, BCryptPasswordEncoder bCryptPasswordEncoder,RoleRebo roleRebo) {
        this.userrebo = userrebo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRebo=roleRebo;
    }

    public UserDto insertuser (User user){
        if(userrebo.existsByEmail(user.getEmail())){
            throw new EmailNotUnaqeExcption("Email Already exists"+user.getEmail());
        }
        if(userrebo.existsByusername(user.getUsername())){
            throw new UsernameNotFoundExcption("username is taken! "+user.getUsername());
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole=roleRebo.findRoleByRoleName("USER");
        if (userRole==null){
            userRole=new Role();
            userRole.setRoleName("USER");
            roleRebo.save(userRole);
        }
        userRole.setRoleName("USER");
//        user.setRoles(new HashSet<>());
        user.getRoles().add(userRole);
        return UserMapper.Entity2UserDto(this.userrebo.save(user));

    }


    //public abstract UserDetails loadUserByUsername(String username)throws UserNotFoundExcption;
}
