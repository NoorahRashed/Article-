package com.example.demo.models.reposetory;

import com.example.demo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRebo extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(String name);
}
