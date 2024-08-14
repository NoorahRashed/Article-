package com.example.demo.Controller;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Security.JwtGenerator;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.models.reposetory.RoleRebo;
import com.example.demo.models.reposetory.UserRebo;
import com.example.demo.service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService1 userService;
    private UserRebo userRebo;
    private AuthenticationManager authenticationManager;

    private PasswordEncoder passwordEncoder;
    private JwtGenerator jwtGenerator;
    private RoleRebo roleRebo;

    @Autowired
    public UserController(UserService1 userService, UserRebo userRebo, AuthenticationManager authenticationManager
           , PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator,RoleRebo roleRebo) {
        this.userService = userService;
        this.userRebo = userRebo;
        this.authenticationManager = authenticationManager;

        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.roleRebo = roleRebo;
    }

//    @PreAuthorize("permitAll()")
    @PostMapping("register")
    public ResponseEntity<String> rgister(@RequestBody RegisterDto regiserDto){
        if (userRebo.existsByusername(regiserDto.getUsername())){
            return new ResponseEntity<>("Username is taken",HttpStatus.BAD_REQUEST);
        }
        User user= new User();
        user.setUsername(regiserDto.getUsername());
        user.setEmail(regiserDto.getEmail());
        user.setPassword(passwordEncoder.encode(regiserDto.getPassword()));
        user.setMobilenumber(regiserDto.getMobilenumber());
        Role role = roleRebo.findRoleByRoleName("USER");
        user.setRoles(Collections.singletonList(role));

        userRebo.save(user);
        return new ResponseEntity<>("you have registered success! ",HttpStatus.OK);
    }

    //    @PreAuthorize("permitAll()")
//    @PostMapping
//    public ResponseEntity<UserDto> adduser(@RequestBody User user){
//
//        return new ResponseEntity<>(userService.insertuser(user), HttpStatus.OK);
//    }

//    @PreAuthorize("permitAll()")
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token),HttpStatus.OK);
    }

}
