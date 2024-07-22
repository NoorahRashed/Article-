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
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<ArticleDto> getarticle(@PathVariable("id") Integer id){
        return new ResponseEntity<>(articleService.getarticle(id),HttpStatus.OK);
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
    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/{id}")
    public ResponseEntity<ArticleDto> addarticle(@PathVariable("id") Integer id,@RequestBody Article article){
        Article article1=articleService.addarticle(id,article);
        return new ResponseEntity<>(ArticleMapper.Article2ArticleDto(article1),HttpStatus.OK);
    }
    @PreAuthorize("hasAnyAuthority('USER')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        articleService.delete(id);
    }

    @GetMapping("/{id}/comment")
    public ResponseEntity<List<Comment>> getcomment(@PathVariable("id") Integer id){
        return new ResponseEntity<>(commentService.getallcomments(id),HttpStatus.OK) ;
    }
    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/{id}/comment")
    public ResponseEntity<CommentDto> addcomment
            (@RequestParam Integer userid, @PathVariable("id") Integer articleid, @RequestBody Comment comment){
        return new ResponseEntity<>(CommentMapper.Comment2CommentDto
                (commentService.Addcomment(userid, articleid, comment)),HttpStatus.OK);
    }
    @PreAuthorize("hasAnyAuthority('USER')")
    @PutMapping("/{id}/like")
    public void PutLiks(@PathVariable("id")Integer id,@RequestParam Integer likeit){
        articleService.putliks(id,likeit);
    }
    @PreAuthorize("hasAnyAuthority('USER')")
    @PutMapping("/{id}/dislike")
    public void PutdisLiks(@PathVariable("id")Integer id,@RequestParam Integer dislikeit){
        articleService.putdisliks(id,dislikeit);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/{id}/disable")
    public void DisAble(@PathVariable("id")Integer id){
        articleService.disable(id);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/{id}/enable")
    public void Enable(@PathVariable("id")Integer id){
        articleService.enable(id);
    }
}
