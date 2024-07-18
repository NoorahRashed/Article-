package com.example.demo.Controller;

import com.example.demo.Mapper.ArticleMapper;
import com.example.demo.Mapper.CommentMapper;
import com.example.demo.dto.ArticleDto;
import com.example.demo.dto.CommentDto;
import com.example.demo.models.Article;
import com.example.demo.models.Comment;
import com.example.demo.service.ArticleService;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;
    private CommentService commentService;
    @Autowired
    public ArticleController(ArticleService articleService, CommentService commentService) {
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ArticleDto getarticle(@PathVariable("id") Integer id){
        return articleService.getarticle(id);
    }

    @GetMapping
    public ResponseEntity<List<ArticleDto>> getarticles(@RequestParam(value = "page",defaultValue = "0")int page
            , @RequestParam(value = "size",defaultValue = "10")int size){
        try {
            List<ArticleDto>articles=articleService.getarticles(page, size);
            if(articles.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(articles, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/{id}")
    public ResponseEntity<ArticleDto> addarticle(@PathVariable("id") Integer id,@RequestBody Article article){
        ResponseEntity<ArticleDto> article1=articleService.addarticle(id,article);
        return article1;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        articleService.delete(id);
    }
    @GetMapping("/{id}/comment")
    public ResponseEntity<List<Comment>> getcomment(@PathVariable("id") Integer id){
        return new ResponseEntity<>(commentService.getallcomments(id),HttpStatus.OK);
    }
    @PostMapping("/{id}/comment")
    public CommentDto addcomment(@RequestParam Integer userid, @PathVariable("id") Integer articleid, @RequestBody Comment comment){
        return CommentMapper.Comment2CommentDto(commentService.Addcomment(userid, articleid, comment));
    }
    @PostMapping("/{id}/like")
    public void PutLiks(@PathVariable("id")Integer id,@RequestParam Integer likeit){
         articleService.putliks(id,likeit);
    }
    @PutMapping("/{id}/dislike")
    public void PutdisLiks(@PathVariable("id")Integer id,@RequestParam Integer dislikeit){
        articleService.putdisliks(id,dislikeit);
    }
    @PutMapping("/{id}/disable")
    public void DisAble(@PathVariable("id")Integer id){
        articleService.disable(id);
    }
}
