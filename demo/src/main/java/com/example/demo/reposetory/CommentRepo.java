package com.example.demo.reposetory;

import com.example.demo.models.Article;
import com.example.demo.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
