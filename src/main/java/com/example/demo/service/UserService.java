package com.example.demo.service;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.dto.UserDto;
import com.example.demo.excption.EmailNotUnaqeExcption;
import com.example.demo.models.User;
import com.example.demo.models.reposetory.UserRebo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public abstract class UserService {

    private UserRebo userrebo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRebo userrebo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userrebo = userrebo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserDto insertuser (User user){
        if(userrebo.existsByEmail(user.getEmail())){
            throw new EmailNotUnaqeExcption("Email Already exists"+user.getEmail());
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return UserMapper.Entity2UserDto(this.userrebo.save(user));
    }

    //public abstract UserDetails loadUserByUsername(String username)throws UserNotFoundExcption;
}
