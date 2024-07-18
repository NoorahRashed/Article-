package com.example.demo.Mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.models.User;

public class UserMapper {

    public static User UserDto2Entity(UserDto userDto){

        return User.builder()
                .userid(userDto.getUserid())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .mobilenumber(userDto.getMobilenumber())
                .build();
    }
    public static UserDto Entity2UserDto(User user){

        return UserDto.builder()
                .userid(user.getUserid())
                .username(user.getUsername())
                .email(user.getEmail())
                .mobilenumber(user.getMobilenumber())
                .build();
    }
}
