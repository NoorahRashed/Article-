package com.example.demo.Security;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.reposetory.UserRebo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetallsService implements UserDetailsService {
    private UserRebo userRebo;

    @Autowired
    public CustomUserDetallsService(UserRebo userRebo){
        this.userRebo=userRebo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRebo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("user name not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),Role2Authorities(user.getRoles()));
    }
    private Collection<GrantedAuthority>Role2Authorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
