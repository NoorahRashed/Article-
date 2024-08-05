package com.example.demo.models.reposetory;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
public interface UserRebo extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    boolean existsByusername(String username);
    Optional<User> findByUsername(String username);
}
//    User findByUsername(String username);
//    User findByEmail(String email);