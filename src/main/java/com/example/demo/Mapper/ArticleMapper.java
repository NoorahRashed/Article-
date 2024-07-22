package com.example.demo.Mapper;

import com.example.demo.dto.ArticleDto;
import com.example.demo.models.Article;

public class ArticleMapper {
    public static Article ArticleDto2Article(ArticleDto articleDto){
        return Article.builder()
                .articleid(articleDto.getArticleid())
                .author(articleDto.getAuthor())
                .title(articleDto.getTitle())
                .body(articleDto.getBody())
                .articledate(articleDto.getArticledate())
                .Likes(articleDto.getLikes())
                .DisLikes(articleDto.getDisLikes())
                .Disabled(articleDto.isDisabled())
                .build();
    }
    public static ArticleDto Article2ArticleDto(Article article){
        return ArticleDto.builder()
                .articleid(article.getArticleid())
                .author(article.getAuthor())
                .title(article.getTitle())
                .body(article.getBody())
                .articledate(article.getArticledate())
                .Likes(article.getLikes())
                .DisLikes(article.getDisLikes())
                .Disabled(article.isDisabled())
                .build();
    }
}


