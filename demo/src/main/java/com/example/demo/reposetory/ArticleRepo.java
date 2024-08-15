package com.example.demo.reposetory;

import com.example.demo.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ArticleRepo extends JpaRepository<Article,Integer> {
    //public Article findArticleByDisabled(boolean disabled);
}
