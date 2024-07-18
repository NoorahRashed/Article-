package com.example.demo.service;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.models.reposetory.UserRebo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRebo userrebo;
    @Autowired
    public UserService(UserRebo userrebo) {
        this.userrebo = userrebo;
    }

    public UserDto insertuser(User user){
         return UserMapper.Entity2UserDto(this.userrebo.save(user));
    }
}
