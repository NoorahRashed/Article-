package com.example.demo.reposetory;

import com.example.demo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
public interface RoleRebo extends JpaRepository<Role,Integer> {
    Role findRoleByRoleName(String rolename);

}