package com.example.demo.Controller;

import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService1 userService;

    @Autowired
    public UserController(UserService1 userService) {
        this.userService = userService;
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<UserDto> adduser(@RequestBody User user){
        return new ResponseEntity<>(userService.insertuser(user), HttpStatus.OK);
    }

}
