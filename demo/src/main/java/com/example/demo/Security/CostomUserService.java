//package com.example.demo.Security;
//
//import com.example.demo.excption.UserNotFoundExcption;
//import com.example.demo.models.User;
//import com.example.demo.models.reposetory.UserRebo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.Collectors;
//
//@Service
//public class CostomUserService implements UserDetailsService {
//    private UserRebo userRebo;
//    @Autowired
//    public CostomUserService(UserRebo userRebo) {
//        this.userRebo = userRebo;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username)throws UserNotFoundExcption {
//        User user= userRebo.findByUsername(username)
//                .orElseThrow(()->new UsernameNotFoundException("User Name Not Found"));
//        return new org.springframework.security.core.userdetails.User(user.getUsername()
//                ,user.getPassword(),user.getRoles().stream()
//                .map(role -> new GrantedAuthority() {
//                 @Override
//                 public String getAuthority() {
//                     return role.getRoleName();}
//                })
//                .collect(Collectors.toList()));
//    }
//
//}
