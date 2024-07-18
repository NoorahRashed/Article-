package com.example.demo.Controller;


import com.example.demo.models.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/{id}")
    public List<Comment> getcomment(@PathVariable("id") Integer id){
        return commentService.getallcomments(id);
    }
    @PostMapping
    public Comment addcomment(@RequestParam Integer userid,@RequestParam Integer articleid,@RequestBody Comment comment){
        return commentService.Addcomment(userid, articleid, comment);
    }

}
