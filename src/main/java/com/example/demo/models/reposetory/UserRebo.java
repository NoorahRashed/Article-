package com.example.demo.models.reposetory;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRebo extends JpaRepository<User,Integer> {

}
//    User findByUsername(String username);
//    User findByEmail(String email);