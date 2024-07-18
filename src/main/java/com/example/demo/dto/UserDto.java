package com.example.demo.dto;

import com.example.demo.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer userid;
    private String username;
    private String email;
    private String mobilenumber;
    private String password;
    private List<Comment> comments;
    }