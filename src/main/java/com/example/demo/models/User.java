package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "users")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;
    private String username;
    @Column(unique = true)
    private String email;
    private String mobilenumber;
    private String password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user-role",joinColumns = @JoinColumn(name = "Userid",referencedColumnName = "userid")
    ,inverseJoinColumns = @JoinColumn(name = "Roleid",referencedColumnName = "id"))
    private List<Role> roles;
}
//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//   private List<Article> articles;
/*
{
    "username" :"lana",
    "email":"lana@gmail.com",
    "mobilenumber":"0587438296",
    "password" :"lana123",

}

{
    "username" :"sara",
    "email":"sara@gmail.com",
    "mobilenumber":"0587269296",
    "password" :"sara123"
}

{
    "username" :"mona",
    "email":"mona@gmail.com",
    "mobilenumber":"0587496496",
    "password" :"mona123"
}

{
    "username" :"jana",
    "email":"jana@gmail.com",
    "mobilenumber":"0585398596",
    "password" :"jana123"
}

{
    "username" :"dalal",
    "email":"dalal@gmail.com",
    "mobilenumber":"05879542696",
    "password" :"dalal123"
}

{
    "username" :"jody",
    "email":"jody@gmail.com",
    "mobilenumber":"0587438296",
    "password" :"jody123"
}

*/
