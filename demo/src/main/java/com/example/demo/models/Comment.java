package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer commentid;
    private String username;
    @Size(max = 100,message = "the maximum character in the comment are 100")
    private String text;
    private LocalDateTime commentdate;
    @PrePersist
    protected void onCreate(){
        commentdate=LocalDateTime.now();
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user-id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article-id")
    private Article article;

    public void setUsername(String username) {
         this.username=username;
    }

    public String getUsername() {
        return user.getUsername();
    }
}
/*
{
        "text":"yes, agree"
}

{
        "text":"hhhhhhhh, true"
}

{
        "text":"this is so right"
}


*/