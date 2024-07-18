package com.example.demo.models.reposetory;

import com.example.demo.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article,Integer> {
    //public Article findArticleByDisabled(boolean disabled);
}
