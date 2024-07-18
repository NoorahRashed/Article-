package com.example.demo.Controller;

import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> saveuser(@RequestBody User user){
        return ResponseEntity.ok(userService.insertuser(user));
    }

}
//////////////////////////////////////////////////////  SECURITY  //////////////////////////////////////////////////////
//SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//            http.authorizeHttpRequests((requests) -> {
//                ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
//            });
//            http.formLogin(Customizer.withDefaults());
//            http.httpBasic(Customizer.withDefaults());
//            return (SecurityFilterChain)http.build();
//        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////