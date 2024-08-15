package com.example.demo.service;

import com.example.demo.Mapper.CommentMapper;
import com.example.demo.dto.CommentDto;
import com.example.demo.models.Article;
import com.example.demo.models.Comment;
import com.example.demo.models.User;
import com.example.demo.reposetory.ArticleRepo;
import com.example.demo.reposetory.CommentRepo;
import com.example.demo.reposetory.UserRebo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@Service
public class CommentService {

    private CommentRepo commentRepo;
    private UserRebo userRebo;
    private ArticleRepo articleRepo;
    @Autowired
    public CommentService(CommentRepo commentRepo, UserRebo userRebo, ArticleRepo articleRepo) {
        this.commentRepo = commentRepo;
        this.userRebo = userRebo;
        this.articleRepo = articleRepo;
    }

    public Comment Addcomment(Integer userid, Integer articleid, Comment comment){
        User user=userRebo.findById(userid).orElseThrow(()->new RuntimeException("I Can't Find The User"));
        Article article=articleRepo.findById(articleid).orElseThrow(()->new RuntimeException("I Can't Find The Article"));
        comment.setUser(user);
        comment.setArticle(article);
        comment.setText(comment.getText());
        comment.setUsername(comment.getUsername());
        return commentRepo.save(comment);

    }

    public List<CommentDto> getallcomments(Integer id) {
        Article article = articleRepo.findById(id).orElseThrow(() -> new RuntimeException("article not found"));
        return commentRepo.findAll().stream().filter(comment -> comment.getArticle()
                .getArticleid().equals(id)).map(CommentMapper::Comment2CommentDto).collect(Collectors.toList());
    }
}

