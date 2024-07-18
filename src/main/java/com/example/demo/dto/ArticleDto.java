package com.example.demo.dto;


import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {
    private Integer articleid;
    private String author;
    private String title;
    private String body;
    private LocalDateTime articledate;
    private User user;
    private int Likes;
    private int DisLikes;
    private boolean Disabled;

}
