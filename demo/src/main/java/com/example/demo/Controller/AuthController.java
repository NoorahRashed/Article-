//package com.example.demo.Controller;
//
//import com.example.demo.dto.RegisterDto;
//import com.example.demo.models.User;
//import com.example.demo.models.reposetory.RoleRebo;
//import com.example.demo.models.reposetory.UserRebo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping
//public class AuthController {
//    private AuthenticationManager authenticationManager;
//    private UserRebo userRebo;
//    private RoleRebo roleRebo;
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    public AuthController(AuthenticationManager authenticationManager,
//                          UserRebo userRebo, RoleRebo roleRebo, PasswordEncoder passwordEncoder) {
//        this.authenticationManager = authenticationManager;
//        this.userRebo = userRebo;
//        this.roleRebo = roleRebo;
//        this.passwordEncoder = passwordEncoder;
//    }
//    @PostMapping("register")
//    public ResponseEntity<String> register (@RequestBody RegisterDto registerDto){
//        if(userRebo.existsByusername(registerDto.getUsername())){
//            return new ResponseEntity<>("username is taken! ", HttpStatus.BAD_REQUEST);
//        }
//        User user =new User();
//        user.setUsername(registerDto.getUsername());
//        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//
//
//    }
//}
