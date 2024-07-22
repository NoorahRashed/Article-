package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "articles")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleid;
    private String author;
    private String title;
    private String body;
    private LocalDateTime articledate;
    @PrePersist
    protected void onCreate(){
        articledate=LocalDateTime.now();
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user-id")
    private User user;
    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comment> comments;
    private int Likes;
    private int DisLikes;
    private boolean Disabled;


    public void setDisLikes(int disLikes) {
        int disL=this.getDisLikes();
        DisLikes =disL+disLikes;
    }
    public void setLikes(int likes) {
        int Lik=this.getLikes();
        Likes =Lik+likes;
    }

}
/*
{
        "title":"programing",
        "body":"Hello World is the most common word that any programmer will defiantly know. "
}
{
        "title":"Artificial intelligence ",
        "body":"in its broadest sense, is intelligence exhibited by machines, particularly computer systems. It is a field of research in computer science that develops and studies methods and software that enable machines to perceive their environment and use learning and intelligence to take actions that maximize their chances of achieving defined goals."
}
{
        "title":"Mental Health",
        "body":"Mental health includes our emotional, psychological, and social well-being. It affects how we think, feel, and act."
}
 */
