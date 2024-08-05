package com.example.demo.Mapper;

import com.example.demo.dto.CommentDto;
import com.example.demo.models.Comment;

public class CommentMapper {
    public static Comment CommentDto2Comment(CommentDto commentDto){
        return Comment.builder()
                .commentid(commentDto.getCommentid())
                .username(commentDto.getUsername())
                .text(commentDto.getText())
                .commentdate(commentDto.getCommentdate())
                .build();
    }
    public static CommentDto Comment2CommentDto(Comment comment){
        return CommentDto.builder()
                .commentid(comment.getCommentid())
                .username(comment.getUsername())
                .text(comment.getText())
                .commentdate(comment.getCommentdate())
                .build();
    }
}
